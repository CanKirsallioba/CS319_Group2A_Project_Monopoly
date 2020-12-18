package model.tiles.actionStrategy;

import model.player.Player;
import model.tiles.TeleportTile;

public class TeleportTileActionStrategy extends ActionStrategy {

    /**
     * This strategy is related to teleporting the player.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button1Strategy(Player player) {
        if (!(player.getCurrentTile () instanceof TeleportTile)) {
            throw new RuntimeException ( "Wrong tile type" );
        }
        TeleportTile tile = (TeleportTile) player.getCurrentTile();
        int index = tile.getIndex();
        int counterpart = tile.getCounterpartIndex();
        player.moveToken(counterpart-index + 1);

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
