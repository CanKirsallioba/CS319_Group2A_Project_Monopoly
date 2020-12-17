package com.monopoly.model.player.strategy;

import com.monopoly.model.board.Board;
import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.PropertyTile;
import com.monopoly.model.tiles.Tile;

import java.util.ArrayList;

public class GameStatistics {
    Board board;
    ArrayList<Player> players;

    GameStatistics(){
        board = null;
        players = null;
    }

    GameStatistics( Board board, ArrayList<Player> players){
        this.board = board;
        this.players = players;
    }

    public int calculateAverageRent(){
        int numberOfPropertyTiles = 0;
        int totalRentValue = 0;

        for( Tile tile: board.getTiles()){
            if( tile instanceof PropertyTile){
                int upgradeLevel = 0;
                upgradeLevel = ((PropertyTile) tile).getTitleDeedCard().getUpgradeLevel();
                if( upgradeLevel == 1){
                    totalRentValue += ((PropertyTile) tile).getTitleDeedCard().getLevelOneRent();
                }
                else if( upgradeLevel == 2){
                    totalRentValue += ((PropertyTile) tile).getTitleDeedCard().getLevelTwoRent();
                }
                else if( upgradeLevel == 3){
                    totalRentValue += ((PropertyTile) tile).getTitleDeedCard().getLevelThreeRent();
                }
                else if( upgradeLevel == 4){
                    totalRentValue += ((PropertyTile) tile).getTitleDeedCard().getLevelFourRent();
                }
                else if( upgradeLevel == 5){
                    totalRentValue += ((PropertyTile) tile).getTitleDeedCard().getLevelFiveRent();
                }
                numberOfPropertyTiles++;
            }
        }

        return totalRentValue / numberOfPropertyTiles;
    }

    public int getMaximumRent(){
        int maxRent = 0;
        for( Tile tile: board.getTiles()){
            if( tile instanceof PropertyTile){
                int upgradeLevel = 0;
                upgradeLevel = ((PropertyTile) tile).getTitleDeedCard().getUpgradeLevel();
                if( upgradeLevel == 1){
                    if( maxRent < ((PropertyTile) tile).getTitleDeedCard().getLevelOneRent()){
                        maxRent = ((PropertyTile) tile).getTitleDeedCard().getLevelOneRent();
                    }
                }
                else if( upgradeLevel == 2){
                    if( maxRent < ((PropertyTile) tile).getTitleDeedCard().getLevelTwoRent()){
                        maxRent = ((PropertyTile) tile).getTitleDeedCard().getLevelTwoRent();
                    }
                }
                else if( upgradeLevel == 3){
                    if( maxRent < ((PropertyTile) tile).getTitleDeedCard().getLevelThreeRent()){
                        maxRent = ((PropertyTile) tile).getTitleDeedCard().getLevelThreeRent();
                    }
                }
                else if( upgradeLevel == 4){
                    if( maxRent < ((PropertyTile) tile).getTitleDeedCard().getLevelFourRent()){
                        maxRent = ((PropertyTile) tile).getTitleDeedCard().getLevelFourRent();
                    }
                }
                else if( upgradeLevel == 5){
                    if( maxRent < ((PropertyTile) tile).getTitleDeedCard().getLevelFiveRent()){
                        maxRent = ((PropertyTile) tile).getTitleDeedCard().getLevelFiveRent();
                    }
                }
            }
        }
        return maxRent;
    }

    public int calculateNumberOfPropertiesWithoutOwner(){
        int numOfProperties = 0;
        int numOfOwnedProperties = 0;
        for( Tile tile: board.getTiles()){
            if( tile instanceof PropertyTile){
                numOfProperties++;
                int upgradeLevel = 0;
                if ( ((PropertyTile) tile).getTitleDeedCard().getIsOwned()){
                    numOfOwnedProperties++;
                }
            }
        }
        return numOfProperties - numOfOwnedProperties;
    }

    public int calculateNetWorthOfPlayers() {
        int netWorthValue = 0;
        for( Player currentPlayer: players){
            netWorthValue += currentPlayer.getTotalWorth();
        }
        return netWorthValue;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }


}
