package com.monopoly.model.tiles;

import java.util.ArrayList;

public class TeleportTile extends Tile {

    private int counterpartIndex;

    @Override
    protected ArrayList<Action> hook() {
        return null;
    }

    public int getCounterpartIndex() {
        return counterpartIndex;
    }

    public void setCounterpartIndex(int counterpartIndex) {
        this.counterpartIndex = counterpartIndex;
    }
}
