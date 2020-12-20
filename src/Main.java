import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        primaryStage = stage;

        primaryStage.setTitle("Monopoly Game");
        primaryStage.setScene(new Scene(root, 1920 , 1080));

        //primaryStage.setMaximized(true);
        //primaryStage.setFullScreen(true);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
