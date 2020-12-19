package model.tiles.card;

import java.util.ArrayList;

public class CommunityChestCardDeck extends CardDeck {
    /**
     * Constructor for the community chest deck, calls the super constructor.
     * @param cardArrayList is the list of the cards.
     */
    public CommunityChestCardDeck(ArrayList<Card> cardArrayList) {
        super(cardArrayList);
    }

    /**
     * Overriden method for drawing a card form the list of cards.
     * @return the card that is drawn.
     */
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
