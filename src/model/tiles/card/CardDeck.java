package model.tiles.card;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class CardDeck implements Serializable {
    ArrayList<Card> cardArrayList;

    /**
     * Constructor for the CardDeck class.
     * @param cardArrayList is the list that holds the cards.
     */
    public CardDeck(ArrayList<Card> cardArrayList) {
        this.cardArrayList = cardArrayList;
    }

    /**
     * Abstract method for the draw card.
     * @return the Card that is drawn.
     */
    public abstract Card drawCard();

    /**
     * Getter method for the card arraylist.
     * @return the card arraylist.
     */
    public ArrayList<Card> getCardArrayList() {
        return cardArrayList;
    }

    /**
     * Setter method for the card arraylist.
     * @param cardArrayList is the list that holds the cards.
     */
    public void setCardArrayList(ArrayList<Card> cardArrayList) {
        this.cardArrayList = cardArrayList;
    }

}
