package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.property.TitleDeedCard;

import java.util.ArrayList;

public class PropertyActionsStrategy extends ActionStrategy {

    /**
     * This strategy is related to the buy operation, also has the possibility to initi.
     * @param player is the player that the action is inflicted on.
      */
    @Override
    public void button1Strategy(Player player) {
        // TODO isWillingToBuy will be set from the GUI.
        boolean isWillingToBuy = false;

        if ((player.getBalance() >= player.currentTile().getPrice()) && isWillingToBuy && !player.currentTile().isOwned()) {
            player.changeBalance(- player.currentTile().getPrice());
            player.addProperty(player.currentTile());
        } else if (isWillingToBuy && !player.currentTile().isOwned()) {
            ArrayList<TitleDeedCard> titleDeedCards;
            player.startAuction(titleDeedCards);
        }
    }

    /**
     * This strategy is related to the pay rent operation, also has the possibility to initiate trade.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button2Strategy(Player player) {
        int totalRent = player.currentTile().getPropertyValue();

        if (player.getBalance() >= totalRent) {
            player.changeBalance(-totalRent);
            Player otherPlayer = player.currentTile().getOwner();
            otherPlayer.changeBalance(totalRent);
        } else {
            player.startTrade(otherPlayer);
        }
    }

    @Override
    public void button3Strategy(Player player) {

    }

    @Override
    public void button4Strategy(Player player) {

    }
}
