import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu {
    Button button1 = new Button("Play Game");

    @FXML
    public void goToCreditsScreen( ActionEvent event) throws IOException {
        System.out.println( "mahmut");
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Credits.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);

        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setId("pane");
        tableViewScene.getStylesheets().addAll(this.getClass().getResource("CreditsStyle.css").toExternalForm());

        window.setScene(tableViewScene);

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((screenBounds.getHeight() - window.getHeight()) / 2);

        window.show();
    }

    @FXML
    public void goToHowToPlayScreen( ActionEvent event) throws IOException {
        System.out.println( "mahmut");
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("HowToPlay.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);

        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);


        tableViewParent.setId("pane");
        tableViewScene.getStylesheets().addAll(this.getClass().getResource("CreditsStyle.css").toExternalForm());


        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((screenBounds.getHeight() - window.getHeight()) / 2);

        window.show();
    }

    public void goToNewGameScreen( ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("newgame.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);

        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setId("pane2");

        window.setScene(tableViewScene);

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((screenBounds.getHeight() - window.getHeight()) / 2);

        window.show();
    }


    public void goToMapBuilderScreen( ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("mapbuilder.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);

        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setId("pane3");

        window.setScene(tableViewScene);

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((screenBounds.getHeight() - window.getHeight()) / 2);

        window.show();
    }
}