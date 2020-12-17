package com.monopoly.model.tiles;

import com.monopoly.model.player.Player;

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
    public ArrayList<GameAction> hook(Player player) {
        setActive(actions, "TELEPORT", true);
        return actions;
    }
}
