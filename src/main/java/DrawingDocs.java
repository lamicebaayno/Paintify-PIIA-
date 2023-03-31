import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class DrawingDocs extends VBox {


    public void createNewDrawingPage(Stage stage) {
        BorderPane root = new BorderPane();

        // add the Documents text to the top of the page
        Text pageTitle = createPageTitle();
        root.setTop(pageTitle);

        // add the New button to the left side of the page
        HBox newButton = createNewButton();
        HBox hbox = new HBox();
        hbox.getChildren().add(newButton);
        hbox.setAlignment(Pos.TOP_LEFT);
        hbox.setPadding(new Insets(50, 0, 0, 0)); // add padding to the top
        root.setLeft(hbox);
        BorderPane.setAlignment(hbox, Pos.TOP_LEFT);


        Scene scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.show();
    }

    private Text createPageTitle() {
        Text documentsText = new Text("Documents");
        documentsText.setFont(Font.font("TimesNewRoman", FontWeight.BOLD, 80));
        documentsText.setStyle("-fx-padding: 10px;");
        BorderPane.setAlignment(documentsText, Pos.CENTER);
        return documentsText;
    }

    // FIX : the "new" text is not at the center height of the button
    private HBox createNewButton() {

        String path = "/Users/lamicealbaayno/Desktop/newBImage.png";
        Image image = new Image("file:" + path);
        ImageView newBImage = new ImageView(image);
        Button newButton = new Button();
        newBImage.setFitWidth(60);
        newBImage.setFitHeight(60);
        newButton.setGraphic(newBImage);
        newButton.setPrefSize(60, 60);

        Text newText = new Text("New...");
        newText.setFont(Font.font("Arial", FontWeight.NORMAL, 30));

        HBox hbox = new HBox(10, newButton, newText);
        hbox.setAlignment(Pos.TOP_LEFT); // set alignment for hbox

        // when the newButton is pressed, we are directed to
        // an empty drawing page
        newButton.setOnAction(e -> {
            DrawingApplication drawingApp = new DrawingApplication();
            try {
                drawingApp.start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        return hbox;

    }


}
