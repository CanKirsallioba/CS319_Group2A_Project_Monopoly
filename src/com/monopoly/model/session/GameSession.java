package com.monopoly.model.session;

import com.monopoly.model.BoardConfiguration;
import com.monopoly.model.board.Board;
import com.monopoly.model.board.Dice;

import java.io.Serializable;

public class GameSession implements Serializable {
    String gameSessionName;
    BoardConfiguration boardConfiguration;
    Board board;
    TurnManager turnManager;
    Dice dice;


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public TurnManager getTurnManager() {
        return turnManager;
    }

    public void setTurnManager(TurnManager turnManager) {
        this.turnManager = turnManager;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
