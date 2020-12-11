package com.monopoly.model.session;

import com.monopoly.model.board.Dice;
import com.monopoly.model.player.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class TurnManager implements Serializable {
    ArrayList<Player> players;
    int currentPlayerIndex;
    Dice dice;
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

    public Dice getDice() {
        return this.dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
