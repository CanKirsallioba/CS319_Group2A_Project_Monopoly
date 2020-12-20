import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.player.Player;
import model.session.TurnManager;
import model.tiles.GameAction;
import model.tiles.property.TitleDeedCard;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InformationCardController implements Initializable {
    @FXML
    private ListView<String> listView = new ListView<String>();
    private ObservableList<String> listViewData = FXCollections.observableArrayList();

    private String selectedTitleDeedCardName = "";
    private TitleDeedCard selectedTitleDeedCard = null;
    public TurnManager turnManager;

    public TurnManager getTurnManager() {
        return turnManager;
    }

    public void setTurnManager(TurnManager turnManager) {
        this.turnManager = turnManager;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    private Player player;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    private Player currentPlayer;

    @FXML
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public AnchorPane titleDeedCard;
    public Label propertyNameLabel, rentSiteOnlyValueLabel;
    public Label rentWith1HouseValueLabel;
    public Label rentWith2HousesValueLabel;
    public Label rentWith3HousesValueLabel;
    public Label rentWith4HousesValueLabel;
    public Label rentWithHotelValueLabel;
    public Label costOfHousesValueLabel;
    public Label costOfHotelsValueLabel;
    public Label mortgageValueLabel;
    public Label costLabel;
    public Pane propertyColorPane;

    Button[] buttons;


    public void handleButton1() {
        selectedTitleDeedCard.getPropertyActions().get(0).execute();
        updateTitleDeedCard();
        updateButtons();
    }

    public void handleButton2() {
        selectedTitleDeedCard.getPropertyActions().get(1).execute();
        updateTitleDeedCard();
        updateButtons();
    }

    public void handleButton3() {
        selectedTitleDeedCard.getPropertyActions().get(2).execute();
        updateTitleDeedCard();
        updateButtons();
    }

    public void handleButton4() {
        selectedTitleDeedCard.getPropertyActions().get(3).execute();
        updateTitleDeedCard();
        updateButtons();
    }

    public void handleButton5() {
        listViewData.clear();

        Stage stage = (Stage)button5.getScene().getWindow();
        stage.close();
        player.declareBankruptcy();
        turnManager.endTurn();
        updateTitleDeedCard();
        updateButtons();
    }

    public void updateTitleDeedCard() {
        for (TitleDeedCard titleDeedCard : player.getTitleDeeds()) {
            if (titleDeedCard.getPropertyName().equals(selectedTitleDeedCardName)) {
                selectedTitleDeedCard = titleDeedCard;
                player.setSelectedTitleDeed(selectedTitleDeedCard);
            }
        }
        // todo set labels.
        if (selectedTitleDeedCard == null || player.isBankrupt()) {
            titleDeedCard.setVisible(false);
        } else {
            propertyNameLabel.setText(selectedTitleDeedCard.getPropertyName() + " LVL." + selectedTitleDeedCard.getUpgradeLevel());
            rentSiteOnlyValueLabel.setText("" + selectedTitleDeedCard.getLevelZeroRent());
            rentWith1HouseValueLabel.setText("" + selectedTitleDeedCard.getLevelOneRent());
            rentWith2HousesValueLabel.setText("" + selectedTitleDeedCard.getLevelTwoRent());
            rentWith3HousesValueLabel.setText("" + selectedTitleDeedCard.getLevelThreeRent());
            rentWith4HousesValueLabel.setText("" + selectedTitleDeedCard.getLevelFourRent());
            rentWithHotelValueLabel.setText("" + selectedTitleDeedCard.getLevelFiveRent());
            costOfHousesValueLabel.setText("" + selectedTitleDeedCard.getUpgradeCost());
            costOfHotelsValueLabel.setText("" + selectedTitleDeedCard.getUpgradeCost());
            mortgageValueLabel.setText("" + selectedTitleDeedCard.getMortgageValue());
            titleDeedCard.setVisible(true);
            costLabel.setText(selectedTitleDeedCard.getPropertyValue() + "");
            GameBoardController.paintPane(propertyColorPane, selectedTitleDeedCard.getColorGroup().getColor().name());
        }
    }


    public void updateButtons() {
//        System.out.println("Information card player 1" + player);
//        System.out.println("Information card player 1" + player);
        if (player != currentPlayer) {
            button1.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            button5.setVisible(false);
        } else if (selectedTitleDeedCard == null) {
            button1.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            button5.setVisible(!player.isBankrupt() && !player.isAIControlled());
        } else {
            ArrayList<GameAction> actions = selectedTitleDeedCard.getPropertyActions();
            int buttonCount = 0;
            for (GameAction action : actions) {
                System.out.println("INFORMATION CARD" + action);

            }
            int actionCounter = 0;
            for (int i = buttonCount; i < 4; i++) {
                if (i < actions.size()) {
                    buttons[i].setVisible(!player.isAIControlled());
                    buttons[i].setText(actions.get(actionCounter).getName());
                    actionCounter++;
                } else {
                    buttons[i].setVisible(false);
                }

            }

            button5.setVisible(!player.isBankrupt() && !player.isAIControlled());
        }
    }

    public void init() {
        System.out.println(player.toString());
        String informationOfPlayer = "";
        String informationOfProperty;
        int index = 1;

        buttons = new Button[]{button1, button2, button3, button4};

        ArrayList<TitleDeedCard> deedCards = player.getTitleDeeds();


        for (TitleDeedCard deedCard : deedCards) {
            listViewData.add(deedCard.getPropertyName());
        }
        listView.setItems(listViewData);

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                selectedTitleDeedCardName = newValue;
                updateTitleDeedCard();
                updateButtons();
//                System.out.println(selectedSaveFileName);
            }
        });
        updateButtons();
        updateTitleDeedCard();
        if (!listViewData.isEmpty()) listView.getSelectionModel().select(0);


//        informationLabel.setText(informationOfPlayer);
//        informationCardScrollPane.setContent(informationLabel);
//        informationLabel.setStyle("-fx-text-fill: #000000");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
