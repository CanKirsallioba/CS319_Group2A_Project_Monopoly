import data.ConfigHandler;
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
import model.BoardBuilder;
import model.tiles.property.TitleDeedCard;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BoardBuilderController implements Initializable {
    private final int MIN_SALARY = 200;
    private final int MAX_SALARY = 5000;
    private final int INITIAL_VAL = 400;
    private final int STEP_SALARY = 200;

    @FXML
    private TextField boardNameField = new TextField();
    private String boardName;

    BoardBuilder builder = new BoardBuilder();

    @FXML
    private Spinner<Integer> salarySpinner;
    private int goTileSalary = INITIAL_VAL;
    ConfigHandler configHandler = new ConfigHandler();

    SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactorySalary =
            new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_SALARY, MAX_SALARY, INITIAL_VAL, STEP_SALARY);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

            //spinner set factory
            salarySpinner.setValueFactory(spinnerValueFactorySalary);

            //spinner listener
            salarySpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
                goTileSalary = newValue;
            });

            //board name text field listener
            boardNameField.textProperty().addListener((observable, oldValue, newValue) -> {
                boardName = newValue;
            });
    }

    @FXML
    public void handleTitleDeed(TitleDeedCard deedCard, BoardBuilder builder, int tileIndex) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChangeProperty.fxml"));

        Parent root = fxmlLoader.load();
        ChangePropertyController controller = fxmlLoader.<ChangePropertyController>getController();
        controller.setDeedCard(deedCard);
        controller.setBuilder( builder);
        controller.setTileIndex( tileIndex);
        controller.init();

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Property ");
        Scene scene = new Scene(root);
        stage.setScene( scene);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - scene.getWidth()) / 2);
        stage.setY((screenBounds.getHeight() - scene.getHeight()) / 2);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void selectProperty(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        int id = Integer.parseInt(clickedButton.getId());
        System.out.println( id);

        JSONObject configTemplate = configHandler.getConfigTemplate();
        JSONArray tileConfigs = (JSONArray) configTemplate.get("tiles");
        TitleDeedCard deedCard = new TitleDeedCard();
        for (Object tileConfig : tileConfigs) {
            JSONObject tileObj = (JSONObject) ((JSONObject) tileConfig).get("tile");
            if (((Long) tileObj.get("tileIndex")).intValue() == id) {
                deedCard.setPropertyName((String) tileObj.get("tileName"));
                deedCard.setPropertyValue(((Long) tileObj.get("price")).intValue());
                deedCard.setUpgradeCost(((Long) tileObj.get("upgradeCost")).intValue());
                deedCard.setLevelZeroRent(((Long) tileObj.get("rentLevel0")).intValue());
                deedCard.setLevelOneRent(((Long) tileObj.get("rentLevel1")).intValue());
                deedCard.setLevelTwoRent(((Long) tileObj.get("rentLevel2")).intValue());
                deedCard.setLevelThreeRent(((Long) tileObj.get("rentLevel3")).intValue());
                deedCard.setLevelFourRent(((Long) tileObj.get("rentLevel4")).intValue());
                deedCard.setLevelFiveRent(((Long) tileObj.get("rentLevel5")).intValue());
                deedCard.setMortgageValue(((Long) tileObj.get("mortgageValue")).intValue());

                handleTitleDeed( deedCard, builder, id);
            }
        }
    }

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
    public void handleSaveBoard( ActionEvent event) throws IOException {
        builder.changeBoardValues( goTileSalary, boardName);
        builder.saveBoard();

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

}
