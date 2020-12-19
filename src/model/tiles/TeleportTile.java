package model.tiles;

import model.player.Player;

import java.util.ArrayList;

public class TeleportTile extends Tile {

    private int counterpartIndex;

    /**
     * @return the index of the other teleport tile
     */
    public int getCounterpartIndex() {
        return counterpartIndex;
    }

    /**
     * @param counterpartIndex the index of the other teleport tile
     */
    public void setCounterpartIndex(int counterpartIndex) {
        this.counterpartIndex = counterpartIndex;
    }


    /**
     * This method activates the action of teleporting to the other teleport tile
     * @param player the player who landed on the tile
     * @param actions the actions associated with the tile
     * @return
     */
    @Override
    protected ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions){
        setActive(actions, "Teleport", true);
        return actions;
    }
}
