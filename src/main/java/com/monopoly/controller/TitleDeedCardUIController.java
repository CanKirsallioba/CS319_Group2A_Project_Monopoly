package com.monopoly.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class TitleDeedCardUIController implements Initializable {

    @FXML
    public Pane propertyColorPane;


    @FXML
    public Label propertyNameLabel;
    public Label rentWith1HouseValueLabel;
    public Label rentWith2HousesValueLabel;
    public Label rentWith3HousesValueLabel;
    public Label rentWith4HousesValueLabel;
    public Label rentWithHotelValueLabel;
    public Label costOfHousesValueLabel;
    public Label costOfHotelsValueLabel;
    public Label mortgageValueLabel;
    public Label costLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        propertyColorPane.setStyle("-fx-background-color: red;");
        propertyNameLabel.setText("Washington D.C.");
        rentWith1HouseValueLabel.setText("$100");
        rentWith2HousesValueLabel.setText("$200");
    }
}
