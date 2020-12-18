import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChangePropertyController implements Initializable {

    @FXML /* Labels */
    public Label propertyNameLabel;
    public Label siteOnlyLabel;
    public Label with1HouseLabel;
    public Label with2HousesLabel;
    public Label with3HousesLabel;
    public Label with4HousesLabel;
    public Label withHotelLabel;
    public Label landPriceLabel;
    public Label upgradingPriceLabel;
    public Label mortgageValueLabel;

    @FXML /* Decrease Buttons */
    public Button decreaseSiteOnly;
    public Button decreaseWith1House;
    public Button decreaseWith2Houses;
    public Button decreaseWith3Houses;
    public Button decreaseWith4Houses;
    public Button decreaseWithHotel;
    public Button decreaseLand;
    public Button decreaseUpgradingPrice;
    public Button decreaseMortgageValue;

    @FXML /* Increase Buttons */
    public Button increaseSiteOnly;
    public Button increaseWith1House;
    public Button increaseWith2Houses;
    public Button increaseWith3Houses;
    public Button increaseWith4Houses;
    public Button increaseWithHotel;
    public Button increaseLand;
    public Button increaseUpgradingPrice;
    public Button increaseMortgageValue;

    @FXML /* Decrease Listeners */
    public void handleDecreaseSiteOnly() {
        decreaseLabel(siteOnlyLabel);
    }
    public void handleDecreaseWith1House() {
        decreaseLabel(with1HouseLabel);
    }
    public void handleDecreaseWith2Houses() {
        decreaseLabel(with2HousesLabel);
    }
    public void handleDecreaseWith3Houses() {
        decreaseLabel(with3HousesLabel);
    }
    public void handleDecreaseWith4Houses() {
        decreaseLabel(with4HousesLabel);
    }
    public void handleDecreaseWithHotel() {
        decreaseLabel(withHotelLabel);
    }
    public void handleDecreaseLand() {
        decreaseLabel(landPriceLabel);
    }
    public void handleDecreaseUpgradingPrice() {
        decreaseLabel(upgradingPriceLabel);
    }
    public void handleDecreaseMortgageValue() {
        decreaseLabel(mortgageValueLabel);
    }

    private void decreaseLabel(Label label) {
        int currentPrice = Integer.parseInt(label.getText());
        currentPrice -= 25;
        label.setText(String.valueOf(currentPrice));
    }

    private void increaseLabel(Label label) {
        int currentPrice = Integer.parseInt(label.getText());
        currentPrice += 25;
        label.setText(String.valueOf(currentPrice));
    }

    @FXML /* Increase Listeners */
    public void handleIncreaseSiteOnly() throws IOException {
        increaseLabel(siteOnlyLabel);
    }
    public void handleIncreaseWith1House() {
        increaseLabel(with1HouseLabel);
    }
    public void handleIncreaseWith2Houses() {
        increaseLabel(with2HousesLabel);
    }
    public void handleIncreaseWith3Houses() {
        increaseLabel(with3HousesLabel);
    }
    public void handleIncreaseWith4Houses() {
        increaseLabel(with4HousesLabel);
    }
    public void handleIncreaseWithHotel() {
        increaseLabel(withHotelLabel);
    }
    public void handleIncreaseLand() {
        increaseLabel(landPriceLabel);
    }
    public void handleIncreaseUpgradingPrice() {
        increaseLabel(upgradingPriceLabel);
    }
    public void handleIncreaseMortgageValue() {
        increaseLabel(mortgageValueLabel);
    }

    public void handleBack(ActionEvent event) {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }
    public void handleApply() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
