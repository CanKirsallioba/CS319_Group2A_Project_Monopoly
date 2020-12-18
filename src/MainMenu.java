import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu {
    @FXML
    private Button quitButton = new Button("Exit Game");

    @FXML
    public void goToCreditsScreen( ActionEvent event) throws IOException {
        changeScreen(event, "Credits.fxml");
    }

    @FXML
    public void goToHowToPlayScreen( ActionEvent event) throws IOException {
        changeScreen(event, "HowToPlay.fxml");
    }

    public void goToNewGameScreen( ActionEvent event) throws IOException {
        changeScreen(event, "newgame.fxml");
    }

    public void goToLoadGameScreen( ActionEvent event) throws IOException {
        changeScreen(event, "LoadGame.fxml");
    }


    public void goToMapBuilderScreen( ActionEvent event) throws IOException {
        changeScreen(event, "boardbuilder.fxml");
    }

    public void goToSettingsScreen(ActionEvent event) throws IOException {
        changeScreen(event, "settings.fxml");
    }

    @FXML
    private void quitGame(){
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    private void changeScreen(ActionEvent event, String fxmlFile) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource(fxmlFile));

        Scene tableViewScene = new Scene(tableViewParent);

        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setId("pane");
        tableViewScene.getStylesheets().addAll(this.getClass().getResource("CreditsStyle.css").toExternalForm());

        window.setScene(tableViewScene);


        window.show();
    }
}
