package ClientService.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoxElements {

    private TextArea userListTextArea;
    private Label title;
    private TextArea userMessagesTextArea;
    private Button sendButton;
    private Label typeLabel;
    private TextField messageField;
    String message;

    public BoxElements() {
        userMessagesTextArea = new TextArea();
        userListTextArea = new TextArea();
        userListTextArea.setPrefHeight(300);
        userMessagesTextArea.setPrefHeight(300);
        sendButton = new Button("Wyślij");
        messageField = new TextField();
        messageField.setPrefWidth(200);
    }

    public VBox userListVbox() {
        title = new Label("Lista userów");
        title.setFont(Font.font("Arial Bold", 14));
        VBox usersVbox = new VBox();
        usersVbox.setPadding(new Insets(15, 10, 15, 10));
        usersVbox.setMaxWidth(140);
        usersVbox.setPrefHeight(300);
        usersVbox.setSpacing(5.0);
        usersVbox.getChildren().addAll(title, userListTextArea);
        return usersVbox;
    }

    public VBox textAreaVbox() {

        title = new Label("Czat: ");
        title.setTextFill(Color.valueOf("white"));
        title.setFont(Font.font("Arial Bold", 14));
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(15, 10, 15, 10));
        vBox.setPrefHeight(300);
        vBox.setSpacing(10.0);
        vBox.setStyle("-fx-background-color: #336688;");
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(title, userMessagesTextArea);
        return vBox;
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
