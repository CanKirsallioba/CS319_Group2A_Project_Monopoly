import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreditsController implements Initializable {
    @FXML
    ImageView backIcon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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

                window.show();
            }
        });
    }
}
