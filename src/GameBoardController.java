import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.AuctionModel;
import model.TradeModel;
import model.board.Board;
import model.player.Dice;
import model.player.Player;
import model.session.GameSession;
import model.session.TurnManager;
import model.tiles.GameAction;
import model.tiles.PropertyTile;
import model.tiles.Tile;
import model.tiles.card.Card;
import model.tiles.property.TitleDeedCard;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class GameBoardController implements Initializable {


    public AnchorPane gameBoard;
    public String lastExecutedActionName = "";
    //    Image[] diceImages = {File file = new File("src/Box13.jpg");
//    Image image1 = new Image(file.toURI().toString());};
    @FXML
    TurnManager turnManager;
    @FXML
    Board board;
    @FXML
    Dice dice;
    @FXML
    ArrayList<Player> playerList;
    // trade controllera bu modeli aktarmak gerekli.
    @FXML
    TradeModel model;

    // auction controllera bu modeli aktarmak gerekli.
    @FXML
    AuctionModel auctionModel;
    @FXML
    ImageView[] player6TokenImages;
    @FXML
    ImageView[][] playerTokenList;
    @FXML
    ImageView[] player5TokenImages;
    @FXML
    ImageView[] player4TokenImages;
    @FXML
    ImageView[] player3TokenImages;
    @FXML
    ImageView[] player1TokenImages;
    @FXML
    ImageView[] player2TokenImages;
    @FXML
    AnchorPane[] playerCardAnchorPanes;
    @FXML
    Label[] playerMoneyLabels;
    @FXML
    Label[] playerNumberOfPropertiesLabels;
    @FXML
    Button[] playerTradeButtonList;

    ArrayList<String> playerNames;

    public void init() {


        Label[] nameLabels = {brownLabel1, brownLabel2, lightBlueLabel1, lightBlueLabel2, lightBlueLabel3,
                pinkLabel1, pinkLabel2, pinkLabel3, orangeLabel1, orangeLabel2, orangeLabel3,
                redLabel1, redLabel2, redLabel3, yellowLabel1, yellowLabel2, yellowLabel3,
                greenLabel1, greenLabel2, greenLabel3, blueLabel1, blueLabel2};

        Label[] priceLabels = {brownPrice1, brownPrice2, lightBluePrice1, lightBluePrice2, lightBluePrice3,
                pinkPrice1, pinkPrice2, pinkPrice3, orangePrice1, orangePrice2, orangePrice3,
                redPrice1, redPrice2, redPrice3, yellowPrice1, yellowPrice2, yellowPrice3,
                greenPrice1, greenPrice2, greenPrice3, bluePrice1, bluePrice2};

        player1TokenImages = new ImageView[]{player1Tile0TokenImage, player1Tile1TokenImage, player1Tile2TokenImage, player1Tile3TokenImage, player1Tile4TokenImage, player1Tile5TokenImage, player1Tile6TokenImage, player1Tile7TokenImage, player1Tile8TokenImage, player1Tile9TokenImage, player1Tile10TokenImage, player1Tile11TokenImage, player1Tile12TokenImage, player1Tile13TokenImage, player1Tile14TokenImage, player1Tile15TokenImage, player1Tile16TokenImage, player1Tile17TokenImage, player1Tile18TokenImage, player1Tile19TokenImage, player1Tile20TokenImage, player1Tile21TokenImage, player1Tile22TokenImage, player1Tile23TokenImage, player1Tile24TokenImage, player1Tile25TokenImage, player1Tile26TokenImage, player1Tile27TokenImage, player1Tile28TokenImage, player1Tile29TokenImage, player1Tile30TokenImage, player1Tile31TokenImage, player1Tile32TokenImage, player1Tile33TokenImage, player1Tile34TokenImage, player1Tile35TokenImage, player1Tile36TokenImage, player1Tile37TokenImage, player1Tile38TokenImage, player1Tile39TokenImage};
        player2TokenImages = new ImageView[]{player2Tile0TokenImage, player2Tile1TokenImage, player2Tile2TokenImage, player2Tile3TokenImage, player2Tile4TokenImage, player2Tile5TokenImage, player2Tile6TokenImage, player2Tile7TokenImage, player2Tile8TokenImage, player2Tile9TokenImage, player2Tile10TokenImage, player2Tile11TokenImage, player2Tile12TokenImage, player2Tile13TokenImage, player2Tile14TokenImage, player2Tile15TokenImage, player2Tile16TokenImage, player2Tile17TokenImage, player2Tile18TokenImage, player2Tile19TokenImage, player2Tile20TokenImage, player2Tile21TokenImage, player2Tile22TokenImage, player2Tile23TokenImage, player2Tile24TokenImage, player2Tile25TokenImage, player2Tile26TokenImage, player2Tile27TokenImage, player2Tile28TokenImage, player2Tile29TokenImage, player2Tile30TokenImage, player2Tile31TokenImage, player2Tile32TokenImage, player2Tile33TokenImage, player2Tile34TokenImage, player2Tile35TokenImage, player2Tile36TokenImage, player2Tile37TokenImage, player2Tile38TokenImage, player2Tile39TokenImage};
        player3TokenImages = new ImageView[]{player3Tile0TokenImage, player3Tile1TokenImage, player3Tile2TokenImage, player3Tile3TokenImage, player3Tile4TokenImage, player3Tile5TokenImage, player3Tile6TokenImage, player3Tile7TokenImage, player3Tile8TokenImage, player3Tile9TokenImage, player3Tile10TokenImage, player3Tile11TokenImage, player3Tile12TokenImage, player3Tile13TokenImage, player3Tile14TokenImage, player3Tile15TokenImage, player3Tile16TokenImage, player3Tile17TokenImage, player3Tile18TokenImage, player3Tile19TokenImage, player3Tile20TokenImage, player3Tile21TokenImage, player3Tile22TokenImage, player3Tile23TokenImage, player3Tile24TokenImage, player3Tile25TokenImage, player3Tile26TokenImage, player3Tile27TokenImage, player3Tile28TokenImage, player3Tile29TokenImage, player3Tile30TokenImage, player3Tile31TokenImage, player3Tile32TokenImage, player3Tile33TokenImage, player3Tile34TokenImage, player3Tile35TokenImage, player3Tile36TokenImage, player3Tile37TokenImage, player3Tile38TokenImage, player3Tile39TokenImage};
        player4TokenImages = new ImageView[]{player4Tile0TokenImage, player4Tile1TokenImage, player4Tile2TokenImage, player4Tile3TokenImage, player4Tile4TokenImage, player4Tile5TokenImage, player4Tile6TokenImage, player4Tile7TokenImage, player4Tile8TokenImage, player4Tile9TokenImage, player4Tile10TokenImage, player4Tile11TokenImage, player4Tile12TokenImage, player4Tile13TokenImage, player4Tile14TokenImage, player4Tile15TokenImage, player4Tile16TokenImage, player4Tile17TokenImage, player4Tile18TokenImage, player4Tile19TokenImage, player4Tile20TokenImage, player4Tile21TokenImage, player4Tile22TokenImage, player4Tile23TokenImage, player4Tile24TokenImage, player4Tile25TokenImage, player4Tile26TokenImage, player4Tile27TokenImage, player4Tile28TokenImage, player4Tile29TokenImage, player4Tile30TokenImage, player4Tile31TokenImage, player4Tile32TokenImage, player4Tile33TokenImage, player4Tile34TokenImage, player4Tile35TokenImage, player4Tile36TokenImage, player4Tile37TokenImage, player4Tile38TokenImage, player4Tile39TokenImage};
        player5TokenImages = new ImageView[]{player5Tile0TokenImage, player5Tile1TokenImage, player5Tile2TokenImage, player5Tile3TokenImage, player5Tile4TokenImage, player5Tile5TokenImage, player5Tile6TokenImage, player5Tile7TokenImage, player5Tile8TokenImage, player5Tile9TokenImage, player5Tile10TokenImage, player5Tile11TokenImage, player5Tile12TokenImage, player5Tile13TokenImage, player5Tile14TokenImage, player5Tile15TokenImage, player5Tile16TokenImage, player5Tile17TokenImage, player5Tile18TokenImage, player5Tile19TokenImage, player5Tile20TokenImage, player5Tile21TokenImage, player5Tile22TokenImage, player5Tile23TokenImage, player5Tile24TokenImage, player5Tile25TokenImage, player5Tile26TokenImage, player5Tile27TokenImage, player5Tile28TokenImage, player5Tile29TokenImage, player5Tile30TokenImage, player5Tile31TokenImage, player5Tile32TokenImage, player5Tile33TokenImage, player5Tile34TokenImage, player5Tile35TokenImage, player5Tile36TokenImage, player5Tile37TokenImage, player5Tile38TokenImage, player5Tile39TokenImage};
        player6TokenImages = new ImageView[]{player6Tile0TokenImage, player6Tile1TokenImage, player6Tile2TokenImage, player6Tile3TokenImage, player6Tile4TokenImage, player6Tile5TokenImage, player6Tile6TokenImage, player6Tile7TokenImage, player6Tile8TokenImage, player6Tile9TokenImage, player6Tile10TokenImage, player6Tile11TokenImage, player6Tile12TokenImage, player6Tile13TokenImage, player6Tile14TokenImage, player6Tile15TokenImage, player6Tile16TokenImage, player6Tile17TokenImage, player6Tile18TokenImage, player6Tile19TokenImage, player6Tile20TokenImage, player6Tile21TokenImage, player6Tile22TokenImage, player6Tile23TokenImage, player6Tile24TokenImage, player6Tile25TokenImage, player6Tile26TokenImage, player6Tile27TokenImage, player6Tile28TokenImage, player6Tile29TokenImage, player6Tile30TokenImage, player6Tile31TokenImage, player6Tile32TokenImage, player6Tile33TokenImage, player6Tile34TokenImage, player6Tile35TokenImage, player6Tile36TokenImage, player6Tile37TokenImage, player6Tile38TokenImage, player6Tile39TokenImage};
        playerTokenList = new ImageView[][]{player1TokenImages, player2TokenImages, player3TokenImages, player4TokenImages, player5TokenImages, player6TokenImages};
        playerTradeButtonList = new Button[]{p1TradeButton, p2TradeButton, p3TradeButton, p4TradeButton, p5TradeButton, p6TradeButton};

        Label[] arr = {lightBlueLabel1, lightBlueLabel2, lightBlueLabel3};
        GameActionButtonObserver gameActionButtonObserver = new GameActionButtonObserver(button1, 0);
        GameActionButtonObserver gameActionButtonObserver1 = new GameActionButtonObserver(button2, 1);
        GameActionButtonObserver gameActionButtonObserver2 = new GameActionButtonObserver(button3, 2);
        GameActionButtonObserver gameActionButtonObserver3 = new GameActionButtonObserver(button4, 3);
        ArrayList<Player> players = getGameSession().getTurnManager().getPlayers();
        TitleDeedCardObserver titleDeedCardObserver = new TitleDeedCardObserver();
        CurrentlyDrawnCardObserver currentlyDrawnCardObserver = new CurrentlyDrawnCardObserver();
        DiceObserver diceObserver = new DiceObserver();
        playerCardAnchorPanes = new AnchorPane[]{player1Card, player2Card, player3Card, player4Card, player5Card, player6Card};
        playerMoneyLabels = new Label[]{p1moneyLabel, p2moneyLabel, p3moneyLabel, p4moneyLabel, p5moneyLabel, p6moneyLabel};
        playerNumberOfPropertiesLabels = new Label[]{p1NumOfPropLabel, p2NumOfPropLabel, p3moneyLabel, p4NumOfPropLabel, p5moneyLabel, p6NameLabel};

        playerList = getGameSession().getTurnManager().getPlayers();

        board = getGameSession().getBoard();

        int counter = 0;
        for (Tile tile : board.getTiles()) {
            if (tile instanceof PropertyTile) {
                nameLabels[counter].setText(((PropertyTile) tile).getTitleDeedCard().getPropertyName());
                priceLabels[counter].setText(String.valueOf(((PropertyTile) tile).getTitleDeedCard().getPropertyValue()));
                counter++;
            }
        }
        Label[] playerNameLabels = {p1NameLabel, p2NameLabel, p3NameLabel, p4NameLabel, p5NameLabel, p6NameLabel};

        turnManager = getGameSession().getTurnManager();
//        System.out.println(players.size());
        int playerCount = 0;

        for (AnchorPane playerCardAnchorPane : playerCardAnchorPanes) {
            if (playerCount < players.size()) {
                playerCardAnchorPane.setVisible(true);
            } else {
                playerCardAnchorPane.setVisible(false);
            }
            playerCount++;
        }
        for (ImageView view : player1TokenImages) {
            view.setVisible(false);
        }

        for (ImageView view : player2TokenImages) {
            view.setVisible(false);
        }

        for (ImageView view : player3TokenImages) {
            view.setVisible(false);
        }

        for (ImageView view : player4TokenImages) {
            view.setVisible(false);
        }

        for (ImageView view : player5TokenImages) {
            view.setVisible(false);
        }

        for (ImageView view : player6TokenImages) {
            view.setVisible(false);
        }
        int aiPlayerCount = 1;
        int humanPlayerCount = 1;
        playerNames = new ArrayList<>();

        for (Player player : players) {
            Observable observable = (Observable) player;
            observable.addObserver(gameActionButtonObserver);
            observable.addObserver(gameActionButtonObserver1);
            observable.addObserver(gameActionButtonObserver2);
            observable.addObserver(gameActionButtonObserver3);
            observable.addObserver(titleDeedCardObserver);
            observable.addObserver(currentlyDrawnCardObserver);
            observable.addObserver(new PlayerCardObserver());
            observable.addObserver(diceObserver);
//            observable.addObserver(new PlayerObserver());
            if (player.isAIControlled()) {
                playerNames.add("AI Player " + aiPlayerCount);
                aiPlayerCount++;
            } else {
                playerNames.add("Human Player " + humanPlayerCount);
                humanPlayerCount++;
            }

            int i = 0;
            for (Tile tile : getBoard().getTiles()) {
                observable.addObserver(new TileObserver(i));
                i++;
            }

            playerCardObserverUpdate(observable);
            currentlyDrawnCardObserverUpdate(observable);
            playerCardObserverUpdate(observable);
            diceObserverUpdate(observable);
            player.setCurrentTile(player.getPlayerToken().getBoard().getTiles().get(player.getPlayerToken().getCurrentTileIndex()));
            tileObserverUpdate(observable, player.getCurrentTile().getIndex());
        }
        for (int i = 0; i < getPlayerList().size(); i++) {
            playerNameLabels[i].setText(playerNames.get(i));
        }


        getGameSession().getTurnManager().getCurrentPlayer().playTurn();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @FXML
    private ImageView dice1, dice2;


    private void diceObserverUpdate(Observable o) {
        if (o instanceof Player) {
            String name1 = "dice" + getGameSession().getDice().getDice1() + ".png";
            String name2 = "dice" + getGameSession().getDice().getDice2() + ".png";
            dice1.setImage(new Image(name1));
            dice2.setImage(new Image(name2));
        }
    }

    private class DiceObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            diceObserverUpdate(o);
        }
    }

    private void tileObserverUpdate(Observable o, int index) {
        if (o instanceof Player) {
            Player player = (Player) o;
//            System.out.println(playerTokenList[getPlayerList().indexOf(player)][index]);
            playerTokenList[getPlayerList().indexOf(player)][index].setVisible((index == ((Player) o).getCurrentTile().getIndex()) && !player.isBankrupt());

        }
    }

    private class TileObserver implements Observer {
        int index;

        public TileObserver(int index) {
            this.index = index;
        }

        @Override
        public void update(Observable o, Object arg) {
            tileObserverUpdate(o, index);
        }
    }

    private void currentlyDrawnCardObserverUpdate(Observable o) {
        if (o instanceof Player) {
            Card card = getCurrentPlayer().getCurrentlyDrawnCard();
            if (card == null || ((Player) o).isBankrupt()) {
                titleDeedCard1.setVisible(false);
            } else {
                communityOrChanceCardLabel.setText(card.getType());
                cardAction.setText(card.getInstruction());
                titleDeedCard1.setVisible(true);
            }
        }
    }

    private class CurrentlyDrawnCardObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            currentlyDrawnCardObserverUpdate(o);
        }
    }

//    private class PlayerObserver implements Observer {
//        @Override
//        public void update(Observable o, Object arg) {
//            if (o instanceof Player) {
//                if (((Player) o).isBankrupt()) handleEndTurnButton();
//            }
//        }
//    }

    private class GameActionButtonObserver implements Observer {
        Button button;
        int buttonNumber;

        GameActionButtonObserver(Button button, int buttonNumber) {
            this.button = button;
            this.buttonNumber = buttonNumber;
        }

        @Override
        public void update(Observable o, Object arg) {
            if (o instanceof Player) {
//                System.out.println("titledeed: + " + getCurrentPlayer().getTitleDeeds().size() + "actions: " + getPossibleActions().size());
                if (!((Player) o).isAIControlled() &&
                        (buttonNumber < getPossibleActions().size() &&
                                getPossibleActions().get(buttonNumber).isActive() &&
                                !getPossibleActions().get(buttonNumber).getName().equals(lastExecutedActionName)) && !((Player) o).isBankrupt()) {
//                    System.out.println(getPossibleActions().get(buttonNumber).isActive());

//                    System.out.println(buttonNumber + " " + getPossibleActions().get(buttonNumber));
                    button.setVisible(true);
                    button.setText(getPossibleActions().get(buttonNumber).getName());
                } else {
                    button.setVisible(false);

                }
            }
        }
    }

    private void playerCardObserverUpdate(Observable o) {
        Player player = (Player) o;
        int index = getPlayerList().indexOf(player);
        if (getPlayerList().stream().allMatch(Player::isBankrupt)) {
            for (AnchorPane playerCardAnchorPane : playerCardAnchorPanes) {
                playerCardAnchorPane.setVisible(false);
            }
        }
        else {
            for (int i = 0; i < getPlayerList().size(); i++) {
                playerCardAnchorPanes[i].setVisible(!getPlayerList().get(i).isBankrupt());
                if (player == getPlayerList().get(i)) {
                    playerTradeButtonList[i].setDisable(true);
                    playerCardAnchorPanes[i].setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, rgba(2,0,36,1) 0%, rgba(223,174,163,1) 0%, rgba(255,115,87,1) 79%);");
                } else {
                    playerCardAnchorPanes[i].setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, rgba(255,255,255,1) 0%, rgba(29,119,128,1) 100%);");
                    playerTradeButtonList[i].setDisable(false);
                }
            }
        }



        playerMoneyLabels[index].setText("" + player.getBalance());
        playerNumberOfPropertiesLabels[index].setText("" + player.getBalance());

    }

    private class PlayerCardObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            playerCardObserverUpdate(o);
        }
    }

    private class TitleDeedCardObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            if (o instanceof Player) {
                TitleDeedCard card = getCurrentPlayer().getSelectedTitleDeed();
                if (card == null || ((Player) o).isBankrupt()) {
                    titleDeedCard.setVisible(false);
                } else {
                    paintPane(propertyColorPane, card.getColorGroup().getColor().name());
                    propertyNameLabel.setText(card.getPropertyName());
                    rentSiteOnlyValueLabel.setText("" + card.getLevelZeroRent());
                    rentWith1HouseValueLabel.setText("" + card.getLevelOneRent());
                    rentWith2HousesValueLabel.setText("" + card.getLevelTwoRent());
                    rentWith3HousesValueLabel.setText("" + card.getLevelThreeRent());
                    rentWith4HousesValueLabel.setText("" + card.getLevelFourRent());
                    rentWithHotelValueLabel.setText("" + card.getLevelFiveRent());
                    costOfHousesValueLabel.setText("" + card.getUpgradeCost());
                    costOfHotelsValueLabel.setText("" + card.getUpgradeCost());
                    mortgageValueLabel.setText("" + card.getMortgageValue());
                    costLabel.setText(card.getPropertyValue() + "");
                    titleDeedCard.setVisible(true);
                }
            }
        }
    }

    public void handleSeeProperties(Player player, Player currentPlayer) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InformationCard.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        InformationCardController controller = fxmlLoader.<InformationCardController>getController();
        controller.setPlayer(player);
        controller.setCurrentPlayer(currentPlayer);
        controller.setTurnManager(getTurnManager());
        controller.init();

        Stage stage = new Stage(StageStyle.DECORATED);

        stage.setTitle("Information Card");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - scene.getWidth()) / 2);
        stage.setY((screenBounds.getHeight() - scene.getHeight()) / 2);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.centerOnScreen();
        stage.show();
    }

    public void handleTrade(Player proposingPlayer, Player proposedPlayer) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Trade.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        TradeController tradeController = fxmlLoader.<TradeController>getController();
        tradeController.setProposingPlayer(proposingPlayer);
        tradeController.setProposedPlayer(proposedPlayer);

        tradeController.setProposingPlayerName(playerNames.get(getPlayerList().indexOf(proposingPlayer)));
        tradeController.setProposedPlayerName(playerNames.get(getPlayerList().indexOf(proposedPlayer)));
        tradeController.init();

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Trade Screen");
        Scene scene = new Scene(root);

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - scene.getWidth()) / 2);
        stage.setY((screenBounds.getHeight() - scene.getHeight()) / 2);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void handleMenuButton() throws IOException {
//        openPopUp("GameBoardMenu.fxml", "Menu");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameBoardMenu.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        GameBoardMenuController controller = fxmlLoader.<GameBoardMenuController>getController();
        controller.setGameSession(getGameSession());
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Pause Menu");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - scene.getWidth()) / 2);
        stage.setY((screenBounds.getHeight() - scene.getHeight()) / 2);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    public void handleEndTurnButton() {
        lastExecutedActionName = "";
        getCurrentPlayer().setSelectedTitleDeed(null);
        getCurrentPlayer().setCurrentlyDrawnCard(null);
        getGameSession().getTurnManager().endTurn();
//        System.out.println("Player: " + getGameSession().getTurnManager().getCurrentPlayerIndex() + "\n"
//                + "TileIndex: " + getGameSession().getTurnManager().getCurrentPlayer().getCurrentTile().getIndex() + "\n"
//                + "Tile: " + getGameSession().getTurnManager().getCurrentPlayer().getCurrentTile().getTileName());
//
//        System.out.println(getGameSession().getTurnManager().getCurrentPlayer().toString());
    }

    public ArrayList<GameAction> getPossibleActions() {
        return getTurnManager().getCurrentPlayer().getCurrentTile().getPossibleActions(getTurnManager().getCurrentPlayer());
    }

    public Player getCurrentPlayer() {
        return getTurnManager().getCurrentPlayer();
    }

    public Tile getCurrentTile() {
        return getCurrentPlayer().getCurrentTile();
    }


    public void handleActionButton(int index) {
        int i = 0;
        for (GameAction possibleAction : getPossibleActions()) {
            if (possibleAction.isActive()) {
                if (i == index) {
                    lastExecutedActionName = possibleAction.getName();
                    possibleAction.execute();
                }
                i++;

            }

        }
//        System.out.println(getGameSession().getTurnManager().getCurrentPlayer().toString());
    }

    @FXML
    public void handleButton1() {
        handleActionButton(0);
    }

    @FXML
    public void handleButton2() {
        handleActionButton(1);
    }

    @FXML
    public void handleButton3() {
        handleActionButton(2);
    }

    @FXML
    public void handleButton4() {
        handleActionButton(3);
    }

    @FXML
    public void openAuction() throws IOException {
        openPopUp("Auction.fxml", "Auction");
    }

    public void openInformationCard(String title) throws IOException {
        openPopUp("InformationCard.fxml", "Information Card of " + title);
    }

    private void openPopUp(String fxmlFile, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle(title);
        stage.setScene(new Scene(root1));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.centerOnScreen();
        stage.show();
    }

    public void tradeWithPlayer1() throws IOException {
        handleTrade( getCurrentPlayer(), getPlayerList().get(0));
    }

    public void tradeWithPlayer2() throws IOException {
        handleTrade( getCurrentPlayer(), getPlayerList().get(1));
    }

    public void tradeWithPlayer3() throws IOException {
        handleTrade( getCurrentPlayer(), getPlayerList().get(2));
    }

    public void tradeWithPlayer4() throws IOException {
        handleTrade( getCurrentPlayer(), getPlayerList().get(3));
    }

    public void tradeWithPlayer5() throws IOException {
        handleTrade( getCurrentPlayer(), getPlayerList().get(4));
    }

    public void tradeWithPlayer6() throws IOException {
        handleTrade( getCurrentPlayer(), getPlayerList().get(5));
    }

    public void seeInformationCardPlayer1() throws IOException {
        handleSeeProperties(playerList.get(0), getCurrentPlayer());
    }

    public void seeInformationCardPlayer2() throws IOException {
        handleSeeProperties(playerList.get(1), getCurrentPlayer());
    }

    public void seeInformationCardPlayer3() throws IOException {
        handleSeeProperties(playerList.get(2), getCurrentPlayer());
    }

    public void seeInformationCardPlayer4() throws IOException {
        handleSeeProperties(playerList.get(3), getCurrentPlayer());
    }

    public void seeInformationCardPlayer5() throws IOException {
        handleSeeProperties(playerList.get(4), getCurrentPlayer());
    }

    public void seeInformationCardPlayer6() throws IOException {
        handleSeeProperties(playerList.get(5), getCurrentPlayer());
    }

    public void openTitleDeedCard() throws IOException {
        openPopUp("TitleDeedCardUI.fxml", "Title Deed Card");
    }

    public TurnManager getTurnManager() {
        return turnManager;
    }

    public void setTurnManager(TurnManager turnManager) {
        this.turnManager = turnManager;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public static void paintPane(Pane pane, String color) {
        if (color.equals("RED")) {
            pane.setStyle("-fx-background-color:  #FF0900;");
        } else if (color.equals("YELLOW")) {
            pane.setStyle("-fx-background-color:  #FDED00");
        } else if (color.equals("GREEN")) {
            pane.setStyle("-fx-background-color:  #00AC57");
        } else if (color.equals("BLUE")) {
            pane.setStyle("-fx-background-color:  #2744A7");
        } else if (color.equals("BROWN")) {
            pane.setStyle("-fx-background-color: #A0522D");
        } else if (color.equals("LIGHT_BLUE")) {
            pane.setStyle("-fx-background-color:  #84A2DA");
        } else if (color.equals("PINK")) {
            pane.setStyle("-fx-background-color:  #FF0072");
        } else if (color.equals("ORANGE")) {
            pane.setStyle("-fx-background-color:  #FF7900");
        } else {
            throw new RuntimeException("Something wrong with color input (Check if input is String): " + color);
        }
    }

    //
//    @FXML
//    ImageView player1Tile0TokenImage, player1Tile1TokenImage, player1Tile2TokenImage, player1Tile3TokenImage, player1Tile4TokenImage, player1Tile5TokenImage, player1Tile6TokenImage, player1Tile7TokenImage, player1Tile8TokenImage, player1Tile9TokenImage, player1Tile10TokenImage, player1Tile11TokenImage, player1Tile12TokenImage, player1Tile13TokenImage, player1Tile14TokenImage, player1Tile15TokenImage, player1Tile16TokenImage, player1Tile17TokenImage, player1Tile18TokenImage, player1Tile19TokenImage, player1Tile20TokenImage, player1Tile21TokenImage, player1Tile22TokenImage, player1Tile23TokenImage, player1Tile24TokenImage, player1Tile25TokenImage, player1Tile26TokenImage, player1Tile27TokenImage, player1Tile28TokenImage, player1Tile29TokenImage, player1Tile30TokenImage, player1Tile31TokenImage, player1Tile32TokenImage, player1Tile33TokenImage, player1Tile34TokenImage, player1Tile35TokenImage, player1Tile36TokenImage, player1Tile37TokenImage, player1Tile38TokenImage, player1Tile39TokenImage;
//    @FXML
//    ImageView player2Tile0TokenImage, player2Tile1TokenImage, player2Tile2TokenImage, player2Tile3TokenImage, player2Tile4TokenImage, player2Tile5TokenImage, player2Tile6TokenImage, player2Tile7TokenImage, player2Tile8TokenImage, player2Tile9TokenImage, player2Tile10TokenImage, player2Tile11TokenImage, player2Tile12TokenImage, player2Tile13TokenImage, player2Tile14TokenImage, player2Tile15TokenImage, player2Tile16TokenImage, player2Tile17TokenImage, player2Tile18TokenImage, player2Tile19TokenImage, player2Tile20TokenImage, player2Tile21TokenImage, player2Tile22TokenImage, player2Tile23TokenImage, player2Tile24TokenImage, player2Tile25TokenImage, player2Tile26TokenImage, player2Tile27TokenImage, player2Tile28TokenImage, player2Tile29TokenImage, player2Tile30TokenImage, player2Tile31TokenImage, player2Tile32TokenImage, player2Tile33TokenImage, player2Tile34TokenImage, player2Tile35TokenImage, player2Tile36TokenImage, player2Tile37TokenImage, player2Tile38TokenImage, player2Tile39TokenImage;
//    @FXML
//    ImageView player3Tile0TokenImage, player3Tile1TokenImage, player3Tile2TokenImage, player3Tile3TokenImage, player3Tile4TokenImage, player3Tile5TokenImage, player3Tile6TokenImage, player3Tile7TokenImage, player3Tile8TokenImage, player3Tile9TokenImage, player3Tile10TokenImage, player3Tile11TokenImage, player3Tile12TokenImage, player3Tile13TokenImage, player3Tile14TokenImage, player3Tile15TokenImage, player3Tile16TokenImage, player3Tile17TokenImage, player3Tile18TokenImage, player3Tile19TokenImage, player3Tile20TokenImage, player3Tile21TokenImage, player3Tile22TokenImage, player3Tile23TokenImage, player3Tile24TokenImage, player3Tile25TokenImage, player3Tile26TokenImage, player3Tile27TokenImage, player3Tile28TokenImage, player3Tile29TokenImage, player3Tile30TokenImage, player3Tile31TokenImage, player3Tile32TokenImage, player3Tile33TokenImage, player3Tile34TokenImage, player3Tile35TokenImage, player3Tile36TokenImage, player3Tile37TokenImage, player3Tile38TokenImage, player3Tile39TokenImage;
//    @FXML
//    ImageView player4Tile0TokenImage, player4Tile1TokenImage, player4Tile2TokenImage, player4Tile3TokenImage, player4Tile4TokenImage, player4Tile5TokenImage, player4Tile6TokenImage, player4Tile7TokenImage, player4Tile8TokenImage, player4Tile9TokenImage, player4Tile10TokenImage, player4Tile11TokenImage, player4Tile12TokenImage, player4Tile13TokenImage, player4Tile14TokenImage, player4Tile15TokenImage, player4Tile16TokenImage, player4Tile17TokenImage, player4Tile18TokenImage, player4Tile19TokenImage, player4Tile20TokenImage, player4Tile21TokenImage, player4Tile22TokenImage, player4Tile23TokenImage, player4Tile24TokenImage, player4Tile25TokenImage, player4Tile26TokenImage, player4Tile27TokenImage, player4Tile28TokenImage, player4Tile29TokenImage, player4Tile30TokenImage, player4Tile31TokenImage, player4Tile32TokenImage, player4Tile33TokenImage, player4Tile34TokenImage, player4Tile35TokenImage, player4Tile36TokenImage, player4Tile37TokenImage, player4Tile38TokenImage, player4Tile39TokenImage;
//    @FXML
//    ImageView player5Tile0TokenImage, player5Tile1TokenImage, player5Tile2TokenImage, player5Tile3TokenImage, player5Tile4TokenImage, player5Tile5TokenImage, player5Tile6TokenImage, player5Tile7TokenImage, player5Tile8TokenImage, player5Tile9TokenImage, player5Tile10TokenImage, player5Tile11TokenImage, player5Tile12TokenImage, player5Tile13TokenImage, player5Tile14TokenImage, player5Tile15TokenImage, player5Tile16TokenImage, player5Tile17TokenImage, player5Tile18TokenImage, player5Tile19TokenImage, player5Tile20TokenImage, player5Tile21TokenImage, player5Tile22TokenImage, player5Tile23TokenImage, player5Tile24TokenImage, player5Tile25TokenImage, player5Tile26TokenImage, player5Tile27TokenImage, player5Tile28TokenImage, player5Tile29TokenImage, player5Tile30TokenImage, player5Tile31TokenImage, player5Tile32TokenImage, player5Tile33TokenImage, player5Tile34TokenImage, player5Tile35TokenImage, player5Tile36TokenImage, player5Tile37TokenImage, player5Tile38TokenImage, player5Tile39TokenImage;
//    @FXML
//    ImageView player6Tile0TokenImage, player6Tile1TokenImage, player6Tile2TokenImage, player6Tile3TokenImage, player6Tile4TokenImage, player6Tile5TokenImage, player6Tile6TokenImage, player6Tile7TokenImage, player6Tile8TokenImage, player6Tile9TokenImage, player6Tile10TokenImage, player6Tile11TokenImage, player6Tile12TokenImage, player6Tile13TokenImage, player6Tile14TokenImage, player6Tile15TokenImage, player6Tile16TokenImage, player6Tile17TokenImage, player6Tile18TokenImage, player6Tile19TokenImage, player6Tile20TokenImage, player6Tile21TokenImage, player6Tile22TokenImage, player6Tile23TokenImage, player6Tile24TokenImage, player6Tile25TokenImage, player6Tile26TokenImage, player6Tile27TokenImage, player6Tile28TokenImage, player6Tile29TokenImage, player6Tile30TokenImage, player6Tile31TokenImage, player6Tile32TokenImage, player6Tile33TokenImage, player6Tile34TokenImage, player6Tile35TokenImage, player6Tile36TokenImage, player6Tile37TokenImage, player6Tile38TokenImage, player6Tile39TokenImage;
    @FXML
    ImageView player1Tile0TokenImage;
    @FXML
    ImageView player1Tile1TokenImage;
    @FXML
    ImageView player1Tile2TokenImage;
    @FXML
    ImageView player1Tile3TokenImage;
    @FXML
    ImageView player1Tile4TokenImage;
    @FXML
    ImageView player1Tile5TokenImage;
    @FXML
    ImageView player1Tile6TokenImage;
    @FXML
    ImageView player1Tile7TokenImage;
    @FXML
    ImageView player1Tile8TokenImage;
    @FXML
    ImageView player1Tile9TokenImage;
    @FXML
    ImageView player1Tile10TokenImage;
    @FXML
    ImageView player1Tile11TokenImage;
    @FXML
    ImageView player1Tile12TokenImage;
    @FXML
    ImageView player1Tile13TokenImage;
    @FXML
    ImageView player1Tile14TokenImage;
    @FXML
    ImageView player1Tile15TokenImage;
    @FXML
    ImageView player1Tile16TokenImage;
    @FXML
    ImageView player1Tile17TokenImage;
    @FXML
    ImageView player1Tile18TokenImage;
    @FXML
    ImageView player1Tile19TokenImage;
    @FXML
    ImageView player1Tile20TokenImage;
    @FXML
    ImageView player1Tile21TokenImage;
    @FXML
    ImageView player1Tile22TokenImage;
    @FXML
    ImageView player1Tile23TokenImage;
    @FXML
    ImageView player1Tile24TokenImage;
    @FXML
    ImageView player1Tile25TokenImage;
    @FXML
    ImageView player1Tile26TokenImage;
    @FXML
    ImageView player1Tile27TokenImage;
    @FXML
    ImageView player1Tile28TokenImage;
    @FXML
    ImageView player1Tile29TokenImage;
    @FXML
    ImageView player1Tile30TokenImage;
    @FXML
    ImageView player1Tile31TokenImage;
    @FXML
    ImageView player1Tile32TokenImage;
    @FXML
    ImageView player1Tile33TokenImage;
    @FXML
    ImageView player1Tile34TokenImage;
    @FXML
    ImageView player1Tile35TokenImage;
    @FXML
    ImageView player1Tile36TokenImage;
    @FXML
    ImageView player1Tile37TokenImage;
    @FXML
    ImageView player1Tile38TokenImage;
    @FXML
    ImageView player1Tile39TokenImage;

    @FXML
    ImageView player2Tile0TokenImage;
    @FXML
    ImageView player2Tile1TokenImage;
    @FXML
    ImageView player2Tile2TokenImage;
    @FXML
    ImageView player2Tile3TokenImage;
    @FXML
    ImageView player2Tile4TokenImage;
    @FXML
    ImageView player2Tile5TokenImage;
    @FXML
    ImageView player2Tile6TokenImage;
    @FXML
    ImageView player2Tile7TokenImage;
    @FXML
    ImageView player2Tile8TokenImage;
    @FXML
    ImageView player2Tile9TokenImage;
    @FXML
    ImageView player2Tile10TokenImage;
    @FXML
    ImageView player2Tile11TokenImage;
    @FXML
    ImageView player2Tile12TokenImage;
    @FXML
    ImageView player2Tile13TokenImage;
    @FXML
    ImageView player2Tile14TokenImage;
    @FXML
    ImageView player2Tile15TokenImage;
    @FXML
    ImageView player2Tile16TokenImage;
    @FXML
    ImageView player2Tile17TokenImage;
    @FXML
    ImageView player2Tile18TokenImage;
    @FXML
    ImageView player2Tile19TokenImage;
    @FXML
    ImageView player2Tile20TokenImage;
    @FXML
    ImageView player2Tile21TokenImage;
    @FXML
    ImageView player2Tile22TokenImage;
    @FXML
    ImageView player2Tile23TokenImage;
    @FXML
    ImageView player2Tile24TokenImage;
    @FXML
    ImageView player2Tile25TokenImage;
    @FXML
    ImageView player2Tile26TokenImage;
    @FXML
    ImageView player2Tile27TokenImage;
    @FXML
    ImageView player2Tile28TokenImage;
    @FXML
    ImageView player2Tile29TokenImage;
    @FXML
    ImageView player2Tile30TokenImage;
    @FXML
    ImageView player2Tile31TokenImage;
    @FXML
    ImageView player2Tile32TokenImage;
    @FXML
    ImageView player2Tile33TokenImage;
    @FXML
    ImageView player2Tile34TokenImage;
    @FXML
    ImageView player2Tile35TokenImage;
    @FXML
    ImageView player2Tile36TokenImage;
    @FXML
    ImageView player2Tile37TokenImage;
    @FXML
    ImageView player2Tile38TokenImage;
    @FXML
    ImageView player2Tile39TokenImage;

    @FXML
    ImageView player3Tile0TokenImage;
    @FXML
    ImageView player3Tile1TokenImage;
    @FXML
    ImageView player3Tile2TokenImage;
    @FXML
    ImageView player3Tile3TokenImage;
    @FXML
    ImageView player3Tile4TokenImage;
    @FXML
    ImageView player3Tile5TokenImage;
    @FXML
    ImageView player3Tile6TokenImage;
    @FXML
    ImageView player3Tile7TokenImage;
    @FXML
    ImageView player3Tile8TokenImage;
    @FXML
    ImageView player3Tile9TokenImage;
    @FXML
    ImageView player3Tile10TokenImage;
    @FXML
    ImageView player3Tile11TokenImage;
    @FXML
    ImageView player3Tile12TokenImage;
    @FXML
    ImageView player3Tile13TokenImage;
    @FXML
    ImageView player3Tile14TokenImage;
    @FXML
    ImageView player3Tile15TokenImage;
    @FXML
    ImageView player3Tile16TokenImage;
    @FXML
    ImageView player3Tile17TokenImage;
    @FXML
    ImageView player3Tile18TokenImage;
    @FXML
    ImageView player3Tile19TokenImage;
    @FXML
    ImageView player3Tile20TokenImage;
    @FXML
    ImageView player3Tile21TokenImage;
    @FXML
    ImageView player3Tile22TokenImage;
    @FXML
    ImageView player3Tile23TokenImage;
    @FXML
    ImageView player3Tile24TokenImage;
    @FXML
    ImageView player3Tile25TokenImage;
    @FXML
    ImageView player3Tile26TokenImage;
    @FXML
    ImageView player3Tile27TokenImage;
    @FXML
    ImageView player3Tile28TokenImage;
    @FXML
    ImageView player3Tile29TokenImage;
    @FXML
    ImageView player3Tile30TokenImage;
    @FXML
    ImageView player3Tile31TokenImage;
    @FXML
    ImageView player3Tile32TokenImage;
    @FXML
    ImageView player3Tile33TokenImage;
    @FXML
    ImageView player3Tile34TokenImage;
    @FXML
    ImageView player3Tile35TokenImage;
    @FXML
    ImageView player3Tile36TokenImage;
    @FXML
    ImageView player3Tile37TokenImage;
    @FXML
    ImageView player3Tile38TokenImage;
    @FXML
    ImageView player3Tile39TokenImage;

    @FXML
    ImageView player4Tile0TokenImage;
    @FXML
    ImageView player4Tile1TokenImage;
    @FXML
    ImageView player4Tile2TokenImage;
    @FXML
    ImageView player4Tile3TokenImage;
    @FXML
    ImageView player4Tile4TokenImage;
    @FXML
    ImageView player4Tile5TokenImage;
    @FXML
    ImageView player4Tile6TokenImage;
    @FXML
    ImageView player4Tile7TokenImage;
    @FXML
    ImageView player4Tile8TokenImage;
    @FXML
    ImageView player4Tile9TokenImage;
    @FXML
    ImageView player4Tile10TokenImage;
    @FXML
    ImageView player4Tile11TokenImage;
    @FXML
    ImageView player4Tile12TokenImage;
    @FXML
    ImageView player4Tile13TokenImage;
    @FXML
    ImageView player4Tile14TokenImage;
    @FXML
    ImageView player4Tile15TokenImage;
    @FXML
    ImageView player4Tile16TokenImage;
    @FXML
    ImageView player4Tile17TokenImage;
    @FXML
    ImageView player4Tile18TokenImage;
    @FXML
    ImageView player4Tile19TokenImage;
    @FXML
    ImageView player4Tile20TokenImage;
    @FXML
    ImageView player4Tile21TokenImage;
    @FXML
    ImageView player4Tile22TokenImage;
    @FXML
    ImageView player4Tile23TokenImage;
    @FXML
    ImageView player4Tile24TokenImage;
    @FXML
    ImageView player4Tile25TokenImage;
    @FXML
    ImageView player4Tile26TokenImage;
    @FXML
    ImageView player4Tile27TokenImage;
    @FXML
    ImageView player4Tile28TokenImage;
    @FXML
    ImageView player4Tile29TokenImage;
    @FXML
    ImageView player4Tile30TokenImage;
    @FXML
    ImageView player4Tile31TokenImage;
    @FXML
    ImageView player4Tile32TokenImage;
    @FXML
    ImageView player4Tile33TokenImage;
    @FXML
    ImageView player4Tile34TokenImage;
    @FXML
    ImageView player4Tile35TokenImage;
    @FXML
    ImageView player4Tile36TokenImage;
    @FXML
    ImageView player4Tile37TokenImage;
    @FXML
    ImageView player4Tile38TokenImage;
    @FXML
    ImageView player4Tile39TokenImage;

    @FXML
    ImageView player5Tile0TokenImage;
    @FXML
    ImageView player5Tile1TokenImage;
    @FXML
    ImageView player5Tile2TokenImage;
    @FXML
    ImageView player5Tile3TokenImage;
    @FXML
    ImageView player5Tile4TokenImage;
    @FXML
    ImageView player5Tile5TokenImage;
    @FXML
    ImageView player5Tile6TokenImage;
    @FXML
    ImageView player5Tile7TokenImage;
    @FXML
    ImageView player5Tile8TokenImage;
    @FXML
    ImageView player5Tile9TokenImage;
    @FXML
    ImageView player5Tile10TokenImage;
    @FXML
    ImageView player5Tile11TokenImage;
    @FXML
    ImageView player5Tile12TokenImage;
    @FXML
    ImageView player5Tile13TokenImage;
    @FXML
    ImageView player5Tile14TokenImage;
    @FXML
    ImageView player5Tile15TokenImage;
    @FXML
    ImageView player5Tile16TokenImage;
    @FXML
    ImageView player5Tile17TokenImage;
    @FXML
    ImageView player5Tile18TokenImage;
    @FXML
    ImageView player5Tile19TokenImage;
    @FXML
    ImageView player5Tile20TokenImage;
    @FXML
    ImageView player5Tile21TokenImage;
    @FXML
    ImageView player5Tile22TokenImage;
    @FXML
    ImageView player5Tile23TokenImage;
    @FXML
    ImageView player5Tile24TokenImage;
    @FXML
    ImageView player5Tile25TokenImage;
    @FXML
    ImageView player5Tile26TokenImage;
    @FXML
    ImageView player5Tile27TokenImage;
    @FXML
    ImageView player5Tile28TokenImage;
    @FXML
    ImageView player5Tile29TokenImage;
    @FXML
    ImageView player5Tile30TokenImage;
    @FXML
    ImageView player5Tile31TokenImage;
    @FXML
    ImageView player5Tile32TokenImage;
    @FXML
    ImageView player5Tile33TokenImage;
    @FXML
    ImageView player5Tile34TokenImage;
    @FXML
    ImageView player5Tile35TokenImage;
    @FXML
    ImageView player5Tile36TokenImage;
    @FXML
    ImageView player5Tile37TokenImage;
    @FXML
    ImageView player5Tile38TokenImage;
    @FXML
    ImageView player5Tile39TokenImage;

    @FXML
    ImageView player6Tile0TokenImage;
    @FXML
    ImageView player6Tile1TokenImage;
    @FXML
    ImageView player6Tile2TokenImage;
    @FXML
    ImageView player6Tile3TokenImage;
    @FXML
    ImageView player6Tile4TokenImage;
    @FXML
    ImageView player6Tile5TokenImage;
    @FXML
    ImageView player6Tile6TokenImage;
    @FXML
    ImageView player6Tile7TokenImage;
    @FXML
    ImageView player6Tile8TokenImage;
    @FXML
    ImageView player6Tile9TokenImage;
    @FXML
    ImageView player6Tile10TokenImage;
    @FXML
    ImageView player6Tile11TokenImage;
    @FXML
    ImageView player6Tile12TokenImage;
    @FXML
    ImageView player6Tile13TokenImage;
    @FXML
    ImageView player6Tile14TokenImage;
    @FXML
    ImageView player6Tile15TokenImage;
    @FXML
    ImageView player6Tile16TokenImage;
    @FXML
    ImageView player6Tile17TokenImage;
    @FXML
    ImageView player6Tile18TokenImage;
    @FXML
    ImageView player6Tile19TokenImage;
    @FXML
    ImageView player6Tile20TokenImage;
    @FXML
    ImageView player6Tile21TokenImage;
    @FXML
    ImageView player6Tile22TokenImage;
    @FXML
    ImageView player6Tile23TokenImage;
    @FXML
    ImageView player6Tile24TokenImage;
    @FXML
    ImageView player6Tile25TokenImage;
    @FXML
    ImageView player6Tile26TokenImage;
    @FXML
    ImageView player6Tile27TokenImage;
    @FXML
    ImageView player6Tile28TokenImage;
    @FXML
    ImageView player6Tile29TokenImage;
    @FXML
    ImageView player6Tile30TokenImage;
    @FXML
    ImageView player6Tile31TokenImage;
    @FXML
    ImageView player6Tile32TokenImage;
    @FXML
    ImageView player6Tile33TokenImage;
    @FXML
    ImageView player6Tile34TokenImage;
    @FXML
    ImageView player6Tile35TokenImage;
    @FXML
    ImageView player6Tile36TokenImage;
    @FXML
    ImageView player6Tile37TokenImage;
    @FXML
    ImageView player6Tile38TokenImage;
    @FXML
    ImageView player6Tile39TokenImage;


    /*
        Player Cards
         */

    @FXML
    private Button button1, button2, button3, button4;
    @FXML
    private AnchorPane player1Card, player2Card, player3Card, player4Card, player5Card, player6Card;

    /*
    Player Name Labels
     */
    @FXML
    private Label p1NameLabel, p2NameLabel, p3NameLabel, p4NameLabel, p5NameLabel, p6NameLabel;

    /*
    Players' money amount labels
     */

    @FXML
    private Label p1moneyLabel, p2moneyLabel, p3moneyLabel, p4moneyLabel, p5moneyLabel, p6moneyLabel;

    /*
    Players' number of property labels
     */

    @FXML
    private Label p1NumOfPropLabel, p2NumOfPropLabel, p3NumOfPropLabel, p4NumOfPropLabel, p5NumOfPropLabel, p6NumOfPropLabel;

    /*
    Players' see properties buttons
     */

    @FXML
    private Button p1SeePropertiesButton, p2SeePropertiesButton, p3SeePropertiesButton, p4SeePropertiesButton, p5SeePropertiesButton, p6SeePropertiesButton;

    /*
    Players' trade buttons
     */
    @FXML
    private Button p1TradeButton, p2TradeButton, p3TradeButton, p4TradeButton, p5TradeButton, p6TradeButton;

    /*
    Player's token labels
     */

    @FXML
    private Label p1TokenLabel, p2TokenLabel, p3TokenLabel, p4TakenLabel, p5TokenLabel, p6TokenLabel;

    /*
    Players' token images
     */

    @FXML
    private ImageView p1TokenImage, p2TokenImage, p3TokenImage, p4TokenImage, p5TokenImage, p6TokenImage;

    @FXML
    private Pane propertyColorPane;

    @FXML
    private Label rentSiteOnlyValueLabel, rentWith1HouseValueLabel, rentWith2HousesValueLabel;

    @FXML
    private Label rentWith3HousesValueLabel, rentWith4HousesValueLabel, rentWithHotelValueLabel;

    // TitleDeedCardLabels.
    @FXML
    private Label propertyNameLabel, costOfHousesValueLabel, costOfHotelsValueLabel, mortgageValueLabel, costLabel;

    @FXML
    private AnchorPane titleDeedCard;

    @FXML
    private Label communityOrChanceCardLabel, cardAction;
    @FXML
    private AnchorPane titleDeedCard1;

    /*
    Game Buttons
     */


    @FXML
    private Button menuButton, rollDiceButton, endTurnButton;

    @FXML
    private ImageView goTileImage;

    @FXML
    private Label brownLabel1, brownPrice1, brownLabel2, brownPrice2;

    @FXML
    private Label lightBlueLabel1, lightBluePrice1, lightBlueLabel2, lightBluePrice2, lightBlueLabel3, lightBluePrice3;

    @FXML
    private Label pinkLabel1, pinkPrice1, pinkLabel2, pinkPrice2, pinkLabel3, pinkPrice3;

    @FXML
    private Label orangeLabel1, orangePrice1, orangeLabel2, orangePrice2, orangeLabel3, orangePrice3;

    @FXML
    private Label redLabel1, redPrice1, redLabel2, redPrice2, redLabel3, redPrice3;

    @FXML
    private Label yellowLabel1, yellowPrice1, yellowLabel2, yellowPrice2, yellowLabel3, yellowPrice3;

    @FXML
    private Label greenLabel1, greenPrice1, greenLabel2, greenPrice2, greenLabel3, greenPrice3;

    @FXML
    private Label blueLabel1, bluePrice1, blueLabel2, bluePrice2;

    @FXML
    private GameSession gameSession;

    public GameSession getGameSession() {
        return gameSession;
    }

    public void setGameSession(GameSession gameSession) {

        this.gameSession = gameSession;
//        System.out.println(gameSession);
//        System.out.println(getGameSession());
    }
}
