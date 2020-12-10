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
    protected ArrayList<Action> hook(Player player) {
        return actions;
    }
}
