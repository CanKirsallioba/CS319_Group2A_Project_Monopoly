package com.monopoly.model.session;

import com.monopoly.model.board.Board;
import com.monopoly.model.board.Dice;

import java.io.Serializable;

public class GameSession implements Serializable {
    Board board;
    TurnManager turnManager;

    public GameSession(Board board, TurnManager turnManager, Dice dice) {
        this.board = board;
        this.turnManager = turnManager;
        this.dice = dice;
    }

    Dice dice;


    
}
