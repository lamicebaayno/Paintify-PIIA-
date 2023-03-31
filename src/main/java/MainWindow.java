import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.util.Duration;


public class MainWindow extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // create our main window image
        String path = "/Users/lamicealbaayno/Downloads/paintify.jpg";
        Image image = new Image("file:" + path);
        ImageView paintifyImage = new ImageView(image);

        // set the size of the image view to take up the left half of the window
        paintifyImage.setFitWidth(500);
        paintifyImage.setPreserveRatio(true);

        // create a StackPane and add the image view to it
        StackPane root = new StackPane();
        root.getChildren().add(paintifyImage);
        // fix alignment of the image on our window
        root.setAlignment(paintifyImage, Pos.CENTER_LEFT);

        // create a new Scene with the StackPane as the root and set it on the stage
        Scene scene = new Scene(root, 800, 500);
        // on l'ajoute a la fenetre principale
        stage.setScene(scene);

        // create a PauseTransition to delay the switch to the new window by 5 seconds
        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished(event -> {
            // create a new instance of the DrawingDocs class
            DrawingDocs drawingDocs = new DrawingDocs();
            // create a new stage for the DrawingDocs object and show it
            Stage drawingStage = new Stage();
            drawingDocs.createNewDrawingPage(drawingStage);
            drawingStage.show();
            // hide the main window
            stage.hide();
        });

        // show the stage
        stage.show();

        // start the delay
        delay.play();

    }

    public static void main(String[] args){
        // call the start method and launch the javafx application
        launch(args);
    }

}