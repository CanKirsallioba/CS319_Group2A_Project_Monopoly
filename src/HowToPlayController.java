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

        File file = new File("back.png");
        Image image = new Image(file.toURI().toString());
        backIcon.setImage(image);
        howToPlayLabel.setWrapText(true);

        howToPlayLabel.setText("The main objective of the game is obtaining wealth by selling and buying properties, and being the only player standing by forcing other players to declare bankruptcy. \n\n" +
                "The game is played with 2 to 6 players. For multiplayer, every player will be playing the game on the same computer in turns. Players will be able to choose the board they will be playing the game on, and this includes user created custom boards as well. \n\n" +
                "Every turn players will roll the dice, and move their pieces according to the sum of the dice. After rolling dice and moving accordingly, players will perform the task related to the tile they landed on, such as drawing a chance card or a community chest card, or buying the property they landed on (If the player lands on an unowned property and is not willing to buy that property, auction takes place in that turn.) Players may propose trade offers to other players during their turn. After that, by selecting “End Turn”,  the turn for that player will be over, and the game will continue with the next player. If a player rolls a double dice in their turn, after playing that round they will roll again. However, throwing double dice three turns in a row results in jail. \n\n" +
                "Every turn players will roll the dice, and move their pieces according to the sum of the dice. After rolling dice and moving accordingly, players will perform the task related to the tile they landed on, such as drawing a chance card or a community chest card, or buying the property they landed on (If the player lands on an unowned property and is not willing to buy that property, auction takes place in that turn.) Players may propose trade offers to other players during their turn. After that, by selecting “End Turn”,  the turn for that player will be over, and the game will continue with the next player. If a player rolls a double dice in their turn, after playing that round they will roll again. However, throwing double dice three turns in a row results in jail. \n\n" +
                "Every turn players will roll the dice, and move their pieces according to the sum of the dice. After rolling dice and moving accordingly, players will perform the task related to the tile they landed on, such as drawing a chance card or a community chest card, or buying the property they landed on (If the player lands on an unowned property and is not willing to buy that property, auction takes place in that turn.) Players may propose trade offers to other players during their turn. After that, by selecting “End Turn”,  the turn for that player will be over, and the game will continue with the next player. If a player rolls a double dice in their turn, after playing that round they will roll again. However, throwing double dice three turns in a row results in jail. \n\n" +
                "Every turn players will roll the dice, and move their pieces according to the sum of the dice. After rolling dice and moving accordingly, players will perform the task related to the tile they landed on, such as drawing a chance card or a community chest card, or buying the property they landed on (If the player lands on an unowned property and is not willing to buy that property, auction takes place in that turn.) Players may propose trade offers to other players during their turn. After that, by selecting “End Turn”,  the turn for that player will be over, and the game will continue with the next player. If a player rolls a double dice in their turn, after playing that round they will roll again. However, throwing double dice three turns in a row results in jail. \n\n" +
                "Every turn players will roll the dice, and move their pieces according to the sum of the dice. After rolling dice and moving accordingly, players will perform the task related to the tile they landed on, such as drawing a chance card or a community chest card, or buying the property they landed on (If the player lands on an unowned property and is not willing to buy that property, auction takes place in that turn.) Players may propose trade offers to other players during their turn. After that, by selecting “End Turn”,  the turn for that player will be over, and the game will continue with the next player. If a player rolls a double dice in their turn, after playing that round they will roll again. However, throwing double dice three turns in a row results in jail. \n\n" +
                "Every turn players will roll the dice, and move their pieces according to the sum of the dice. After rolling dice and moving accordingly, players will perform the task related to the tile they landed on, such as drawing a chance card or a community chest card, or buying the property they landed on (If the player lands on an unowned property and is not willing to buy that property, auction takes place in that turn.) Players may propose trade offers to other players during their turn. After that, by selecting “End Turn”,  the turn for that player will be over, and the game will continue with the next player. If a player rolls a double dice in their turn, after playing that round they will roll again. However, throwing double dice three turns in a row results in jail. \n\n" +
                "Every turn players will roll the dice, and move their pieces according to the sum of the dice. After rolling dice and moving accordingly, players will perform the task related to the tile they landed on, such as drawing a chance card or a community chest card, or buying the property they landed on (If the player lands on an unowned property and is not willing to buy that property, auction takes place in that turn.) Players may propose trade offers to other players during their turn. After that, by selecting “End Turn”,  the turn for that player will be over, and the game will continue with the next player. If a player rolls a double dice in their turn, after playing that round they will roll again. However, throwing double dice three turns in a row results in jail. \n\n" );

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
