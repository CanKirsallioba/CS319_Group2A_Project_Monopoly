package com.monopoly.model;

import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.property.TitleDeedCard;

import java.util.ArrayList;
import java.util.Observable;

public class TradeModel extends Observable {
    Player player1;
    Player player2;
    ArrayList<TitleDeedCard> titleDeedCardsPlayer1;
    ArrayList<TitleDeedCard> titleDeedCardsPlayer2;
    int moneyPlayer1;
    int moneyPlayer2;

    public void startTrade(Player player1, Player player2) {

    }

    public void completeTrade() {

    }

    public void cancelTrade() {

    }


}
