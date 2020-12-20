package model.tiles.actionStrategy;

import model.player.Player;
import model.tiles.card.Card;

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

        Card drawnCard = player.getCurrentlyDrawnCard();
        System.out.println("BEFORE CARD __ \n: " + player);
        if (drawnCard.getCardDetails().containsKey("BAIL_OUT_OF_JAIL")) {
            //player adds a bail out of jail card to their hand
            player.addBailOutFromJailCard(drawnCard);
        } else if(drawnCard.getCardDetails().containsKey("GO_TO_JAIL")) {
            //player goes to jail
            player.goToJail();
        } else if(drawnCard.getCardDetails().containsKey("PAY")) 
        {
            // Pay x amount of money
            int amountToPay = drawnCard.getCardDetails().get("PAY");
            if (player.getBalance() >= amountToPay) {
                player.changeBalance(-amountToPay);
            } else if(player.getBalance() < amountToPay) {
                if (player.getTotalWorth() > amountToPay) {
                    //TODO player.payWithMortgage();
                } else {
                    player.declareBankruptcy();
                }
            } else {
                throw new RuntimeException();
            }
            
        } else if (drawnCard.getCardDetails().containsKey("RECEIVE")) {
            // Receive x amount of money
            player.changeBalance(drawnCard.getCardDetails().get("RECEIVE"));
        } else if (drawnCard.getCardDetails().containsKey("FORWARD")) {
            // Move token forward x tiles
            player.moveToken(drawnCard.getCardDetails().get("FORWARD"));
        } else if (drawnCard.getCardDetails().containsKey("BACKWARD")) {
            // Move token backward x tiles
            player.moveToken(-drawnCard.getCardDetails().get("BACKWARD"));
        } else if(drawnCard.getCardDetails().containsKey("MOVE_TO")){
            //Move token to a specific tile
            player.moveToken((drawnCard.getCardDetails().get("MOVE_TO") - player.getCurrentTile().getIndex()) % 40);
        }
        System.out.println("END CARD __ \n: " + player);
        player.changeBalance(0);
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
