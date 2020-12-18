import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameBoardMenuController implements Initializable {

    @FXML
    private Button resumeButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button returnButton;

    @FXML
    public void handleResume() {
        Stage stage = (Stage) resumeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void handleSettings(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("MenuSettings.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);

        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setId("pane");
        tableViewScene.getStylesheets().addAll(this.getClass().getResource("CreditsStyle.css").toExternalForm());
        window.setScene(tableViewScene);

        window.show();
    }

    @FXML
    public void handleReturnMainMenu(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit?", ButtonType.YES, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));

            Scene tableViewScene = new Scene(tableViewParent);

            // Stage information
            Stage current = (Stage) returnButton.getScene().getWindow();
            current.close();

            Stage window = Main.primaryStage;
            tableViewParent.setId("pane");

            window.setScene(tableViewScene);

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            window.setX((screenBounds.getWidth() - window.getWidth()) / 2);
            window.setY((screenBounds.getHeight() - window.getHeight()) / 2);

            window.show();
        } else {
            alert.close();
        }



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
