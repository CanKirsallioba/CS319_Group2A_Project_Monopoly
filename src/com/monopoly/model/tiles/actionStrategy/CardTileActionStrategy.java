package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.card.Card;

public class CardTileActionStrategy extends ActionStrategy {
    /**
     * This method allows the player to draw and apply what the card commands.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button1Strategy(Player player) {
        /*
        Instructions:
        "forward"
        "backward"
        "move to"
        "pay"
        "receive"
        "go to jail"
        "bail out of jail"
         */

        Card drawnCard = player.getDrawnCard();
        if (drawnCard.getCardDetails().containsKey("bail out of jail")) {
            //player adds a bail out of jail card to their hand
            player.addBailOutFromJailCard(drawnCard);
        } else if(drawnCard.getCardDetails().containsKey("go to jail")) {
            //player goes to jail
            player.goToJail();
        } else if(drawnCard.getCardDetails().containsKey("pay")) {
            // Pay x amount of money
            player.changeBalance(-drawnCard.getCardDetails().get("pay"));
        } else if (drawnCard.getCardDetails().containsKey("receive")) {
            // Receive x amount of money
            player.changeBalance(drawnCard.getCardDetails().get("receive"));
        } else if (drawnCard.getCardDetails().containsKey("forward")) {
            // Move token forward x tiles
            player.moveToken(drawnCard.getCardDetails().get("forward"));
        } else if (drawnCard.getCardDetails().containsKey("backward")) {
            // Move token backward x tiles
            player.moveToken(-drawnCard.getCardDetails().get("backward"));
        } else if(drawnCard.getCardDetails().containsKey("move to")){
            //Move token to a specific tile
            player.moveToken(drawnCard.getCardDetails().get("move to"));
        }

    }

    @Override
    public void button2Strategy(Player player) {

    }

    @Override
    public void button3Strategy(Player player) {

    }

    @Override
    public void button4Strategy(Player player) {

    }
}
