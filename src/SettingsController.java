import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    private Slider musicSlider;

    @FXML
    private Slider soundSlider;

    @FXML
    public void getValueMusicSlider() {
        int sliderValue = (int) musicSlider.getValue();
        System.out.println(sliderValue);
    }

    @FXML
    public void getValueSoundSlider() {
        int sliderValue = (int) soundSlider.getValue();
        System.out.println(sliderValue);
    }

    @FXML
    private ImageView music;

    @FXML
    private ImageView sound;

    @FXML
    private ImageView settings;

    @FXML
    private ImageView back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setIcon("music-note.png", music);
        setIcon("volume.png", sound);
        setIcon("settings.png", settings);
        setIcon("back.png", back);

        back.setOnMouseClicked(new EventHandler() {
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

    private void setIcon(String path, ImageView imageView) {
        File file = new File(path);
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }
}
