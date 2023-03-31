import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        Text documentsText = createDocumentTitle();
        root.setTop(documentsText);

        // add the New button to the left side of the page
        Button newButton = createNewButton();
        HBox hbox = new HBox();
        hbox.getChildren().add(newButton);
        hbox.setAlignment(Pos.CENTER_LEFT);
        root.setLeft(hbox);

        Scene scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.show();
    }

    private Text createDocumentTitle() {
        Text documentsText = new Text("Documents");
        documentsText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        documentsText.setStyle("-fx-padding: 10px;");
        BorderPane.setAlignment(documentsText, Pos.CENTER);
        return documentsText;
    }

    private Button createNewButton() {
        Button newButton = new Button("New");
        newButton.setStyle("-fx-padding: 10px;");
        return newButton;
    }


}
