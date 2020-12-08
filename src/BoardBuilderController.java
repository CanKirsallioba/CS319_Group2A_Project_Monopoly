import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BoardBuilderController implements Initializable {

    private final int MIN_SALARY = 200;
    private final int MAX_SALARY = 5000;
    private final int INITIAL_VAL = 400;
    private final int STEP_SALARY = 200;

    @FXML
    private TextField boardNameField = new TextField();
    private String boardName;

    @FXML
    private Spinner<Integer> salarySpinner;
    private int goTileSalary = INITIAL_VAL;

    SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactorySalary =
            new SpinnerValueFactory.IntegerSpinnerValueFactory( MIN_SALARY, MAX_SALARY, INITIAL_VAL, STEP_SALARY);

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //spinner set factory
        salarySpinner.setValueFactory(spinnerValueFactorySalary);

        //spinner listener
        salarySpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            goTileSalary = newValue;
        });

        //board name text field listener
        boardNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            boardName = newValue;
        });
    }

    @FXML
    public void goToMainMenu( ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);
        // Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setId("panemenu");
        window.setScene(tableViewScene);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((screenBounds.getHeight() - window.getHeight()) / 2);
        window.show();
    }

    //pop up
    @FXML
    public void openDialog(ActionEvent event) throws IOException {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Label("The player will customize the property in this screen"));
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    @FXML
    //where we give/save these settings to board object (model) to store
    //with name, salary and properties list info as parameters
    private void handleBoardBuilding(ActionEvent event) {
        System.out.println(boardName);
        System.out.println(goTileSalary);
    }
}
