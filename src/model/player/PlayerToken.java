package model.player;

import model.board.Board;
import model.tiles.Tile;

import java.io.Serializable;

public class PlayerToken implements Serializable {
    int currentTileIndex;

    Tile currentTile;
    String type;
    Board board;
    int lastDiceRoll;

    /**
    * ui.Main constructor.
    * @param type is the type of the token
    * @param board is the board of the game
     */
    public PlayerToken(String type, Board board) {
        this.board = board; // pass-by-reference ?
        this.type = type;

        // put the token to go tile in the beginning
        currentTileIndex = 0;
        currentTile = board.getTiles().get(0);
    }

    /**
     * Moves the token by the specified amount.
     * @param amount is the number of tiles to go
     * @return the newly landed tile
     */
    Tile move(int amount) {
        currentTileIndex = (currentTileIndex + amount) % 40; // 40 possibly needs to be replaced with getTileCount etc.
        currentTile = board.getTiles().get(currentTileIndex);
        lastDiceRoll = amount;
        return currentTile;
    }

    /**
     * Sends the token to jail.
     */
    void goToJail() {
        currentTile = board.getTiles().get(board.getJailTileIndex());
        currentTileIndex = board.getJailTileIndex();
    }

    /**
     * Teleports the player to the pair's second teleport tile.
     * @param teleportTileIndex is the index of the tile to teleport to
     */
    void teleport(int teleportTileIndex) {
        currentTileIndex = teleportTileIndex; // 40 possibly needs to be replaced with getTileCount etc.
        currentTile = board.getTiles().get(currentTileIndex);
    }


    /**
     * @return the type
     */
    String getType() {
        return type;
    }

    /**
     * @param type is the new type
     */
    void setType( String type){
        type = type;
    }

    /**
     * @return the currTileObj
     */
    Tile getCurrentTile() {
        return currentTile;
    }

    /**
    * Checks whether player has passed go in the last move.
    * @return true if player passed go in the last turn. false otherwise
     */
    boolean passedGoInTheLastMove() {
        return (currentTileIndex < lastDiceRoll) || (currentTileIndex == 0);
    }

    /**
     * getter method for lastDiceRoll
     * @return the lastDiceRoll
     */
    public int getLastDiceRoll() {
        return lastDiceRoll;
    }

    /**
     * setter method for lastDiceRoll
     * @param lastDiceRoll is the new value of the lastDiceRoll
     */
    public void setLastDiceRoll(int lastDiceRoll) {
        this.lastDiceRoll = lastDiceRoll;
    }

    /**
     * Getter method for board reference
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Setter method for the board
     * @param board is the new board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    public int getCurrentTileIndex() {
        return currentTileIndex;
    }

    public void setCurrentTileIndex(int currentTileIndex) {
        this.currentTileIndex = currentTileIndex;
    }

    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }



}
