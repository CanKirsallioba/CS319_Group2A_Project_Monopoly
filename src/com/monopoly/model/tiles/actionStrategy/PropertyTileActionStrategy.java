package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.PropertyTile;
import com.monopoly.model.tiles.property.TitleDeedCard;

import java.util.ArrayList;

public class PropertyTileActionStrategy extends ActionStrategy {
    String[] actionNames;

    public PropertyTileActionStrategy(String[] actionNames) {
        this.actionNames = actionNames;
    }

    /**
     * This strategy is related to the buy operation, also has the possibility to initi.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button1Strategy(Player player) {
        PropertyTile tile;
        if (player.getCurrentTile() instanceof PropertyTile) {
            tile = (PropertyTile) player.getCurrentTile();
        }
        TitleDeedCard card = tile.getTitleDeedCard();

        if ((player.getBalance() >= card.getPrice()) && isWillingToBuy && !carde.isOwned()) {
            player.changeBalance(- card.getPrice());
            player.addTitleDeedCard(card);
        }

    }

    /**
     * This strategy is related to the pay rent operation, also has the possibility to initiate trade.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button2Strategy(Player player) {
        PropertyTile tile;
        if (player.getCurrentTile() instanceof PropertyTile) {
            tile = (PropertyTile) player.getCurrentTile();
        }
        TitleDeedCard card = tile.getTitleDeedCard();

        int totalRent = tile.getPropertyValue();

        if (player.getBalance() >= totalRent) {
            player.changeBalance(-totalRent);
            Player otherPlayer = tile.getOwner();
            otherPlayer.changeBalance(totalRent);
        } else {
            player.startTrade(otherPlayer);
        }
    }

    /**
     * This strategy is related to the starting auction.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button3Strategy(Player player) {
        if (!card.isOwned()) {
            ArrayList<TitleDeedCard> titleDeedCards;
            player.startAuction(titleDeedCards);
        }

    }

    @Override
    public void button4Strategy(Player player) {
        System.out.println("S4");

    }

    public String[] getActionNames() {
        return actionNames;
    }
}
