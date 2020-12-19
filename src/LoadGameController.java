import data.FileManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.BoardConfiguration;
import model.GamePace;
import model.player.AICharacteristic;
import model.session.GameSession;
import model.session.GameSessionManager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadGameController implements Initializable {

    @FXML
    private ListView<String> listView = new ListView<String>();
    private ObservableList<String> listViewData = FXCollections.observableArrayList ();

    private String selectedSaveFileName;

    @FXML
    public void goToMainMenu(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);

        // Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        tableViewParent.setId("pane");

        window.setScene(tableViewScene);

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((screenBounds.getHeight() - window.getHeight()) / 2);

        window.show();
    }

    @FXML
    //where we give/save these settings to boardconfig object (model)
    private void handleStartGame(ActionEvent event) throws IOException, ClassNotFoundException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameBoard.fxml"));
        Parent root = (Parent)fxmlLoader.load();

        GameBoardController controller = fxmlLoader.<GameBoardController>getController();

        GameSessionManager sessionManager = new GameSessionManager();
//        sessionManager.setFileName("board_template.json");  //delete this when test is over
//        uncomment this when test is over
        sessionManager.loadGame( selectedSaveFileName);
        GameSession session = sessionManager.getGame();
//        System.out.println(session);
        controller.setGameSession(session);
        controller.init();


        Scene scene = new Scene(root);

//        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GameBoard.fxml"));
//        Scene tableViewScene = new Scene(tableViewParent);
//        BoardConfiguration boardConfiguration;
        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);

        //primaryStage.setMaximized(true);
        //primaryStage.setFullScreen(true);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((screenBounds.getHeight() - window.getHeight()) / 2);
        window.show();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> saveFiles = FileManager.getSavedSessionNames();

        for(String save: saveFiles){
            listViewData.add(save.substring(0,save.lastIndexOf(".")));
        }
        listView.setItems(listViewData);

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                selectedSaveFileName = newValue;
                System.out.println(selectedSaveFileName);
            }
        });
    }
}
