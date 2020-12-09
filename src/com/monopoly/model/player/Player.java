package com.monopoly.model.player;

import com.monopoly.model.board.Dice;
import com.monopoly.model.tiles.Tile;
import com.monopoly.model.tiles.card.Card;
import com.monopoly.model.tiles.property.TitleDeedCard;

import java.io.Serializable;
import java.util.ArrayList;


public interface Player extends Serializable {
    Dice rollDice();
    boolean waitInJail();
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
    void setTaxOption( int selectedOption);
    int getBalance();
    int getConsecutiveDoubleCount();
    String getTokenType();
    void setTokenType(String type);
    void setCurrentTileIndex( int index);
    void startAuction(ArrayList<TitleDeedCard> tDC);
// methods should be added.
    void payBailOutMoney();

    void throwDoubleDice();

    void useBailOutOfJailCard();

    Tile getCurrentTile();

    TitleDeedCard getSelectedTitleDeedCard();

    Object getToken();
}
