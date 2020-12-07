import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewGameController implements Initializable {
    @FXML
    private final int MAX_NUM_PLAYERS = 6;
    @FXML
    private Spinner<Integer> botSpinner;
    @FXML
    private Spinner<Integer> humanSpinner;
    @FXML
    private int humanPlayers = 1;
    @FXML
    private int botPlayers = 0;
    @FXML
    private int maxHumanPlayers = 6;
    @FXML
    private int maxBotPlayers = 5;

    SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactoryHuman = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, maxHumanPlayers);
    SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactoryBot= new SpinnerValueFactory.IntegerSpinnerValueFactory(0, maxBotPlayers);

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //spinner management, makes sure the player number is at most 6
        humanSpinner.setValueFactory(spinnerValueFactoryHuman);
        botSpinner.setValueFactory(spinnerValueFactoryBot);

        humanSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            humanPlayers = newValue;
            maxBotPlayers = MAX_NUM_PLAYERS - humanPlayers;
            spinnerValueFactoryBot.setMax(maxBotPlayers);
            });

        botSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            botPlayers = newValue;
            maxHumanPlayers = MAX_NUM_PLAYERS - botPlayers;
            spinnerValueFactoryHuman.setMax(maxHumanPlayers);});

    }

    @FXML
    public void goToMainMenu( ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);

        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setId("panemenu");

        window.setScene(tableViewScene);

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((screenBounds.getHeight() - window.getHeight()) / 2);

        window.show();
    }
}