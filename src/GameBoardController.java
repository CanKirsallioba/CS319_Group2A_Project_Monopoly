import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        p1NameLabel.getStylesheets().add(this.getClass().getResource("GameBoardStyle.css").toExternalForm());
        p1NameLabel.getStyleClass().add("label");
    }


}
