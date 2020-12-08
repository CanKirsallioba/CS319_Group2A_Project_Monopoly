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
    @FXML
    private Button quitButton = new Button("Exit Game");

    @FXML
    public void goToCreditsScreen( ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Credits.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);

        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setId("pane");
        tableViewScene.getStylesheets().addAll(this.getClass().getResource("CreditsStyle.css").toExternalForm());

        window.setScene(tableViewScene);

        window.show();
    }

    @FXML
    public void goToHowToPlayScreen( ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("HowToPlay.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);

        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);


        tableViewParent.setId("pane");
        tableViewScene.getStylesheets().addAll(this.getClass().getResource("CreditsStyle.css").toExternalForm());

        window.show();
    }

    public void goToNewGameScreen( ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("newgame.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);

        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setId("pane");
        tableViewScene.getStylesheets().addAll(this.getClass().getResource("CreditsStyle.css").toExternalForm());

        window.setScene(tableViewScene);

        window.show();
    }


    public void goToMapBuilderScreen( ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("boardbuilder.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);

        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setId("pane");
        tableViewScene.getStylesheets().addAll(this.getClass().getResource("CreditsStyle.css").toExternalForm());

        window.setScene(tableViewScene);

        window.show();
    }

    @FXML
    private void quitGame(){
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }
}
