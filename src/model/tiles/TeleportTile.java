package model.tiles;

import model.player.Player;

import java.util.ArrayList;

public class TeleportTile extends Tile {

    private int counterpartIndex;


    public int getCounterpartIndex() {
        return counterpartIndex;
    }

    public void setCounterpartIndex(int counterpartIndex) {
        this.counterpartIndex = counterpartIndex;
    }

    @Override
    protected ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions){
        setActive(actions, "Teleport", true);
        return actions;
    }
}
