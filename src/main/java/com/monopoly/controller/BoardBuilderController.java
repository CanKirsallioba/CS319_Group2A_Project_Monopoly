package com.monopoly.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BoardBuilderController implements Initializable {

    @FXML
    public void goToMainMenu( ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);
        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setId("pane");
        window.setScene(tableViewScene);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((screenBounds.getHeight() - window.getHeight()) / 2);
        window.show();
    }

    @FXML
    public void setGoTileIncome() {}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void saveGame() {}

    @FXML
    public void selectProperty(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        int id = Integer.parseInt(clickedButton.getId());
        System.out.println(id);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChangeProperty.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Property " + id);
        stage.setScene(new Scene(root1));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.centerOnScreen();
        stage.show();
    }

}
