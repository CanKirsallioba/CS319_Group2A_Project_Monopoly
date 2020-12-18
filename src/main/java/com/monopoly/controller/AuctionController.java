package com.monopoly.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class AuctionController implements Initializable {

    @FXML
    public Button auctionButton1;
    @FXML
    public Button auctionButton2;
    @FXML
    public Button auctionButton3;
    @FXML
    public Button auctionButton4;
    @FXML
    public Button auctionButton5;
    @FXML
    public Button auctionButton6;

    @FXML
    public Label timeLabel;
    @FXML
    public Label currentPrice;
    @FXML
    public Label currentOwner;
    @FXML
    public Label raiseAmount;

    @FXML
    public void raisePlayer1() {
        int currentPropertyPrice = parseInt(currentPrice.getText());

        currentPropertyPrice += parseInt(raiseAmount.getText());

        currentPrice.setText(String.valueOf(currentPropertyPrice));
        currentOwner.setText("Player 1");
    }

    @FXML
    public void raisePlayer2() {
        int currentPropertyPrice = parseInt(currentPrice.getText());

        currentPropertyPrice += parseInt(raiseAmount.getText());

        currentPrice.setText(String.valueOf(currentPropertyPrice));
        currentOwner.setText("Player 2");
    }

    @FXML
    public void raisePlayer3() {
        int currentPropertyPrice = parseInt(currentPrice.getText());

        currentPropertyPrice += parseInt(raiseAmount.getText());

        currentPrice.setText(String.valueOf(currentPropertyPrice));
        currentOwner.setText("Player 3");
    }

    @FXML
    public void raisePlayer4() {
        int currentPropertyPrice = parseInt(currentPrice.getText());

        currentPropertyPrice += parseInt(raiseAmount.getText());

        currentPrice.setText(String.valueOf(currentPropertyPrice));
        currentOwner.setText("Player 4");
    }

    @FXML
    public void raisePlayer5() {
        int currentPropertyPrice = parseInt(currentPrice.getText());

        currentPropertyPrice += parseInt(raiseAmount.getText());

        currentPrice.setText(String.valueOf(currentPropertyPrice));
        currentOwner.setText("Player 5");
    }

    @FXML
    public void raisePlayer6() {
        int currentPropertyPrice = parseInt(currentPrice.getText());

        currentPropertyPrice += parseInt(raiseAmount.getText());

        currentPrice.setText(String.valueOf(currentPropertyPrice));
        currentOwner.setText("Player 6");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentPrice.setText("50");
    }
}
