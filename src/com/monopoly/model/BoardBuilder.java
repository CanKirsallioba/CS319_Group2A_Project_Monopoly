package com.monopoly.model;

import com.monopoly.model.board.Board;

public class BoardBuilder {
    Board board;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void changeTileName(String tileName){}
    public void changeRent(int rent){}
    public void changePropertyValue(int value){}
    public void changeMortgageValue(int mortgageValue) {}
    public void changeSalary(int salary){}
    public void setBoardName(String boardName){}
    public void saveBoard(){}

}
