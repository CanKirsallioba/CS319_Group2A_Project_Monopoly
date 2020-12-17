package com.monopoly.model.tiles;

import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.card.Card;
import com.monopoly.model.tiles.card.CardDeck;

import java.util.ArrayList;

public class CardTile extends Tile {
    CardDeck cardDeck;
    // this will be set board builder

    @Override
    public ArrayList<GameAction> hook(Player player) {
        Card card = cardDeck.drawCard();
        player.setCurrentlyDrawnCard(card);

        setActive(actions, "Perform Instruction", true);

        return actions;
    }
}
