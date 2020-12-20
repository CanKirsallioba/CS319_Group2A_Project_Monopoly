package model.session;

import model.BoardConfiguration;
import model.board.Board;
import model.player.Dice;

import java.io.Serializable;

public class GameSession implements Serializable {

    String gameSessionName;
    BoardConfiguration boardConfiguration;
    Board board;
    TurnManager turnManager;
    Dice dice;

    /**
     * Getter method for the board attribute
     * @return the board attribute
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Setter method for the board attribute
     * @param board is the attribute to be set to the class' board attribute
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Getter method for the turn manager attribute
     * @return the turn manager attribute
     */
    public TurnManager getTurnManager() {
        return turnManager;
    }

    /**
     * Setter method for the turn manager attribute.
     * @param turnManager is the turn manager to be set to the class' turn manager attribute.
     */
    public void setTurnManager(TurnManager turnManager) {
        this.turnManager = turnManager;
    }

    /**
     * Getter method for the dice attribute.
     * @return the dice attribute
     */
    public Dice getDice() {
        return dice;
    }

    /**
     * Setter method for the dice attribute.
     * @param dice is the attribute to be set to the class' dice attribute.
     */
    public void setDice(Dice dice) {
        this.dice = dice;
    }

    /**
     * Getter method for the game session name
     * @return the game session name attribute
     */
    public String getGameSessionName() {
        return gameSessionName;
    }

    /**
     * Setter method for the game session attribute.
     * @param gameSessionName is the attribute to be set to the class' game session name.
     */
    public void setGameSessionName(String gameSessionName) {
        this.gameSessionName = gameSessionName;
    }
}
