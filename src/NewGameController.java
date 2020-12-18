import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.BoardConfiguration;
import model.session.GameSession;

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

    private int numOfPlayers;

    //change String into Board when Board Model class is implemented
    @FXML
    private ComboBox<String> comboBoard;
    private ObservableList<String> comboBoardData = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> comboPace;
    private ObservableList<String> comboPaceData = FXCollections.observableArrayList();

    //change String into AICharacteristic object when it is implemented
    @FXML
    private ComboBox<String> comboAI;
    private ObservableList<String> comboAIData = FXCollections.observableArrayList();

    SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactoryHuman = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, maxHumanPlayers);
    SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactoryBot= new SpinnerValueFactory.IntegerSpinnerValueFactory(0, maxBotPlayers);

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        //spinner management, makes sure the player number is at most 6
        humanSpinner.setValueFactory(spinnerValueFactoryHuman);
        botSpinner.setValueFactory(spinnerValueFactoryBot);

        //spinner listeners
        humanSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            humanPlayers = newValue;
            maxBotPlayers = MAX_NUM_PLAYERS - humanPlayers;
            spinnerValueFactoryBot.setMax(maxBotPlayers);
            });

        botSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            botPlayers = newValue;
            maxHumanPlayers = MAX_NUM_PLAYERS - botPlayers;
            spinnerValueFactoryHuman.setMax(maxHumanPlayers);});

        //combobox for board initialization, dummy initialization since no Board model class at the moment
        //fill this from stored board templates
        comboBoardData.add("CLASSIC");
        comboBoardData.add("BILKENT");
        comboBoardData.add("HALLOWEEN");

        //set the data
        comboBoard.setItems(comboBoardData);

        //combobox for pace initialization with string representations
        comboPaceData.add("EASY");
        comboPaceData.add("MEDIUM");
        comboPaceData.add("HARD");

        //set the data
        comboPace.setItems(comboPaceData);

        //combobox for ai characteristic initialization, this will be replaced by reading available ai characteristics list
        //or by declaring ai characteristic objects here with "new" keyword
        comboAIData.add("ADVENTUROUS CAPITALIST");
        comboAIData.add("EBENEZER SCROOGE");

        //set the data
        comboAI.setItems(comboAIData);

    }

    @FXML
    public void goToMainMenu( ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);

        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setId("pane");
//        GameBoardController controller = fxmlLoader.<GameBoardController>getController();
        window.setScene(tableViewScene);

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((screenBounds.getHeight() - window.getHeight()) / 2);

        window.show();
    }

    @FXML
    //strings will be changed to Board objects
    private void handleComboBoardAction() {
        String selectedBoard = comboBoard.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleComboPaceAction() {
        String selectedPace = comboPace.getSelectionModel().getSelectedItem();
    }

    @FXML
    //Strings will be changed to AIChar objects
    private void handleComboAIAction() {
        String selectedAIChar = comboAI.getSelectionModel().getSelectedItem();
    }

    @FXML
    //where we give/save these settings to boardconfig object (model)
    private void handleStartGame(ActionEvent event) throws IOException {
        // User ID acquired from a textbox called txtUserId
//        int userId = Integer.parseInt(this.txtUserId.getText());

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameBoard.fxml"));

        Parent root = (Parent)fxmlLoader.load();
        GameBoardController controller = fxmlLoader.<GameBoardController>getController();
        controller.setGameSession(new GameSession());
        Scene scene = new Scene(root);


        numOfPlayers = humanPlayers + botPlayers;

//        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GameBoard.fxml"));
//        Scene tableViewScene = new Scene(tableViewParent);
//        BoardConfiguration boardConfiguration;
        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);

        //primaryStage.setMaximized(true);
        //primaryStage.setFullScreen(true);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((screenBounds.getHeight() - window.getHeight()) / 2);
        window.show();


    }
}