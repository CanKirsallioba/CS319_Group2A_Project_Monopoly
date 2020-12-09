package com.monopoly.model.player;

import com.monopoly.model.board.Board;
import com.monopoly.model.tiles.Tile;

public class PlayerToken {
    int currentTile;
    String type;
    Board board;

    PlayerToken(String type) {

    }

    public PlayerToken(int currentTile, String type) {
        this.currentTile = currentTile;
        this.type = type;
    }


    Tile move(int amount) { return null; }

    void goToJail() {
        currentTile = board.getJailTileIndex();
    }

    void teleport(int teleportTileIndex) {
    }

    String getType() {
        return null;
    }

    Tile getCurrentTile() {
        return null;
    }

    boolean passedGoInTheLastMove() {
        return false;
    }
}
