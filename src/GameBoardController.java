import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.player.Player;
import model.session.GameSession;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class GameBoardController implements Initializable {

    public AnchorPane gameBoard;

    public void init() {
        Label[] nameLabels = {brownLabel1, brownLabel2, lightBlueLabel1, lightBlueLabel2, lightBlueLabel3,
                        pinkLabel1, pinkLabel2, pinkLabel3, orangeLabel1, orangeLabel2, orangeLabel3,
                        redLabel1, redLabel2, redLabel3, yellowLabel1, yellowLabel2, yellowLabel3,
                        greenLabel1, greenLabel2, greenLabel3, blueLabel1, blueLabel2};

        Label[] priceLabels = {brownPrice1, brownPrice2, lightBluePrice1, lightBluePrice2, lightBluePrice3,
                        pinkPrice1, pinkPrice2, pinkLabel3, orangePrice1, orangePrice2, orangePrice3,
                        redPrice1, redPrice2, redPrice3, yellowPrice1, yellowPrice2, yellowPrice3,
                        greenPrice1, greenPrice2, greenPrice3, bluePrice1, bluePrice2};




        Label[] arr = {lightBlueLabel1, lightBlueLabel2, lightBlueLabel3};
        GameActionButtonObserver gameActionButtonObserver = new GameActionButtonObserver(button1, 0);
        GameActionButtonObserver gameActionButtonObserver1 = new GameActionButtonObserver(button2, 1);
        GameActionButtonObserver gameActionButtonObserver2 = new GameActionButtonObserver(button3, 2);
        GameActionButtonObserver gameActionButtonObserver3 = new GameActionButtonObserver(button4, 3);
        ArrayList<Player> players = getGameSession().getTurnManager().getPlayers();
        System.out.println(players.size());
        for (Player player : players) {
            Observable observable = (Observable) player;
            observable.addObserver(gameActionButtonObserver);
            observable.addObserver(gameActionButtonObserver1);
            observable.addObserver(gameActionButtonObserver2);
            observable.addObserver(gameActionButtonObserver3);

        }
        getGameSession().getTurnManager().getCurrentPlayer().playTurn();


    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

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
                Player player = (Player) o;
                if (buttonNumber < player.getCurrentTile().getActions().size()) {
                    button.setVisible(true);
                    button.setText(player.getCurrentTile().getActions().get(buttonNumber).getName());
                } else {
                    button.setVisible(false);

                }
            }
        }
    }

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
        System.out.println(gameSession);
        System.out.println(getGameSession());
    }

    @FXML
    public void handleMenuButton() throws IOException {
        openPopUp("GameBoardMenu.fxml", "Menu");
    }

    @FXML
    public void handleEndTurnButton() {
        getGameSession().getTurnManager().endTurn();
        System.out.println("Player: " + getGameSession().getTurnManager().getCurrentPlayerIndex() + "\n"
                + "TileIndex: " + getGameSession().getTurnManager().getCurrentPlayer().getCurrentTile().getIndex() + "\n"
                + "Tile: " + getGameSession().getTurnManager().getCurrentPlayer().getCurrentTile().getTileName());

        System.out.println(getGameSession().getTurnManager().getCurrentPlayer().toString());
    }


    @FXML
    public void handleButton1() throws IOException {
        openAuction();
    }

    @FXML
    public void handleButton2() throws IOException {
        openTitleDeedCard();
    }

    @FXML
    public void handleButton3() {}

    @FXML
    public void handleButton4() {}

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
        openPopUp("Trade.fxml", "Trade between Player A and 1");
    }
    public void tradeWithPlayer2() throws IOException {
        openPopUp("Trade.fxml", "Trade between Player A and 2");
    }
    public void tradeWithPlayer3() throws IOException {
        openPopUp("Trade.fxml", "Trade between Player A and 3");
    }
    public void tradeWithPlayer4() throws IOException {
        openPopUp("Trade.fxml", "Trade between Player A and 4");
    }
    public void tradeWithPlayer5() throws IOException {
        openPopUp("Trade.fxml", "Trade between Player A and 5");
    }
    public void tradeWithPlayer6() throws IOException {
        openPopUp("Trade.fxml", "Trade between Player A and 6");
    }

    public void seeInformationCardPlayer1() throws IOException {
        openInformationCard("Player 1");
    }
    public void seeInformationCardPlayer2() throws IOException {
        openInformationCard("Player 2");
    }
    public void seeInformationCardPlayer3() throws IOException {
        openInformationCard("Player 3");
    }
    public void seeInformationCardPlayer4() throws IOException {
        openInformationCard("Player 4");
    }
    public void seeInformationCardPlayer5() throws IOException {
        openInformationCard("Player 5");
    }
    public void seeInformationCardPlayer6() throws IOException {
        openInformationCard("Player 6");
    }

    public void openTitleDeedCard() throws IOException {
        openPopUp("TitleDeedCardUI.fxml", "Title Deed Card");
    }
}
