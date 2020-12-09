package com.monopoly.model.player;

import com.monopoly.model.board.Board;
import com.monopoly.model.tiles.Tile;

public class PlayerToken {
    int currentTileIndex;
    Tile currTileObj; // newly added
    String type;

    // newly added
    Board board; // POSSIBLY SUBJECT TO CHANGE
    int lastDiceRoll;

    /**
    * Main constructor.
    * @param type is the type of the token
    * @param b is the board of the game
     */
    PlayerToken(String type, Board b) {
        board = b; // pass-by-reference ?

        this.type = type;
        currentTileIndex = 0;
        currTileObj = board.getTiles().get(0);
    }

    /**
     * Moves the token by the specified amount.
     * @param amount is the number of tiles to go
     * @return the newly landed tile
     */
    Tile move(int amount) {
        currentTileIndex = (currentTileIndex + amount) % 40; // 40 possibly needs to be replaced with getTileCount etc.
        currTileObj = board.getTiles().get(currentTileIndex);
        lastDiceRoll = amount;
        return currTileObj;
    }


    /**
     * Sends the token to jail.
     */
    void goToJail() {
        currentTileIndex = board.getJailTileIndex();
    }


    /**
     * Teleports the player to the pair's second teleport tile.
     * @param teleportTileIndex is the index of the tile to teleport to
     */
    void teleport(int teleportTileIndex) {
        currentTileIndex = teleportTileIndex; // 40 possibly needs to be replaced with getTileCount etc.
        currTileObj = board.getTiles().get(currentTileIndex);
    }


    /**
     * @return the type
     */
    String getType() {
        return type;
    }

    /**
     * @return the currTileObj
     */
    Tile getCurrentTile() {
        return currTileObj;
    }

    /**
    * Checks whether player has passed go in the last move.
    * @return true if player passed go in the last turn. false otherwise
     */
    boolean passedGoInTheLastMove() {
        return currentTileIndex < lastDiceRoll;
    }

    void setType( String t){
        type = t;
    }
}
