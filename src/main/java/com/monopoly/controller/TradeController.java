package com.monopoly.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TradeController implements Initializable {

    @FXML
    public Button playerAAddButton;
    public Button playerBAddButton;

    public Button playerAProposeButton;
    public Button backButton;

    public TextField playerAMoney, playerBMoney;

    public void handleAddPlayerB() {}
    public void handleAddPlayerA() {}
    public void handlePropose() {}
    public void handleBack() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
