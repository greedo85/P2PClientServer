package GUI;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import lombok.Getter;

@Getter
public class HBoxElements {

    private Button sendButton;
    private Label typeLabel;
    private TextField messageField;

    public HBoxElements() {

        sendButton = new Button("Wyślij");
        messageField = new TextField();
        messageField.setPrefWidth(200);
    }

    public HBox sendMessageHbox() {
        typeLabel = new Label("Wpisz wiadomość:");
        typeLabel.setTextFill(Color.valueOf("white"));
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10.0);
        hBox.setStyle("-fx-background-color: #336688;");
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.getChildren().addAll(typeLabel, messageField, sendButton);
        return hBox;
    }

}
