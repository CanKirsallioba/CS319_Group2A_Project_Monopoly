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
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class GameBoardController implements Initializable {

    public AnchorPane gameBoard;

    /*
        Player Cards
         */
    @FXML
    private AnchorPane player1Card;

    @FXML
    private AnchorPane player2Card;

    @FXML
    private AnchorPane player3Card;

    @FXML
    private AnchorPane player4Card;

    @FXML
    private AnchorPane player5Card;

    @FXML
    private AnchorPane player6Card;

    /*
    Player Name Labels
     */
    @FXML
    private Label p1NameLabel;

    @FXML
    private Label p2NameLabel;

    @FXML
    private Label p3NameLabel;

    @FXML
    private Label p4NameLabel;

    @FXML
    private Label p5NameLabel;

    @FXML
    private Label p6NameLabel;

    /*
    Players' money amount labels
     */

    @FXML
    private Label p1moneyLabel;

    @FXML
    private Label p2moneyLabel;

    @FXML
    private Label p3moneyLabel;

    @FXML
    private Label p4moneyLabel;

    @FXML
    private Label p5moneyLabel;

    @FXML
    private Label p6moneyLabel;

    /*
    Players' number of property labels
     */

    @FXML
    private Label p1NumOfPropLabel;

    @FXML
    private Label p2NumOfPropLabel;

    @FXML
    private Label p3NumOfPropLabel;

    @FXML
    private Label p4NumOfPropLabel;

    @FXML
    private Label p5NumOfPropLabel;

    @FXML
    private Label p6NumOfPropLabel;

    /*
    Players' see properties buttons
     */

    @FXML
    private Button p1SeePropertiesButton;

    @FXML
    private Button p2SeePropertiesButton;

    @FXML
    private Button p3SeePropertiesButton;

    @FXML
    private Button p4SeePropertiesButton;

    @FXML
    private Button p5SeePropertiesButton;

    @FXML
    private Button p6SeePropertiesButton;

    /*
    Players' trade buttons
     */
    @FXML
    private Button p1TradeButton;

    @FXML
    private Button p2TradeButton;

    @FXML
    private Button p3TradeButton;

    @FXML
    private Button p4TradeButton;

    @FXML
    private Button p5TradeButton;

    @FXML
    private Button p6TradeButton;

    /*
    Player's token labels
     */

    @FXML
    private Label p1TokenLabel;

    @FXML
    private Label p2TokenLabel;

    @FXML
    private Label p3TokenLabel;

    @FXML
    private Label p4TokenLabel;

    @FXML
    private Label p5TokenLabel;

    @FXML
    private Label p6TokenLabel;


    /*
    Players' token images
     */

    @FXML
    private ImageView p1TokenImage;

    @FXML
    private ImageView p2TokenImage;

    @FXML
    private ImageView p3TokenImage;

    @FXML
    private ImageView p4TokenImage;

    @FXML
    private ImageView p5TokenImage;

    @FXML
    private ImageView p6TokenImage;

    /*
    Game Buttons
     */

    @FXML
    private Button menuButton;

    @FXML
    private Button rollDiceButton;

    @FXML
    private Button endTurnButton;

    @FXML
    private ImageView goTileImage;

    @FXML
    private Label brownLabel1;
    @FXML
    private Label brownPrice1;

    @FXML
    private Label brownLabel2;
    @FXML
    private Label brownPrice2;

    @FXML
    private Label lightBlueLabel1;
    @FXML
    private Label lightBluePrice1;
    @FXML
    private Label lightBlueLabel2;
    @FXML
    private Label lightBluePrice2;
    @FXML
    private Label lightBlueLabel3;
    @FXML
    private Label lightBluePrice3;


    @FXML
    private Label pinkLabel1;
    @FXML
    private Label pinkPrice1;
    @FXML
    private Label pinkLabel2;
    @FXML
    private Label pinkPrice2;
    @FXML
    private Label pinkLabel3;
    @FXML
    private Label pinkPrice3;


    @FXML
    private Label orangeLabel1;
    @FXML
    private Label orangePrice1;
    @FXML
    private Label orangeLabel2;
    @FXML
    private Label orangePrice2;
    @FXML
    private Label orangeLabel3;
    @FXML
    private Label orangePrice3;

    @FXML
    private Label redLabel1;
    @FXML
    private Label redPrice1;
    @FXML
    private Label redLabel2;
    @FXML
    private Label redPrice2;
    @FXML
    private Label redLabel3;
    @FXML
    private Label redPrice3;


    @FXML
    private Label yellowLabel1;
    @FXML
    private Label yellowPrice1;
    @FXML
    private Label yellowLabel2;
    @FXML
    private Label yellowPrice2;
    @FXML
    private Label yellowLabel3;
    @FXML
    private Label yellowPrice3;


    @FXML
    private Label greenLabel1;
    @FXML
    private Label greenPrice1;
    @FXML
    private Label greenLabel2;
    @FXML
    private Label greenPrice2;
    @FXML
    private Label greenLabel3;
    @FXML
    private Label greenPrice3;


    @FXML
    private Label blueLabel1;
    @FXML
    private Label bluePrice1;
    @FXML
    private Label blueLabel2;
    @FXML
    private Label bluePrice2;

    @FXML
    public void handleMenuButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameBoardMenu.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Menu");
        stage.setScene(new Scene(root1));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.centerOnScreen();
        stage.show();
    }

    public void exit() {
        Stage stage = (Stage) yellowPrice1.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void handleEndTurnButton() {}


    @FXML
    public void handleButton1() {}

    @FXML
    public void handleButton2() {}

    @FXML
    public void handleButton3() {}

    @FXML
    public void handleButton4() {}


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        yellowPrice1.setText("100");
    }


}
