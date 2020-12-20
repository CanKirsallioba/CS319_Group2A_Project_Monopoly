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

    /**
     *
     * @return the current player who has the turn
     */
    public Player getCurrentPlayer() {
        return getPlayers().get(getCurrentPlayerIndex());
    }

    /**
     *
     */
    public void playTurn() {
        getCurrentPlayer().playTurn();
    }

    /**
     *
     * @return all players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * ends the turn
     */
    public void endTurn() {
//        ArrayList<Player> players2 = new ArrayList<>();
//        for (Player player : getPlayers()) {
//            if (!player.isBankrupt()) {
//                players2.add(player);
//            }
//        }
//        int index = 0;
//        do {
//            index = ((index + 1) % players2.size());
//        } while (players2.get(index).isBankrupt() && !getPlayers().stream().allMatch(Player::isBankrupt));
//        if (!players2.isEmpty()) {
//            players2.get(index).playTurn();
//        }
        do {
//            if (dice.getDice1() == dice.getDice2()) {
//                setCurrentPlayerIndex(getCurrentPlayerIndex() - 1 % players.size());
//                System.out.println(getCurrentPlayerIndex());
//            }
            setCurrentPlayerIndex((getCurrentPlayerIndex() + 1) % players.size());
        } while (getPlayers().get(getCurrentPlayerIndex()).isBankrupt() && !getPlayers().stream().allMatch(Player::isBankrupt));
        playTurn();

    }

    /**
     *
     * @param player add the player to turn manager
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     *
     * @param players the players object
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     *
     * @return getter
     */
    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    /**
     *
     * @param currentPlayerIndex sets the tile index of current player
     */
    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    /**
     *
     * @param players player arraylist
     * @param currentPlayerIndex starting index
     */
    public TurnManager(ArrayList<Player> players, int currentPlayerIndex) {
        this.players = players;
        this.currentPlayerIndex = currentPlayerIndex;
    }

    /**
     *
     * @return dice object
     */
    public Dice getDice() {
        return this.dice;
    }

    /**
     *
     * @param dice dice object
     */
    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
