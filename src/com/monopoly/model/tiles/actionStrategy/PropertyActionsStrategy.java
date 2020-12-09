package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.property.TitleDeedCard;

import java.util.ArrayList;

public class PropertyActionsStrategy extends ActionStrategy {

    /**
     * This strategy is related to the upgrade property action.
     * @param player is the player that the action is inflicted on.
      */
    @Override
    public void button1Strategy(Player player) {
        upgradeProperty ( player );
    }

    /**
     * This strategy is related to the downgrade property action.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button2Strategy(Player player) {
        downgradeProperty ( player );
    }

    /**
     * This strategy is related to the mortgage a property action.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button3Strategy(Player player) {

    }

    @Override
    public void button4Strategy(Player player) {

    }

    /**
     * This method is the helper method for the button1Strategy.
     * @param player the player that the action is inflicted on.
     */
    private void upgradeProperty(Player player) {
        PropertyTile tile;
        if (player.getCurrentTile() instanceof PropertyTile) {
            tile = (PropertyTile) player.getCurrentTile();
        }
        TitleDeedCard card = tile.getTitleDeedCard();

        int upgradeLevel = card.getUpgradeLevel();
        int upgradeCost = card.getUpgradeCost();

        if (player.getBalance() <= upgradeCost && upgradeLevel != 5) {
            player.changeBalance(-upgradeCost);
            card.setUpgradeLevel(upgradeLevel++);
        }
    }

    /**
     * This method is the helper method for the button2Strategy.
     * @param player the player that the action is inflicted on.
     */
    private void downgradeProperty(Player player) {
        PropertyTile tile;
        if (player.getCurrentTile() instanceof PropertyTile) {
            tile = (PropertyTile) player.getCurrentTile();
        }
        TitleDeedCard card = tile.getTitleDeedCard();

        int upgradeLevel = card.getUpgradeLevel();

        if (upgradeLevel > 0) {
            int downgradeMoney = card.downgrade();
            player.changeBalance(downgradeMoney);
        }
    }
}
