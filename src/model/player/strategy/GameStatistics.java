package model.player.strategy;

import model.board.Board;
import model.player.Player;
import model.tiles.PropertyTile;
import model.tiles.Tile;

import java.io.Serializable;
import java.util.ArrayList;

public class GameStatistics implements Serializable {
    Board board;
    ArrayList<Player> players;

    /**
     * Default constructor.
     */
    public GameStatistics(){
        board = null;
        players = null;
    }

    /**
     * Default constructor that initializes the board according to parameters.
     * @param board is the board of the game
     * @param players are the players in the game
     */
    public GameStatistics( Board board, ArrayList<Player> players){
        this.board = board;
        this.players = players;
    }

    /**
     * Calculates the average rent according to ownership situation of the properties on the board.
     * @return average rent of properties
     */
    public int calculateAverageRent(){
        int numberOfPropertyTiles = 0;
        int totalRentValue = 0;

        for( Tile tile: board.getTiles()){
            if( tile instanceof PropertyTile){
                totalRentValue += ( (PropertyTile) tile).getTitleDeedCard().getCurrentRent();
                numberOfPropertyTiles++;
            }
        }

        return totalRentValue / numberOfPropertyTiles;
    }

    /**
     * @return the maximum rent on the board
     */
    public int getMaximumRent(){
        int maxRent = 0;
        for( Tile tile: board.getTiles()){
            if( tile instanceof PropertyTile){
                if ( ( (PropertyTile) tile).getTitleDeedCard().getCurrentRent() > maxRent ){
                    maxRent = ((PropertyTile) tile).getTitleDeedCard().getCurrentRent();
                }
            }
        }
        return maxRent;
    }

    /**
     * @return the number of properties on the board who does not have an owner
     */
    public int calculateNumberOfPropertiesWithoutOwner(){
        int numOfProperties = 0;
        int numOfOwnedProperties = 0;
        for( Tile tile: board.getTiles()){
            if( tile instanceof PropertyTile){
                numOfProperties++;
                int upgradeLevel = 0;
                if ( ((PropertyTile) tile).getTitleDeedCard().isOwned() ){
                    numOfOwnedProperties++;
                }
            }
        }
        return numOfProperties - numOfOwnedProperties;
    }

    /**
     * @return the collective net worth of players in the game
     */
    public int calculateNetWorthOfPlayers() {
        int netWorthValue = 0;
        for( Player currentPlayer: players){
            netWorthValue += currentPlayer.getTotalWorth();
        }
        return netWorthValue;
    }

    /**
     * @return the board attribute
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Sets the board attribute to the parameter
     * @param board is the new board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * @return the players attribute
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Sets the players attribute to the parameter
     * @param players is the new players list
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }


}
