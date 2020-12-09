package com.monopoly.model.player;

import com.monopoly.model.board.Dice;
import com.monopoly.model.tiles.card.Card;
import com.monopoly.model.tiles.property.TitleDeedCard;

import java.io.Serializable;


public interface Player extends Serializable {
    Dice rollDice();
    void waitInJail();
    void checkBailOut();
    void addBailOutFromJailCard(Card card);
    void removeBailOutFromJailCard();
    void moveToken(int amount);
    void goToJail();
    void addTitleDeedCard(TitleDeedCard card);
    void removeTitleDeedCard(TitleDeedCard card);
    void changeBalance(int amount);
    void declareBankruptcy();
    int getCurrentTileIndex();
    int getTaxOption();
    int setTaxOption();
    int getBalance();
    int getConsecutiveDoubleCount();
    String getTokenType();
}
