package com.monopoly.model.player;

import com.monopoly.model.tiles.Tile;
import com.monopoly.model.tiles.card.Card;
import com.monopoly.model.tiles.property.TitleDeedCard;

import java.util.ArrayList;

public abstract class AbstractPlayer implements Player {
    private int taxOption;
    private ArrayList<TitleDeedCard> titleDeeds;
    private ArrayList<Card> cards;
    private int balance;
    private boolean bankrupt;
    private int consecutiveDoubleCount;

    // newly added
    private int inJailFor;
    private int currTileInd;
    private PlayerToken playerToken;
    private boolean isInJail;
    int totalWorth;
    int liquidTotalWorth;

    // possibly subject to change
    int getOutOfJailChoice;
    boolean bailsOut;
    static final int BAIL_OUT_OF_JAIL_USING_CARD = 100;
    static final int BAIL_OUT_OF_JAIL_USING_MONEY = 101;
    static final int BAIL_OUT_OF_JAIL_USING_DICE  = 102;


    AbstractPlayer( ) {

    }

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

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isBankrupt() {
        return bankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
    }

    public void setConsecutiveDoubleCount(int consecutiveDoubleCount) {
        this.consecutiveDoubleCount = consecutiveDoubleCount;
    }


    /**
    *   If player has waited in jail for less than 3 turns,
    *   waits the player in the jail for 1 turn, without doing anything. Returns true in this case.
    *   Otherwise returns false.
    */
    @Override
    public boolean waitInJail() {
        if( inJailFor < 3){
            inJailFor++;
            return true;
        }
        else{
            return false;
        }
    }

    /**
    * Problematic !! Name needs to be changed
    * if player bails out, bails him out using selected method
    */
    @Override
    public void checkBailOut() {
        int bailOutCost = 0; // SUBJECT TO CHANGE

        // check if player bails out
        // apply the selected bail out procedure
        if (bailsOut) {
            if( getOutOfJailChoice == BAIL_OUT_OF_JAIL_USING_CARD){
                removeBailOutFromJailCard();

                isInJail = false;
                inJailFor = 0;
                bailsOut = false;
            }
            else if( getOutOfJailChoice == BAIL_OUT_OF_JAIL_USING_MONEY){
                changeBalance( bailOutCost);

                isInJail = false;
                inJailFor = 0;
                bailsOut = false;
            }
            else if( getOutOfJailChoice == BAIL_OUT_OF_JAIL_USING_DICE){
                if(consecutiveDoubleCount == 1){

                    isInJail = false;
                    inJailFor = 0;
                    bailsOut = false;
                }
            }
        }

        // if cannot bail out with choice at turn 3
        // force player to bail out or declare bankruptcy
        if( !waitInJail()){ // inJailFor is updated in waitInJail
            if( liquidTotalWorth < bailOutCost){
                // force bankruptcy
                declareBankruptcy();
            }
            else{
                changeBalance( bailOutCost);

                isInJail = false;
                inJailFor = 0;
                bailsOut = false;
            }
        }
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
    * Calls the PlayerToken's move method to move the player on the board by specified amount.
    * Updates currTileInd accordingly.
    * @param amount is the number of tiles to go.
     */
    @Override
    public void moveToken(int amount) {
        currTileInd = playerToken.move(amount).getIndex();
    }

    /**
    * Sends player to jail by calling the PlayerToken's gotoJail method.
     */
    @Override
    public void goToJail() {
        isInJail = true;
        playerToken.goToJail();
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
    * Changes the balance.
    * @param amount is the change in the balance.
     */
    @Override
    public void changeBalance(int amount) {
        balance += amount;
    }

    // SUBJECT TO IMPORTANT CHANGES
    @Override
    public void declareBankruptcy() {
        bankrupt = true;
    }

    /**
    * @return the currTileInd
     */
    @Override
    public int getCurrentTileIndex() {
        return currTileInd;
    }

    /**
    * @return the selected taxOption
     */
    @Override
    public int getTaxOption() {
        return taxOption;
    }

    /**
    * Updated the taxOption according to param
    * @param selectedOption is the option player selected for paying income tax.
     */
    @Override
    public void setTaxOption( int selectedOption) {
        this.taxOption = selectedOption;
    }

    /**
    * @return balance
     */
    @Override
    public int getBalance() {
        return balance;
    }

    /**
    * @return consecutiveDoubleCount
     */
    @Override
    public int getConsecutiveDoubleCount() {
        return consecutiveDoubleCount;
    }

    /**
    * @return the type of player's token as a String
     */
    @Override
    public String getTokenType() {
        return playerToken.getType();
    }
}
