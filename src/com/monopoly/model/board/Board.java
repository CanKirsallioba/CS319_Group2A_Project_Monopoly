package com.monopoly.model.board;

import com.monopoly.model.tiles.Tile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Board implements Iterable<Tile>, Serializable {
    ArrayList<Tile> tiles;


    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(ArrayList<Tile> tiles) {
        this.tiles = tiles;
    }

    @Override
    public Iterator<Tile> iterator() {
        return tiles.iterator();
    }
}
