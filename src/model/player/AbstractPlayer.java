package model.player;

import model.AuctionModel;
import model.TradeModel;
import model.tiles.JailTile;
import model.tiles.Tile;
import model.tiles.card.Card;
import model.tiles.property.TitleDeedCard;

import java.util.ArrayList;
import java.util.Observable;

public abstract class AbstractPlayer extends Observable implements Player  {
    private TaxOption taxOption;
    private ArrayList<TitleDeedCard> titleDeeds;
    private ArrayList<Card> bailOutOfJailCards;
    private int balance;
    private boolean bankrupt;
    private int consecutiveDoubleCount;
    private int numberOfTurnsSpentInJail;
    private int currentTileIndex;
    private PlayerToken playerToken;
    private boolean isInJail;
    int totalWorth;
    int liquidTotalWorth;
    BailOutChoice getOutOfJailChoice;
    boolean canBailOut;
    AuctionModel auctionModel;
    TradeModel tradeModel;
    TitleDeedCard selectedTitleDeed;
    Card drawnCard;
    Dice playersDice;
    Tile currentTile;

    /**
     * Default constructor for AbstractPlayer.
     */
    AbstractPlayer() {
        titleDeeds = new ArrayList<>();
        bailOutOfJailCards = new ArrayList<>();
        bankrupt = false;
        consecutiveDoubleCount = 0;
        numberOfTurnsSpentInJail = 0;
        isInJail = false;
        totalWorth = 0;
        liquidTotalWorth = 0;
        getOutOfJailChoice = BailOutChoice.WAIT;
        taxOption = TaxOption.UNDETERMINED;
        setChanged();
        notifyObservers();
    }

    /**
     * Basic method for displaying the state of the player.
     * @return the state of the player as a String.
     */
    @Override
    public String toString() {
        //String titleDeedInfo = "{ ";
        //for (TitleDeedCard deed : titleDeeds){
          //  titleDeedInfo = titleDeedInfo + ", " + deed.getPropertyName();
        //}
        //titleDeedInfo = titleDeedInfo + " }";

        return "\n\nAbstractPlayer{" +
                //"\ntaxOption=" + taxOption.name() +
                ", \ntitleDeeds=" + titleDeeds.size() +
                ", \nbailOutOfJailCards=" + bailOutOfJailCards.size() +
                ", \nbalance=" + balance +
                ", \nbankrupt=" + bankrupt +
                ", \nconsecutiveDoubleCount=" + consecutiveDoubleCount +
                ", \nnumberOfTurnsSpentInJail=" + numberOfTurnsSpentInJail +
                ", \ncurrentTileIndex=" + currentTileIndex +
                ", \nisInJail=" + isInJail +
                ", \ntotalWorth=" + totalWorth +
                ", \nliquidTotalWorth=" + liquidTotalWorth +
                ", \ncanBailOut=" + canBailOut +
                ", \nselectedTitleDeed=" + ((selectedTitleDeed == null ) ? "" : selectedTitleDeed.getPropertyName()) +
                ", \ndrawnCard=" + ((drawnCard == null ) ? "" : drawnCard.getInstruction()) +
                ", \nplayersDice=" + playersDice.getDiceResultSum() +
                "}";
    }

    /**
     * @return player's Dice
     */
    @Override
    public Dice getPlayersDice() {
        return playersDice;
    }

    /**
     * setter method for player's Dice
     */
    @Override
    public void setPlayersDice(Dice playersDice) {
        this.playersDice = playersDice;
        setChanged();
        notifyObservers();
    }

    // abstract methods

    /**
     * Extending AIPlayer and HumanPlayer classes have their unique playTurn methods.
     */
    @Override
    public abstract void playTurn();

    // not getter-setter methods in the design report
    /**
     *   If player has waited in jail for less than 3 turns,
     *   waits the player in the jail for 1 turn, without doing anything. Returns true in this case.
     *   Otherwise returns false.
     */
    @Override
    public boolean waitInJail() {
        if( numberOfTurnsSpentInJail < 3){
            numberOfTurnsSpentInJail++;
            setChanged();
            notifyObservers();
            return true;
        }
        setChanged();
        notifyObservers();
        return false;

    }

    /**
     * if player bails out, bails him out using selected method
     */
    @Override
    public void checkBailOut() {
        int bailOutCost = playerToken.getBoard().getBoardSalary() / 4;

        // check if player can bail out
        // if he/she can, apply the selected bail out procedure

        // if bail out choice is by card && player has at least 1 bailout card in his inventory
        if (getOutOfJailChoice == BailOutChoice.BAIL_OUT_CARD && bailOutOfJailCards.size() > 0) {
            removeBailOutFromJailCard ();

            isInJail = false;
            numberOfTurnsSpentInJail = 0;

            System.out.println( "DEBUG: check bail out, get out of jail choice: card");
            setChanged();
            notifyObservers();
            return;

        // if bail out choice is by money && player has more money than the fine
        }
        else if (getOutOfJailChoice == BailOutChoice.MONEY && balance >= bailOutCost) {
            payBailOutMoney();

            isInJail = false;
            numberOfTurnsSpentInJail = 0;
            System.out.println( "DEBUG: check bail out, get out of jail choice: money");

            setChanged();
            notifyObservers();
            return;

        // if bail out choice is by dice && player threw a double dice
        }
        else if (getOutOfJailChoice == BailOutChoice.DOUBLE_DICE) {
            rollDice();

            if( consecutiveDoubleCount == 1){
                isInJail = false;
                numberOfTurnsSpentInJail = 0;
                System.out.println( "DEBUG: check bail out, get out of jail choice: double dice");

                setChanged();
                notifyObservers();
                return;
            }
        }

        // if cannot bail out with choice at turn 3
        // force player to bail out or declare bankruptcy
        if( !waitInJail()){ // turnsSpentInJail is updated in waitInJail, which is called at the end of every turn
            if( liquidTotalWorth < bailOutCost){
                // force bankruptcy
                declareBankruptcy();
                System.out.println( "DEBUG: check bail out, get out of jail choice: waitInJail = false, first half");

                setChanged();
                notifyObservers();
            }
            else{
                changeBalance( bailOutCost);

                isInJail = false;
                numberOfTurnsSpentInJail = 0;
                canBailOut = false;
                System.out.println( "DEBUG: check bail out, get out of jail choice: waitInJail = false, second half");

                setChanged();
                notifyObservers();
            }
        }
    }

    /**
     * Sends player to jail by calling the PlayerToken's gotoJail method.
     */
    @Override
    public void goToJail() {

        consecutiveDoubleCount = 0;
        isInJail = true;

        // send token to jail
        playerToken.goToJail();

        currentTile = playerToken.getCurrentTile();
        currentTileIndex = currentTile.getIndex();
        setChanged();
        notifyObservers();
    }

    /**
     * Changes the balance.
     * @param amount is the change in the balance.
     */
    @Override
    public void changeBalance(int amount) {
        balance += amount;
        setChanged();
        notifyObservers();
    }

    /**
     * If the player cannot pay his/her debt or resigns from the game
     * declare bankruptcy by setting bankrupt true
     */
    @Override
    public void declareBankruptcy() {
        bankrupt = true;
        setChanged();
        notifyObservers();
    }

    /**
     * Calls the PlayerToken's move method to move the player on the board by specified amount.
     * Updates currTileInd accordingly.
     * @param amount is the number of tiles to go.
     */
    @Override
    public void moveToken(int amount) {
        // update player's tile accordingly
        currentTile = playerToken.move(amount); // also move player's token
        currentTileIndex = currentTile.getIndex();

        // Update players balance
        if (playerToken.passedGoInTheLastMove()) {
            changeBalance(playerToken.getBoard().getBoardSalary() );
        }
        setChanged();
        notifyObservers();
    }

    /**
     * Delegates the starting of auction to its model.
     * @param titleDeeds is the properties to be auctioned.
     */
    @Override
    public void startAuction(ArrayList<TitleDeedCard> titleDeeds){
        auctionModel.startAuction(titleDeeds);
        setChanged();
        notifyObservers();
    }

    /**
     * Delegates the starting of trade to its model.
     * @param otherPlayer is the second player in the trade.
     */
    @Override
    public void startTrade( Player otherPlayer){
        tradeModel.startTrade(this, otherPlayer);
        setChanged();
        notifyObservers();
    }

    /**
     *  Adds the bailOutOfJail card to player's inventory.
     *  @param card is the card to add to the inventory.
     */
    @Override
    public void addBailOutFromJailCard(Card card) {
        bailOutOfJailCards.add( card);
        setChanged();
        notifyObservers();
    }

    /**
     * Removes the last from players bailOutOfJail cards.
     */
    @Override
    public void removeBailOutFromJailCard() {
        if( bailOutOfJailCards.size()>0){

            bailOutOfJailCards.remove( bailOutOfJailCards.size()-1);
            setChanged();
            notifyObservers();
        }
        else{
            System.out.println( " DEBUG: Error in Abstract Player, removeBailOutFromJailCard is invoked when there are no bail out cards!");
        }
    }

    /**
     * Adds the TitleDeedCard to player's titleDeeds.
     * @param card is the newly acquired TitleDeedCard.
     */
    @Override
    public void addTitleDeedCard(TitleDeedCard card) {
        titleDeeds.add( card);
        setChanged();
        notifyObservers();
    }

    /**
     * Removes the given TitleDeedCard from player's titleDeeds.
     * @param card is the card being removed.
     */
    @Override
    public void removeTitleDeedCard(TitleDeedCard card) {
        titleDeeds.remove( card);
        setChanged();
        notifyObservers();
    }

    /**
     * Sets getOutOfJailChoice to the parameter. Then calls checkBailOut to initiate further actions regarding jail.
     */
    @Override
    public void setGetOutOfJailChoice(BailOutChoice getOutOfJailChoice) {
        this.getOutOfJailChoice = getOutOfJailChoice;
        setChanged();
        notifyObservers();

        // check bail out notifies the observers and sets to changed on its own
        checkBailOut();
    }

    /**
     * Updates the state of the dice by rolling it again.
     * @return the Dice in its new state.
     */
    @Override
    public Dice rollDice() {
        playersDice.rollDice();

        if(playersDice.getDice1() == playersDice.getDice2()){
            setConsecutiveDoubleCount( getConsecutiveDoubleCount() + 1);
        } else {
            setConsecutiveDoubleCount ( 0 );
        }
        return playersDice;
    }

    /**
     * Pays the amount of money required to bail out of jail.
     */
    @Override
    public void payBailOutMoney() {
        changeBalance(-(playerToken.getBoard().getBoardSalary() / 4));
        setChanged();
        notifyObservers();
    }

    // getter and setter methods in the design
    /**
     * @return the selected taxOption
     */
    @Override
    public TaxOption getTaxOption() {
        return taxOption;
    }

    /**
     * Updates totalWorth and liquidTotalWorth
     */
    public void updatePlayerWorth(){
        int newTotalWorth = balance;
        int newLiquidTotalWorth = balance;

        for( TitleDeedCard currentTitleDeedCard : titleDeeds){
            newTotalWorth += currentTitleDeedCard.getPropertyValue();
            newLiquidTotalWorth += currentTitleDeedCard.getMortgageValue();

            int currentUpgradeLevel = currentTitleDeedCard.getUpgradeLevel();
            newTotalWorth += currentUpgradeLevel * currentTitleDeedCard.getUpgradeCost();
            newLiquidTotalWorth += (currentUpgradeLevel * currentTitleDeedCard.getUpgradeCost()) / 2;
        }

        totalWorth = newTotalWorth;
        liquidTotalWorth = newLiquidTotalWorth;
        setChanged();
        notifyObservers();
    }

    /**
     * Updated the taxOption according to param
     * @param selectedOption is the option player selected for paying income tax.
     */
    @Override
    public void setTaxOption( TaxOption selectedOption) {
        this.taxOption = selectedOption;
        setChanged();
        notifyObservers();
    }

    /**
     * @return balance
     */
    @Override
    public int getBalance() {
        return balance;
    }

    /**
     * setter method for the balance
     * @param balance is the value of balance.
     */
    @Override
    public void setBalance(int balance) {
        this.balance = balance;
        setChanged();
        notifyObservers();
    }

    /**
     * @return consecutiveDoubleCount
     */
    @Override
    public int getConsecutiveDoubleCount() {
        return consecutiveDoubleCount;
    }

    public void setConsecutiveDoubleCount(int consecutiveDoubleCount) {
        this.consecutiveDoubleCount = consecutiveDoubleCount;
    }

    /**
     * @return the current tile
     */
    @Override
    public Tile getCurrentTile() {
        return currentTile;
    }

    /**
     * setter method for the current tile
     * @param currentTile is the new tile player has landed on.
     */
    @Override
    public void setCurrentTile( Tile currentTile){
        this.currentTile = currentTile;
        setChanged();
        notifyObservers();
    }

    /**
     * @return the player's token
     */
    @Override
    public PlayerToken getPlayerToken() {
        return playerToken;
    }

    /**
     * setter method for playerToken
     * @param playerToken is the new token
     */
    @Override
    public void setPlayerToken( PlayerToken playerToken){
        this.playerToken = playerToken;
        setChanged();
        notifyObservers();
    }

    /**
     * getter method for getOutOfJailChoice
     * @return the getOutOfJailChoice
     */
    @Override
    public BailOutChoice getGetOutOfJailChoice() {
        return getOutOfJailChoice;
    }

    /**
     * getter method for totalWorth
     * @return the totalWorth
     */
    @Override
    public int getTotalWorth() {
        return totalWorth;
    }

    /**
     * setter method for totalWorth
     * @param totalWorth is the new totalWorth
     */
    @Override
    public void setTotalWorth(int totalWorth) {
        this.totalWorth = totalWorth;
        setChanged();
        notifyObservers();
    }

    /**
     * getter method for liquidTotalWorth
     * @return the liquidTotalWorth
     */
    @Override
    public int getLiquidTotalWorth() {
        return liquidTotalWorth;
    }

    /**
     * setter method for liquidTotalWorth
     * @param liquidTotalWorth is the new liquidTotalWorth
     */
    @Override
    public void setLiquidTotalWorth(int liquidTotalWorth) {
        this.liquidTotalWorth = liquidTotalWorth;
        setChanged();
        notifyObservers();
    }

    /**
     * getter method for auctionModel
     * @return the auctionModel
     */
    @Override
    public AuctionModel getAuctionModel() {
        return auctionModel;
    }

    /**
     * setter method for auctionModel
     * @param auctionModel is the new auctionModel
     */
    @Override
    public void setAuctionModel(AuctionModel auctionModel) {
        this.auctionModel = auctionModel;
        setChanged();
        notifyObservers();
    }

    /**
     * getter method for tradeModel
     * @return the tradeModel
     */
    @Override
    public TradeModel getTradeModel() {
        return tradeModel;
    }

    /**
     * setter method for tradeModel
     * @param tradeModel is the new tradeModel
     */
    @Override
    public void setTradeModel(TradeModel tradeModel) {
        this.tradeModel = tradeModel;
        setChanged();
        notifyObservers();
    }

    /**
     * getter method for bankrupt
     * @return bankrupt
     */
    public boolean isBankrupt() {
        return bankrupt;
    }

    /**
     * getter method for titleDeeds
     * @return titleDeeds
     */
    public ArrayList<TitleDeedCard> getTitleDeeds() {
        return titleDeeds;
    }

    /**
     * setter method for titleDeeds
     * @param titleDeeds is the new titleDeeds
     */
    public void setTitleDeeds(ArrayList<TitleDeedCard> titleDeeds) {
        this.titleDeeds = titleDeeds;
        setChanged();
        notifyObservers();
    }

    /**
     * getter method for bailOutOfJailCards
     * @return bailOutOfJailCards
     */
    public ArrayList<Card> getBailOutOfJailCards() {
        return bailOutOfJailCards;
    }

    /**
     * setter method for bailOutOfJailCards
     * @param bailOutOfJailCards is the new bailOutOfJailCards
     */
    public void setBailOutOfJailCards(ArrayList<Card> bailOutOfJailCards) {
        this.bailOutOfJailCards = bailOutOfJailCards;
        setChanged();
        notifyObservers();
    }

    /**
     * setter method for bankrupt
     * @param bankrupt is the new value of bankrupt
     */
    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
        setChanged();
        notifyObservers();
    }

    /**
     * getter method for selectedTitleDeed
     * @return selectedTitleDeed
     */
    @Override
    public TitleDeedCard getSelectedTitleDeed(){
        return selectedTitleDeed;
    }

    /**
     * setter method for selectedTitleDeed
     * @param selectedTitleDeed is the new selectedTitleDeed
     */
    public void setSelectedTitleDeed( TitleDeedCard selectedTitleDeed){
        this.selectedTitleDeed = selectedTitleDeed;
    }

    /**
     * getter method for drawnCard
     * @return drawnCard
     */
    public Card getCurrentlyDrawnCard() {
        return drawnCard;
    }

    /**
     * setter method for drawnCard
     * @param drawnCard is the new drawnCard
     */
    public void setCurrentlyDrawnCard(Card drawnCard) {
        this.drawnCard = drawnCard;
    }

    /**
     * getter method for isInJail
     * @return isInJail
     */
    public boolean isInJail() {
        return isInJail;
    }

    /**
     * setter method for isInJail
     * @param inJail is the new value of isInJail
     */
    public void setInJail(boolean inJail) {
        isInJail = inJail;
    }


}
