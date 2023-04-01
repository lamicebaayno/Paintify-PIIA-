import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// CHECK if we want to exit the window completely or its ok to go to the previous one
// idea : when we exit, ask if we want to save the document if new or changes if we did something
// TODO : put the buttons of the toolkit in methods
public class DrawingApplication extends Application {


    private HBox createToolKit() {
        // Create a gray HBox with some padding and add it to the top of the BorderPane
        HBox toolKit = new HBox();
        toolKit.setStyle("-fx-background-color: grey; -fx-padding: 5px;");
        toolKit.setPadding(new Insets(10, 20, 10, 20));
        toolKit.setPrefHeight(40);

        // Add components to the tool kit
        toolKit.setSpacing(10);

        // Return button
        Button returnButton = createReturnButton();

        // Save button
        Button saveButton = createSaveButton();



        toolKit.getChildren().addAll(returnButton, saveButton);

        return toolKit;

    }

    private Button createReturnButton(){
        String path = "/Users/lamicealbaayno/Desktop/returnBImage.png";
        Image image = new Image("file:" + path);
        ImageView returnBImage = new ImageView(image);
        Button returnButton = new Button();
        returnBImage.setFitWidth(30);
        returnBImage.setFitHeight(30);
        returnButton.setGraphic(returnBImage);
        returnButton.setPrefSize(30, 30);

        // return to the docs page
        // TODO : ask if we want to save and add in the docs page
        returnButton.setOnAction(e -> {
            Stage stage = (Stage) returnButton.getScene().getWindow();
            stage.close();
        });

        return returnButton;
    }

    private Button createSaveButton(){
        String path = "/Users/lamicealbaayno/Desktop/saveBImage.png";
        Image image = new Image("file:" + path);
        ImageView saveBImage = new ImageView(image);
        Button saveButton = new Button();
        saveBImage.setFitWidth(30);
        saveBImage.setFitHeight(30);
        saveButton.setGraphic(saveBImage);
        saveButton.setPrefSize(30, 30);

        // TODO : make the save window

        return saveButton;
    }

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        // Create the toolkit of the drawing page
        HBox toolKit = createToolKit();
        root.setTop(toolKit);

        // Create the drawing surface and add it to the center of the root pane
        Canvas canvas = new Canvas(800, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        root.setCenter(canvas);


        // Create the scene and set it on the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
