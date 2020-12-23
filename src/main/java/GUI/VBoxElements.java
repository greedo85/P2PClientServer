package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import lombok.Getter;

@Getter
public class VBoxElements {

    private TextArea userList;
    private Label title;
    private TextArea textArea;

    public VBoxElements() {
        userList = new TextArea();
        userList.setPrefHeight(300);
        textArea = new TextArea();
        textArea.setPrefHeight(300);
    }

    public VBox userListVbox() {
        title = new Label("Lista userów");
        title.setFont(Font.font("Arial Bold", 14));
        VBox users = new VBox();
        users.setPadding(new Insets(15, 10, 15, 10));
        users.setMaxWidth(140);
        users.setPrefHeight(300);
        users.setSpacing(5.0);
        users.getChildren().addAll(title, userList);
        return users;
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
        vBox.getChildren().addAll(title, textArea);
        return vBox;
    }
}
