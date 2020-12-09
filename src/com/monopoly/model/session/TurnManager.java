package com.monopoly.model.session;

import com.monopoly.model.player.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class TurnManager implements Serializable {
    ArrayList<Player> players;
    int currentPlayerIndex;

    TurnManager() {

    }

    public Player getCurrentPlayer() {
        return null;
    }

    public void playTurn() {

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void endTurn() {

    }
    public void addPlayer() {

    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public TurnManager(ArrayList<Player> players, int currentPlayerIndex) {
        this.players = players;
        this.currentPlayerIndex = currentPlayerIndex;
    }
}
