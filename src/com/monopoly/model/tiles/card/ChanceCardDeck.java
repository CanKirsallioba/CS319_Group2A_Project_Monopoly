package com.monopoly.model.tiles.card;

import java.util.ArrayList;

public class ChanceCardDeck extends CardDeck {
    public ChanceCardDeck(ArrayList<Card> cardArrayList) {
        super(cardArrayList);
    }

    @Override
    public Card drawCard() {
        Card top;
        if (cardArrayList.size() == 0) {
            throw new RuntimeException("ChanceCardDeck is empty.");
        } else {
            top = cardArrayList.remove(0);
            cardArrayList.add(top);
        }
        return top;
    }
}
