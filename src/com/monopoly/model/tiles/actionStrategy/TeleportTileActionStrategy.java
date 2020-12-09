package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.player.Player;
import com.monopoly.model.player.PlayerToken;

public class TeleportTileActionStrategy extends ActionStrategy {

    /**
     * This strategy is related to teleporting the player.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button1Strategy(Player player) {
        player.getToken().teleport(player.getCurrentTileIndex());
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
