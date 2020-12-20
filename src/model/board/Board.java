package model.board;

import model.tiles.Tile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Board class that the game is played on.
 */
public class Board implements Iterable<Tile>, Serializable {
    String boardName;
    int boardSalary;
    ArrayList<Tile> tiles;

    // newly added
    int jailTileIndex;

    /**
     * Getter method for tiles.
     * @return the tiles of the board.
     */
    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    /**
     * Setter method for tiles.
     * @param tiles is the new tiles.
     */
    public void setTiles(ArrayList<Tile> tiles) {
        this.tiles = tiles;
    }

    /**
     * @return an iterator for tiles.
     */
    @Override
    public Iterator<Tile> iterator() {
        return tiles.iterator();
    }

    /**
     * Getter method for jail tile index.
     * @return index of the JailTile
     */
    public int getJailTileIndex() {
        return jailTileIndex;
    }

    /**
     * Setter method for tiles.
     * @param jailTileIndex is the new index for the JailTile.
     */
    public void setJailTileIndex(int jailTileIndex) {
        this.jailTileIndex = jailTileIndex;
    }

    /**
     * Getter method for boardSalary.
     * @return the salary received when the player passes from GoTile, the boardSalary.
     */
    public int getBoardSalary() {
        return boardSalary;
    }

    /**
     * Setter method  for boardSalary.
     * @param salary is the new boardSalary.
     */
    public void setBoardSalary(int salary) {
        this.boardSalary = salary;
    }

    /**
     * Getter method for boardName.
     * @return the boardName.
     */
    public String getBoardName() {
        return boardName;
    }

    /**
     * Setter method for boardName.
     * @param boardName is the new boardName.
     */
    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
}
