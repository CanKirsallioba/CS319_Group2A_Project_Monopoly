package model.tiles;

import model.player.Player;

import java.util.ArrayList;

public class GoToJailTile extends Tile {


    /**
     * This method activates the action of going to jail, which is a mandatory action
     * @param player the player who landed on the tile
     * @param actions the actions associated with the tile
     * @return
     */
    @Override
    protected ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions){
        setActive(actions, "Go To Jail", true);
        return actions;
    }
}
