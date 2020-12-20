import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.BoardBuilder;
import model.player.Player;
import model.tiles.property.TitleDeedCard;

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


    TitleDeedCard deedCard;

    BoardBuilder builder;

    int tileIndex;

    public int getTileIndex() {
        return tileIndex;
    }

    public void setTileIndex(int tileIndex) {
        this.tileIndex = tileIndex;
    }

    public TitleDeedCard getDeedCard() {
        return deedCard;
    }

    public void setDeedCard(TitleDeedCard deedCard) {
        this.deedCard = deedCard;
    }

    public BoardBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(BoardBuilder builder) {
        this.builder = builder;
    }

    public void init(){

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactory0 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, getDeedCard().getLevelZeroRent(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactory1 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, getDeedCard().getLevelOneRent(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactory2 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, getDeedCard().getLevelTwoRent(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactory3 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, getDeedCard().getLevelThreeRent(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactory4 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, getDeedCard().getLevelFourRent(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactory5 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, getDeedCard().getLevelFiveRent(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactoryProperty =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, getDeedCard().getPropertyValue(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactoryUpgrade =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, getDeedCard().getUpgradeCost(), STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactoryMortgage =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_PROPERTY_VAL, MAX_PROPERTY_VAL, getDeedCard().getMortgageValue(), STEP_VALUE);

        rentLevel0Spinner.setValueFactory(spinnerValueFactory0);
        rentLevel1Spinner.setValueFactory(spinnerValueFactory1);
        rentLevel2Spinner.setValueFactory(spinnerValueFactory2);
        rentLevel3Spinner.setValueFactory(spinnerValueFactory3);
        rentLevel4Spinner.setValueFactory(spinnerValueFactory4);
        rentLevel5Spinner.setValueFactory(spinnerValueFactory5);
        propertyValueSpinner.setValueFactory(spinnerValueFactoryProperty);
        upgradeSpinner.setValueFactory( spinnerValueFactoryUpgrade);
        mortgageValueSpinner.setValueFactory( spinnerValueFactoryMortgage);

        rentLevel0 = getDeedCard().getLevelZeroRent();
        rentLevel1 = getDeedCard().getLevelOneRent();
        rentLevel2 = getDeedCard().getLevelTwoRent();
        rentLevel3 = getDeedCard().getLevelThreeRent();
        rentLevel4 = getDeedCard().getLevelFourRent();
        rentLevel5 = getDeedCard().getLevelFiveRent();

        propertyValue = getDeedCard().getPropertyValue();
        upgradeValue = getDeedCard().getUpgradeCost();
        mortgageValue = getDeedCard().getMortgageValue();

        propertyNameField.setText(getDeedCard().getPropertyName());
        propertyName = getDeedCard().getPropertyName();

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
