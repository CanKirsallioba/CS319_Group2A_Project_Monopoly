package com.monopoly.model.board;

import com.monopoly.model.tiles.Tile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Board implements Iterable<Tile>, Serializable {
    String boardName;
    int salary;
    ArrayList<Tile> tiles;

    // newly added
    int jailTileIndex;

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

    public int getJailTileIndex() {
        return jailTileIndex;
    }

    public void setJailTileIndex(int jailTileIndex) {
        this.jailTileIndex = jailTileIndex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
}
