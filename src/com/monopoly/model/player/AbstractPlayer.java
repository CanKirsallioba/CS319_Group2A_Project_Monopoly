package com.monopoly.model.player;

import com.monopoly.model.AuctionModel;
import com.monopoly.model.TradeModel;
import com.monopoly.model.tiles.Tile;
import com.monopoly.model.tiles.card.Card;
import com.monopoly.model.tiles.property.TitleDeedCard;

import java.util.ArrayList;
import java.util.Observable;

public abstract class AbstractPlayer extends Observable implements Player  {
    private TaxOption taxOption;
    private ArrayList<TitleDeedCard> titleDeeds;
    private ArrayList<Card> cards;
    private int balance;
    private boolean bankrupt;
    private int consecutiveDoubleCount;
    private int turnsSpentInJail;
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

    // attributes not in the design
    Tile currentTile;

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
        if( turnsSpentInJail < 3){
            turnsSpentInJail++;
            return true;
        }
        else{
            return false;
        }
    }

    //TODO -- bailOutCost için initializer yazılmalı
    /**
     * if player bails out, bails him out using selected method
     */
    @Override
    public void checkBailOut() {
        int bailOutCost = 0; // TODO

        // check if player can bail out
        // if he/she can, apply the selected bail out procedure

        // if bail out choice is by card && player has at least 1 bailout card in his inventory
        if (getOutOfJailChoice == BailOutChoice.BAIL_OUT_CARD && cards.size() > 0) {
            removeBailOutFromJailCard ();

            isInJail = false;
            turnsSpentInJail = 0;
            return;

        // if bail out choice is by money && player has more money than the fine
        } else if (getOutOfJailChoice == BailOutChoice.MONEY && balance >= bailOutCost) {
            changeBalance (bailOutCost);

            isInJail = false;
            turnsSpentInJail = 0;
            return;

        // if bail out choice is by dice && player threw a double dice
        } else if (getOutOfJailChoice == BailOutChoice.DOUBLE_DICE) {
            rollDice();

            if( consecutiveDoubleCount == 1){
                isInJail = false;
                turnsSpentInJail = 0;
                return;
            }
        }

        // if cannot bail out with choice at turn 3
        // force player to bail out or declare bankruptcy
        if( !waitInJail()){ // turnsSpentInJail is updated in waitInJail
            if( liquidTotalWorth < bailOutCost){
                // force bankruptcy
                declareBankruptcy();
            }
            else{
                changeBalance( bailOutCost);

                isInJail = false;
                turnsSpentInJail = 0;
                canBailOut = false;
            }
        }
    }

    // TODO - Finalize design +++ Pending Code Review
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
    }

    /**
     * Changes the balance.
     * @param amount is the change in the balance.
     */
    @Override
    public void changeBalance(int amount) {
        balance += amount;
    }

    // TODO finalize design
    /**
     * If the player cannot pay his/her debt or resigns from the game
     * declare bankruptcy by setting bankrupt true
     */
    @Override
    public void declareBankruptcy() {
        bankrupt = true;
    }

    // TODO ADD MONEY TO PLAYER'S ACCOUNT IF PLAYER PASSED GO IN THE LAST MOVE
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

        if (playerToken.passedGoInTheLastMove()) {
            // TODO
        }
    }

    @Override
    public void startAuction(ArrayList<TitleDeedCard> titleDeeds){
        auctionModel.startAuction(titleDeeds);
    }

    @Override
    public void startTrade( Player otherPlayer){
        tradeModel.startTrade(this, otherPlayer);
    }

    /**
     *  Adds the bailOutOfJail card to player's inventory.
     *  @param card is the card to add to the inventory.
     */
    @Override
    public void addBailOutFromJailCard(Card card) {
        cards.add( card);
    }

    /**
     * Removes the last from players bailOutOfJail cards.
     */
    @Override
    public void removeBailOutFromJailCard() {
        cards.remove( cards.size()-1);
    }

    /**
     * Adds the TitleDeedCard to player's titleDeeds.
     * @param card is the newly acquired TitleDeedCard.
     */
    @Override
    public void addTitleDeedCard(TitleDeedCard card) {
        titleDeeds.add( card);
    }

    /**
     * Removes the given TitleDeedCard from player's titleDeeds.
     * @param card is the card being removed.
     */
    @Override
    public void removeTitleDeedCard(TitleDeedCard card) {
        titleDeeds.remove( card);
    }

    /**
     * Sets getOutOfJailChoice to the parameter. Then calls checkBailOut to initiate further actions regarding jail.
     */
    @Override
    public void setGetOutOfJailChoice(BailOutChoice getOutOfJailChoice) {
        this.getOutOfJailChoice = getOutOfJailChoice;
        checkBailOut();
    }

    @Override
    public Dice rollDice() {
        playersDice.rollDice();

        if(playersDice.getDice1() == playersDice.getDice2()){
            setConsecutiveDoubleCount( getConsecutiveDoubleCount() + 1);
        }

        return playersDice;
    }

    // TODO bailOutMoney'e erisim yok checkBailOu'takiyle ayni sekilde
    @Override
    public void payBailOutMoney() {

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
     * Updated the taxOption according to param
     * @param selectedOption is the option player selected for paying income tax.
     */
    @Override
    public void setTaxOption( TaxOption selectedOption) {
        this.taxOption = selectedOption;
    }

    /**
     * @return balance
     */
    @Override
    public int getBalance() {
        return balance;
    }


    public void setBalance(int balance) {
        this.balance = balance;
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

    @Override
    public Tile getCurrentTile() {
        return currentTile;
    }

    @Override
    public void setCurrentTile( Tile currentTile){
        this.currentTile = currentTile;
    }

    @Override
    public PlayerToken getPlayerToken() {
        return playerToken;
    }

    @Override
    public void setPlayerToken( PlayerToken playerToken){
        this.playerToken = playerToken;
    }

    @Override
    public BailOutChoice getGetOutOfJailChoice() {
        return getOutOfJailChoice;
    }

    @Override
    public int getTotalWorth() {
        return totalWorth;
    }

    @Override
    public void setTotalWorth(int totalWorth) {
        this.totalWorth = totalWorth;
    }

    @Override
    public int getLiquidTotalWorth() {
        return liquidTotalWorth;
    }

    @Override
    public void setLiquidTotalWorth(int liquidTotalWorth) {
        this.liquidTotalWorth = liquidTotalWorth;
    }

    @Override
    public AuctionModel getAuctionModel() {
        return auctionModel;
    }

    @Override
    public void setAuctionModel(AuctionModel auctionModel) {
        this.auctionModel = auctionModel;
    }

    @Override
    public TradeModel getTradeModel() {
        return tradeModel;
    }

    @Override
    public void setTradeModel(TradeModel tradeModel) {
        this.tradeModel = tradeModel;
    }

    public boolean isBankrupt() {
        return bankrupt;
    }

    // end of getter & setters in the design

    // TODO determine whether these methods are going to stay
    // setters and getters not in the design
    public ArrayList<TitleDeedCard> getTitleDeeds() {
        return titleDeeds;
    }

    public void setTitleDeeds(ArrayList<TitleDeedCard> titleDeeds) {
        this.titleDeeds = titleDeeds;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
    }



//    /**
//    * @return the currTileInd
//     */
//    @Override
//    public int getCurrentTileIndex() {
//        return currTileInd;
//    }

//    /**
//    * @return the type of player's token as a String
//     */
//    @Override
//    public String getTokenType() {
//        return playerToken.getType();
//    }
//
//    /**
//     * set the playerToken's type
//     * @param type is the type of the playerToken
//     */
//    @Override
//    public void setTokenType(String type){
//        this.playerToken.setType( type);
//    }
//
//    /**
//     * set the playerToken's type
//     * @param index is the current tile's index
//     */
//    @Override
//    public void setCurrentTileIndex(int index){
//        currTileInd = index;
//        playerToken.teleport( index); // faulty-naming but works in principle
//    }
//
}
