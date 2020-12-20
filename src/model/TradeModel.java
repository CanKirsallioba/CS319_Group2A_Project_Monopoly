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

    public void startTrade(Player player1, Player player2) {
        setChanged();
        notifyObservers();
    }

    public void completeTrade() {
        // todo complete the trade.
        player1 = null;
        player2 = null;
        setChanged();
        notifyObservers();
    }

    public void cancelTrade() {
        // todo clear everything
        player1 = null;
        player2 = null;
        setChanged();
        notifyObservers();
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public ArrayList<TitleDeedCard> getTitleDeedCardsPlayer1() {
        return titleDeedCardsPlayer1;
    }

    public void setTitleDeedCardsPlayer1(ArrayList<TitleDeedCard> titleDeedCardsPlayer1) {
        this.titleDeedCardsPlayer1 = titleDeedCardsPlayer1;
    }

    public ArrayList<TitleDeedCard> getTitleDeedCardsPlayer2() {
        return titleDeedCardsPlayer2;
    }

    public void setTitleDeedCardsPlayer2(ArrayList<TitleDeedCard> titleDeedCardsPlayer2) {
        this.titleDeedCardsPlayer2 = titleDeedCardsPlayer2;
    }

    public int getMoneyPlayer1() {
        return moneyPlayer1;
    }

    public void setMoneyPlayer1(int moneyPlayer1) {
        this.moneyPlayer1 = moneyPlayer1;
    }

    public int getMoneyPlayer2() {
        return moneyPlayer2;
    }

    public void setMoneyPlayer2(int moneyPlayer2) {
        this.moneyPlayer2 = moneyPlayer2;
    }


    public boolean isAIAccepts() {
        return AIAccepts;
    }

    public void setAIAccepts(boolean AIAccepts) {
        this.AIAccepts = AIAccepts;
    }

}
