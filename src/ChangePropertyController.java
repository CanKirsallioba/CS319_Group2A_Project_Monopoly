import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.BoardBuilder;
import model.player.Player;
import model.tiles.property.TitleDeedCard;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChangePropertyController implements Initializable {
    private final int MIN_PROPERTY_VAL = 50;
    private final int MAX_PROPERTY_VAL = 100000;
    private final int STEP_VALUE = 50;
    @FXML
    private TextField propertyNameField = new TextField();
    private String propertyName;

    @FXML
    private Spinner<Integer> rentLevel0Spinner;
    private int rentLevel0;
    @FXML
    private Spinner<Integer> rentLevel1Spinner;
    private int rentLevel1;
    @FXML
    private Spinner<Integer> rentLevel2Spinner;
    private int rentLevel2;
    @FXML
    private Spinner<Integer> rentLevel3Spinner;
    private int rentLevel3;
    @FXML
    private Spinner<Integer> rentLevel4Spinner;
    private int rentLevel4;
    @FXML
    private Spinner<Integer> rentLevel5Spinner;
    private int rentLevel5;
    @FXML
    private Spinner<Integer> propertyValueSpinner;
    private int propertyValue;
    @FXML
    private Spinner<Integer> upgradeSpinner;
    private int upgradeValue;
    @FXML
    private Spinner<Integer> mortgageValueSpinner;
    private int mortgageValue;

    BoardBuilder builder;

    int tileIndex;

    public int getTileIndex() {
        return tileIndex;
    }

    public void setTileIndex(int tileIndex) {
        this.tileIndex = tileIndex;
    }

    public BoardBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(BoardBuilder builder) {
        this.builder = builder;
    }

    public void init(){

        JSONArray tileConfigs = (JSONArray) getBuilder().getConfigTemplate().get("tiles");
        TitleDeedCard deedCard = new TitleDeedCard();
        for (Object tileConfig : tileConfigs) {
            JSONObject tileObj = (JSONObject) ((JSONObject) tileConfig).get("tile");
            if (((Long) tileObj.get("tileIndex")).intValue() == tileIndex) {
                deedCard.setPropertyName((String) tileObj.get("tileName"));
                deedCard.setPropertyValue(((Number) tileObj.get("price")).intValue());
                deedCard.setUpgradeCost(((Number) tileObj.get("upgradeCost")).intValue());
                deedCard.setLevelZeroRent(((Number) tileObj.get("rentLevel0")).intValue());
                deedCard.setLevelOneRent(((Number) tileObj.get("rentLevel1")).intValue());
                deedCard.setLevelTwoRent(((Number) tileObj.get("rentLevel2")).intValue());
                deedCard.setLevelThreeRent(((Number) tileObj.get("rentLevel3")).intValue());
                deedCard.setLevelFourRent(((Number) tileObj.get("rentLevel4")).intValue());
                deedCard.setLevelFiveRent(((Number) tileObj.get("rentLevel5")).intValue());
                deedCard.setMortgageValue(((Number) tileObj.get("mortgageValue")).intValue());
            }
        }

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactory0 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, deedCard.getLevelZeroRent(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactory1 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, deedCard.getLevelOneRent(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactory2 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, deedCard.getLevelTwoRent(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactory3 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, deedCard.getLevelThreeRent(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactory4 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, deedCard.getLevelFourRent(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactory5 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, deedCard.getLevelFiveRent(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactoryProperty =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, deedCard.getPropertyValue(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactoryUpgrade =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, deedCard.getUpgradeCost(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactoryMortgage =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, deedCard.getMortgageValue(), STEP_VALUE);

        rentLevel0Spinner.setValueFactory(spinnerValueFactory0);
        rentLevel1Spinner.setValueFactory(spinnerValueFactory1);
        rentLevel2Spinner.setValueFactory(spinnerValueFactory2);
        rentLevel3Spinner.setValueFactory(spinnerValueFactory3);
        rentLevel4Spinner.setValueFactory(spinnerValueFactory4);
        rentLevel5Spinner.setValueFactory(spinnerValueFactory5);
        propertyValueSpinner.setValueFactory(spinnerValueFactoryProperty);
        upgradeSpinner.setValueFactory( spinnerValueFactoryUpgrade);
        mortgageValueSpinner.setValueFactory( spinnerValueFactoryMortgage);

        rentLevel0 = deedCard.getLevelZeroRent();
        rentLevel1 = deedCard.getLevelOneRent();
        rentLevel2 = deedCard.getLevelTwoRent();
        rentLevel3 = deedCard.getLevelThreeRent();
        rentLevel4 = deedCard.getLevelFourRent();
        rentLevel5 = deedCard.getLevelFiveRent();

        propertyValue = deedCard.getPropertyValue();
        upgradeValue = deedCard.getUpgradeCost();
        mortgageValue = deedCard.getMortgageValue();

        propertyNameField.setText(deedCard.getPropertyName());
        propertyName = deedCard.getPropertyName();

        //property name text field listener
        propertyNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            propertyName = newValue;
        });

        //spinner listeners
        rentLevel0Spinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            rentLevel0 = newValue;
        });
        rentLevel1Spinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            rentLevel1 = newValue;
        });
        rentLevel2Spinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            rentLevel2 = newValue;
        });
        rentLevel3Spinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            rentLevel3 = newValue;
        });
        rentLevel4Spinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            rentLevel4 = newValue;
        });
        rentLevel5Spinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            rentLevel5 = newValue;
        });
        propertyValueSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            propertyValue = newValue;
        });
        upgradeSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            upgradeValue = newValue;
        });
        mortgageValueSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            mortgageValue = newValue;
        });

    }


    public void handleBack(ActionEvent event) {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }
    public void handleApply( ActionEvent event) {
        getBuilder().changePropertyValues( tileIndex, propertyName, rentLevel0, rentLevel1, rentLevel2, rentLevel3,
                rentLevel4, rentLevel5, upgradeValue, propertyValue, mortgageValue);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
