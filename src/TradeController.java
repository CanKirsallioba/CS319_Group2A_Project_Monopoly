import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.TradeModel;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class TradeController implements Initializable {

    @FXML
    public Button playerAAddButton;
    public Button playerBAddButton;

    public Button playerAProposeButton;
    public Button backButton;

    public TextField playerAMoney, playerBMoney;

    public TradeModel getTradeModel() {
        return tradeModel;
    }

    public void setTradeModel(TradeModel tradeModel) {
        this.tradeModel = tradeModel;
    }

    TradeModel tradeModel;


    public void init() {

    }
    private class TradeObserver implements Observer {

        @Override
        public void update(Observable o, Object arg) {

        }
    }

    public void handleAddPlayerB() {}
    public void handleAddPlayerA() {}
    public void handlePropose() {}
    public void handleBack() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
