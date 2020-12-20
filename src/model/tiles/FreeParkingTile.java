package model.tiles;

import model.player.Player;

import java.util.ArrayList;

public class FreeParkingTile extends Tile {

    /**
     * This method does not have any functionality since it is called on free parking tile
     * @param player the player who landed on the tile
     * @param actions the actions associated with the tile
     * @return
     */
    @Override
    protected ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions) {
        return actions;
    }
}
