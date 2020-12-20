import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.TradeModel;
import model.player.Player;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class TradeController implements Initializable {

    public Pane playerAPropertiesPane;
    public Pane playerAOfferedPane;
    public Pane playerBOfferedPane;
    public Pane playerBPropertiesPane;
    private Player proposingPlayer, proposedPlayer;

    private final int MIN_MONEY_VALUE = 0;
    private final int DEFAULT_MONEY = 0;
    private final int STEP_VALUE = 50;

    @FXML
    public ListView playerLeftProperties, playerRightProperties, playerLeftOffered, playerRightOffered;

    @FXML
    public Label playerLeftLabel, proposingPlayerLabel, playerRightLabel;

    @FXML
    public Button playerAAddButton;
    public Button playerBAddButton;

    public Button playerAProposeButton;
    public Button backButton;

    @FXML
    private Spinner<Integer> playerASpinner;
    private int playerAOfferedMoney;
    @FXML
    private Spinner<Integer> playerBSpinner;
    private int playerBOfferedMoney;

    public TradeModel getTradeModel() {
        return tradeModel;
    }

    public void setTradeModel(TradeModel tradeModel) {
        this.tradeModel = tradeModel;
    }

    public String getProposingPlayerName() {
        return proposingPlayerName;
    }

    public void setProposingPlayerName(String proposingPlayerName) {
        this.proposingPlayerName = proposingPlayerName;
    }

    public String getProposedPlayerName() {
        return proposedPlayerName;
    }

    public void setProposedPlayerName(String proposedPlayerName) {
        this.proposedPlayerName = proposedPlayerName;
    }

    private String proposingPlayerName, proposedPlayerName;

    public Player getProposingPlayer() {
        return proposingPlayer;
    }

    public void setProposingPlayer(Player proposingPlayer) {
        this.proposingPlayer = proposingPlayer;
    }

    public Player getProposedPlayer() {
        return proposedPlayer;
    }

    public void setProposedPlayer(Player proposedPlayer) {
        this.proposedPlayer = proposedPlayer;
    }

    TradeModel tradeModel;


    public void init() {
        System.out.println("CAPSLOCKINDICATORWUHU");
        int max_money_valueA = getProposingPlayer().getBalance();
        int max_money_valueB = getProposedPlayer().getBalance();
        System.out.println( max_money_valueA);
        System.out.println( max_money_valueB);
        //playerLeftProperties.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //playerLeftOffered.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //playerRightProperties.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //playerRightOffered.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactoryA =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_MONEY_VALUE, max_money_valueA, DEFAULT_MONEY, STEP_VALUE);

        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactoryB =
                new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_MONEY_VALUE, max_money_valueB, DEFAULT_MONEY, STEP_VALUE);

        playerASpinner.setValueFactory( spinnerValueFactoryA);
        playerBSpinner.setValueFactory( spinnerValueFactoryB);

        playerASpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            playerAOfferedMoney = newValue;
        });
        playerBSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            playerBOfferedMoney = newValue;
        });
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
