package model.session;

import model.player.Dice;
import model.player.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class TurnManager implements Serializable {
    ArrayList<Player> players;
    int currentPlayerIndex;
    Dice dice;

    TurnManager() {

    }

    public Player getCurrentPlayer() {
        return getPlayers().get(getCurrentPlayerIndex());
    }

    public void playTurn() {
        getCurrentPlayer().playTurn();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void endTurn() {
        do {

            setCurrentPlayerIndex((getCurrentPlayerIndex() + 1) % players.size());

        } while (getPlayers().get(getCurrentPlayerIndex()).isBankrupt() && !getPlayers().stream().allMatch(Player::isBankrupt));
        playTurn();
    }

    public void addPlayer(Player player) {
        players.add(player);
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
