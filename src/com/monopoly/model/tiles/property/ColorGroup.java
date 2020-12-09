package com.monopoly.model.tiles.property;

import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.Tile;

import java.io.Serializable;
import java.util.ArrayList;

public class ColorGroup implements Serializable {
    ArrayList<Tile> group;

    public ColorGroup(ArrayList<Tile> group) {
        this.group = group;
    }

    public ArrayList<Player> getGroup() {
        return null;
    }

    public void setGroup(ArrayList<Tile> group) {
        this.group = group;
    }
}
