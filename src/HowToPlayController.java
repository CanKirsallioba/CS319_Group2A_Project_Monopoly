import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HowToPlayController implements Initializable {

    @FXML
    public Label howToPlayLabel;

    @FXML
    public ScrollPane howToPlayScrollPane;

    @FXML
    public ImageView backIcon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        howToPlayLabel.setWrapText(true);

        howToPlayLabel.setText("The main objective of the game is obtaining wealth by selling and buying properties, and being the only player standing by forcing other players to declare bankruptcy. \n\n" +
                "The game can be played with 2 to 6 players. For multiplayer game, every player will be playing the game on the same computer in turns. Players will be able to choose the board they will be playing the game on, and this includes user created custom boards as well. \n\n" +
                "Every turn, the players' dice and their tokens are moved automatically. For each tile they land, they will decide what to do. For instance, if they land on a property tile, they can select to buy the property by clicking buy property button, " +
                "they can start an auction by clicking start auction button. If an auction starts, every player can increase the offered money by clicking the button of the corresponding player. The player who clicked the button lastly will be the owner of the property " +
                "and their money will decrease." +
                "If you land on a chance card tile or a community chest card tile, you will apply the instruction in the card. The instruction is written in the card that is located on the center right of the board.\n" +
                "If you land on a Income-Tax tile, you will pay the tax according to your choice. You can pay the predefined amount that is written at the bottom of that tile, or 10% of your money. " +
                "If you land on a property that is owned by another player, you must pay the rent. If there is not enough money for you to pay, you should sell a property until you have enough money to pay the rent, or declare bankruptcy and leave the game. " + "\n\n" +
                "You can see the properties of every player by clicking see properties of that player, and you can start a trade with that player by clicking the trade button on their cards.\n\n" +
                "The Board Builder screen provides you with the functionality of creating and designing your own board. You can change the names, prices, rent prices, etc of the property tiles " +
                "by clicking that property. You can set a name to the board and change the salary that every player gets when they pass the go tile. After clicking the property you want to change, " +
                "the popup that is opened will direct you clearly." +
                "\n\nYou can save your game while playing by clicking the menu button at the top left corner of the screen and save game button. Whenever you load the saved game, you will have the opportunity to continue your game where you left off. ");
        howToPlayScrollPane.setContent(howToPlayLabel);
        howToPlayLabel.setStyle("-fx-text-fill: #000000");

        backIcon.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Parent tableViewParent = null;
                try {
                    tableViewParent = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                assert tableViewParent != null;
                Scene tableViewScene = new Scene(tableViewParent);

                // Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);

                Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
                window.setX((screenBounds.getWidth() - window.getWidth()) / 2);
                window.setY((screenBounds.getHeight() - window.getHeight()) / 2);

                window.show();
            }
        });
    }
}
