import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        primaryStage.setTitle("Monopoly Game");
        primaryStage.setScene(new Scene(root, 800, 600));

        //primaryStage.setMaximized( true);
        //primaryStage.setFullScreen(true);

        primaryStage.show();


        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((screenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((screenBounds.getHeight() - primaryStage.getHeight()) / 2);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
