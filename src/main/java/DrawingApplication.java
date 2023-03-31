import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// CHECK if we want to exit the window completely or its ok to go to the previous one
public class DrawingApplication extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        // TODO: Add components to the root pane 

        Scene scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
