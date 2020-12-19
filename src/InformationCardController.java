import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import java.net.URL;
import java.util.ResourceBundle;

public class InformationCardController implements Initializable {


    @FXML
    public Label informationLabel;

    @FXML
    public ScrollPane informationCardScrollPane;

    @FXML
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;

    public void handleButton1() {}

    public void handleButton2() {}

    public void handleButton3() {}

    public void handleButton4() {}

    public void handleButton5() {}

    public void handleButton6() {}


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        informationLabel.setText("The main objective of the game is obtaining wealth by selling and buying properties, and being the only player standing by forcing other players to declare bankruptcy. \n\n" +
                "The game is played with 2 to 6 players. For multiplayer, every player will be playing the game on the same computer in turns. Players will be able to choose the board they will be playing the game on, and this includes user created custom boards as well. \n\n" +
                "Every turn players will roll the dice, and move their pieces according to the sum of the dice. After rolling dice and moving accordingly, players will perform the task related to the tile they landed on, such as drawing a chance card or a community chest card, or buying the property they landed on (If the player lands on an unowned property and is not willing to buy that property, auction takes place in that turn.) Players may propose trade offers to other players during their turn. After that, by selecting “End Turn”,  the turn for that player will be over, and the game will continue with the next player. If a player rolls a double dice in their turn, after playing that round they will roll again. However, throwing double dice three turns in a row results in jail. \n\n" +
                "Every turn players will roll the dice, and move their pieces according to the sum of the dice. After rolling dice and moving accordingly, players will perform the task related to the tile they landed on, such as drawing a chance card or a community chest card, or buying the property they landed on (If the player lands on an unowned property and is not willing to buy that property, auction takes place in that turn.) Players may propose trade offers to other players during their turn. After that, by selecting “End Turn”,  the turn for that player will be over, and the game will continue with the next player. If a player rolls a double dice in their turn, after playing that round they will roll again. However, throwing double dice three turns in a row results in jail. \n\n" +
                "Every turn players will roll the dice, and move their pieces according to the sum of the dice. After rolling dice and moving accordingly, players will perform the task related to the tile they landed on, such as drawing a chance card or a community chest card, or buying the property they landed on (If the player lands on an unowned property and is not willing to buy that property, auction takes place in that turn.) Players may propose trade offers to other players during their turn. After that, by selecting “End Turn”,  the turn for that player will be over, and the game will continue with the next player. If a player rolls a double dice in their turn, after playing that round they will roll again. However, throwing double dice three turns in a row results in jail. \n\n" +
                "Every turn players will roll the dice, and move their pieces according to the sum of the dice. After rolling dice and moving accordingly, players will perform the task related to the tile they landed on, such as drawing a chance card or a community chest card, or buying the property they landed on (If the player lands on an unowned property and is not willing to buy that property, auction takes place in that turn.) Players may propose trade offers to other players during their turn. After that, by selecting “End Turn”,  the turn for that player will be over, and the game will continue with the next player. If a player rolls a double dice in their turn, after playing that round they will roll again. However, throwing double dice three turns in a row results in jail. \n\n" +
                "Every turn players will roll the dice, and move their pieces according to the sum of the dice. After rolling dice and moving accordingly, players will perform the task related to the tile they landed on, such as drawing a chance card or a community chest card, or buying the property they landed on (If the player lands on an unowned property and is not willing to buy that property, auction takes place in that turn.) Players may propose trade offers to other players during their turn. After that, by selecting “End Turn”,  the turn for that player will be over, and the game will continue with the next player. If a player rolls a double dice in their turn, after playing that round they will roll again. However, throwing double dice three turns in a row results in jail. \n\n" +
                "Every turn players will roll the dice, and move their pieces according to the sum of the dice. After rolling dice and moving accordingly, players will perform the task related to the tile they landed on, such as drawing a chance card or a community chest card, or buying the property they landed on (If the player lands on an unowned property and is not willing to buy that property, auction takes place in that turn.) Players may propose trade offers to other players during their turn. After that, by selecting “End Turn”,  the turn for that player will be over, and the game will continue with the next player. If a player rolls a double dice in their turn, after playing that round they will roll again. However, throwing double dice three turns in a row results in jail. \n\n" +
                "Every turn players will roll the dice, and move their pieces according to the sum of the dice. After rolling dice and moving accordingly, players will perform the task related to the tile they landed on, such as drawing a chance card or a community chest card, or buying the property they landed on (If the player lands on an unowned property and is not willing to buy that property, auction takes place in that turn.) Players may propose trade offers to other players during their turn. After that, by selecting “End Turn”,  the turn for that player will be over, and the game will continue with the next player. If a player rolls a double dice in their turn, after playing that round they will roll again. However, throwing double dice three turns in a row results in jail. \n\n" );

        informationCardScrollPane.setContent(informationLabel);
        informationLabel.setStyle("-fx-text-fill: #000000");
    }
}
