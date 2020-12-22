import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.TradeModel;
import model.player.Player;
import model.tiles.property.TitleDeedCard;

import java.net.URL;
import java.util.ArrayList;
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
    public ListView<TitleDeedCard> playerLeftProperties, playerRightProperties, playerLeftOffered, playerRightOffered;

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
        int max_money_valueA = getProposingPlayer().getBalance();
        int max_money_valueB = getProposedPlayer().getBalance();
        playerLeftLabel.setText(proposingPlayerName);
        playerRightLabel.setText(proposedPlayerName);
        proposingPlayerLabel.setText(proposingPlayerName + " Proposes");
        playerLeftProperties.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        playerLeftOffered.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        playerRightProperties.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        playerRightOffered.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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

        // proposingPlayer, proposedPlayer
        // proposingPlayer.getTitleDeeds().get(i).getPropertyName();

        for (TitleDeedCard deedCard: proposingPlayer.getTitleDeeds()) {
            playerLeftProperties.getItems().add(deedCard);
        }

        for (TitleDeedCard deedCard: proposedPlayer.getTitleDeeds()) {
            playerRightProperties.getItems().add(deedCard);
        }
    }


    private class TradeObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {

        }
    }

    public void handleAddPlayerA() {
        ObservableList<TitleDeedCard> list = playerLeftProperties.getSelectionModel().getSelectedItems();

        for (TitleDeedCard card: list) {
            if (!playerLeftOffered.getItems().contains(card))
                playerLeftOffered.getItems().add(card);
        }
    }

    public void handleAddPlayerB() {
        ObservableList<TitleDeedCard> list = playerRightProperties.getSelectionModel().getSelectedItems();

        for (TitleDeedCard card: list) {
            if (!playerRightOffered.getItems().contains(card))
                playerRightOffered.getItems().add(card);
        }
    }



    public void handlePropose() {
        if (proposedPlayer.isAIControlled()) {
            ArrayList<TitleDeedCard> lefts = new ArrayList<>(playerLeftOffered.getItems());
            ArrayList<TitleDeedCard> rights = new ArrayList<>(playerRightOffered.getItems());
            tradeModel.setTitleDeedCardsPlayer1(lefts);
            tradeModel.setTitleDeedCardsPlayer2(rights);
            tradeModel.setMoneyPlayer1(playerAOfferedMoney);
            tradeModel.setMoneyPlayer2(playerBOfferedMoney);
            tradeModel.setAIAccepts(false);
            tradeModel.startTrade(proposingPlayer, proposedPlayer);
        }
        Alert alert = null;
        ButtonType humanAnswer = ButtonType.YES;
        boolean aiAnswer = true;
        if (!proposedPlayer.isAIControlled()) {
            alert = new Alert(Alert.AlertType.CONFIRMATION, proposedPlayerName + "\nDo you want to accept " + proposingPlayerName + "'s offer?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            humanAnswer = alert.getResult();
        } else {
            aiAnswer = tradeModel.isAIAccepts();
        }

        if (aiAnswer && humanAnswer== ButtonType.YES) {

            ObservableList<TitleDeedCard> deedCardsLeftPlayerOffered = playerLeftOffered.getItems();
            ObservableList<TitleDeedCard> deedCardsRightPlayerOffered = playerRightOffered.getItems();

            for (TitleDeedCard card : deedCardsLeftPlayerOffered) {
                proposedPlayer.getTitleDeeds().add(card);
                proposingPlayer.getTitleDeeds().remove(card);
            }

            for (TitleDeedCard card : deedCardsRightPlayerOffered) {
                proposingPlayer.getTitleDeeds().add(card);
                proposedPlayer.getTitleDeeds().remove(card);
            }


            proposingPlayer.changeBalance(-playerAOfferedMoney);
            proposingPlayer.changeBalance(playerBOfferedMoney);

            proposedPlayer.changeBalance(playerAOfferedMoney);
            proposedPlayer.changeBalance(-playerBOfferedMoney);

            Label label = proposingPlayerLabel;
            Stage stage = (Stage) label.getScene().getWindow();
            stage.close();
        }


    }

    public void handleBack() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    public void handleRemovePlayerA() {
        ObservableList<TitleDeedCard> list = playerLeftOffered.getSelectionModel().getSelectedItems();

        for (TitleDeedCard card: list) {
            playerLeftOffered.getItems().remove(card);
        }
    }

    public void handleRemovePlayerB() {
        ObservableList<TitleDeedCard> list = playerRightOffered.getSelectionModel().getSelectedItems();

        for (TitleDeedCard card: list) {
            playerRightOffered.getItems().remove(card);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
