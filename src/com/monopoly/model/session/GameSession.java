package com.monopoly.model.session;

import com.monopoly.model.board.Board;
import com.monopoly.model.board.Dice;

import java.io.Serializable;

public class GameSession implements Serializable {
    String game
    Board board;
    TurnManager turnManager;
    Dice dice;

    public GameSession(Board board, TurnManager turnManager) {
        this.board = board;
        this.turnManager = turnManager;
        this.dice = turnManager.getDice();
    }


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
