package model;

import model.player.Player;
import model.tiles.property.TitleDeedCard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

public class TradeModel extends Observable implements Serializable {
    Player player1;
    Player player2;
    ArrayList<TitleDeedCard> titleDeedCardsPlayer1;
    ArrayList<TitleDeedCard> titleDeedCardsPlayer2;
    int moneyPlayer1;
    int moneyPlayer2;
    boolean AIAccepts;

    /**
     *
     * @param player1 proposing player
     * @param player2 proposed player
     */
    public void startTrade(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        setChanged();
        notifyObservers();
    }

    /**
     * completes the trade
     */
    public void completeTrade() {
        player1 = null;
        titleDeedCardsPlayer1 = null;
        titleDeedCardsPlayer2 = null;
        moneyPlayer1 = 0;
        moneyPlayer2 = 0;
        AIAccepts = false;
        player2 = null;
    }

    /**
     * cancels the trade
     */
    public void cancelTrade() {

        player1 = null;
        titleDeedCardsPlayer1 = null;
        titleDeedCardsPlayer2 = null;
        moneyPlayer1 = 0;
        moneyPlayer2 = 0;
        AIAccepts = false;
        player2 = null;
    }

    /**
     *
     * @return proposing player
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     *
     * @param player1 proposing player
     */
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    /**
     *
     * @return proposed player
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     *
     * @param player2 proposed player
     */
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    /**
     *
     * @return proposing player's titledeeds
     */
    public ArrayList<TitleDeedCard> getTitleDeedCardsPlayer1() {
        return titleDeedCardsPlayer1;
    }

    /**
     *
     * @param titleDeedCardsPlayer1 proposing player's titledeeds
     */
    public void setTitleDeedCardsPlayer1(ArrayList<TitleDeedCard> titleDeedCardsPlayer1) {
        this.titleDeedCardsPlayer1 = titleDeedCardsPlayer1;
    }

    /**
     *
     * @return proposed player's titledeeds
     */
    public ArrayList<TitleDeedCard> getTitleDeedCardsPlayer2() {
        return titleDeedCardsPlayer2;
    }

    /**
     *
     * @param titleDeedCardsPlayer2 proposed player's titledeeds
     */
    public void setTitleDeedCardsPlayer2(ArrayList<TitleDeedCard> titleDeedCardsPlayer2) {
        this.titleDeedCardsPlayer2 = titleDeedCardsPlayer2;
    }

    /**
     *
     * @return proposing player's money
     */
    public int getMoneyPlayer1() {
        return moneyPlayer1;
    }

    /**
     *
     * @param moneyPlayer1 proposing player's money
     */
    public void setMoneyPlayer1(int moneyPlayer1) {
        this.moneyPlayer1 = moneyPlayer1;
    }

    /**
     *
     * @return proposed player's money
     */
    public int getMoneyPlayer2() {
        return moneyPlayer2;
    }

    /**
     *
     * @param moneyPlayer2 proposed player's money
     */
    public void setMoneyPlayer2(int moneyPlayer2) {
        this.moneyPlayer2 = moneyPlayer2;
    }

    /**
     *
     * @return if ai accepts
     */
    public boolean isAIAccepts() {
        return AIAccepts;
    }

    /**
     *
     * @param AIAccepts if ai accepts
     */
    public void setAIAccepts(boolean AIAccepts) {
        this.AIAccepts = AIAccepts;
    }

}
