package com.monopoly.model.tiles.card;

import java.util.ArrayList;

public abstract class CardDeck {
    ArrayList<Card> cardArrayList;

    public CardDeck(ArrayList<Card> cardArrayList) {
        this.cardArrayList = cardArrayList;
    }

    public abstract Card drawCard();


    public ArrayList<Card> getCardArrayList() {
        return cardArrayList;
    }

    public void setCardArrayList(ArrayList<Card> cardArrayList) {
        this.cardArrayList = cardArrayList;
    }

}
