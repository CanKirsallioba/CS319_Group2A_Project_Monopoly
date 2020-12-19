import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import model.player.Player;
import model.tiles.property.TitleDeedCard;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InformationCardController implements Initializable {

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
    public Label informationLabel;

    @FXML
    public ScrollPane informationCardScrollPane;

    @FXML
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;

    public void handleButton1() {}

    public void handleButton2() {}

    public void handleButton3() {}

    public void handleButton4() {}

    public void handleButton5() {}

    public void init() {
        System.out.println(player.toString());
        String informationOfPlayer = "";
        String informationOfProperty;
        int index = 1;
        ArrayList<TitleDeedCard> deedCards = player.getTitleDeeds();
        for (TitleDeedCard deedCard: deedCards){

            informationOfProperty = ("Property " + index + ": " + deedCard.getPropertyName() + "\n" +
                    "Rent: " + deedCard.getCurrentRent() + "\n" + "Color: " + deedCard.getColorGroup().getColor() + "\n" +
                    "Upgrade Level: " + deedCard.getUpgradeLevel() + "\n");
            informationOfPlayer = informationOfPlayer + informationOfProperty;
            index++;
        }

        if(player != currentPlayer){
            button1.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            button5.setVisible(false);
        }

        informationLabel.setText( informationOfPlayer);
        informationCardScrollPane.setContent(informationLabel);
        informationLabel.setStyle("-fx-text-fill: #000000");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
