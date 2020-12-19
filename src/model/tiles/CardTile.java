package model.tiles;

import model.player.Player;
import model.tiles.card.Card;
import model.tiles.card.CardDeck;

import java.util.ArrayList;

public class CardTile extends Tile {
    CardDeck cardDeck;
    // this will be set board builder

    @Override
    protected ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions) {
        Card card = cardDeck.drawCard();
        player.setCurrentlyDrawnCard(card);

        setActive(actions, "Apply", true);

        return actions;
    }

    public void setCardDeck( CardDeck cardDeck){
        this.cardDeck = cardDeck;
    }

    public CardDeck getCardDeck(){
        return cardDeck;
    }
}
