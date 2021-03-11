package ClientService.GUI;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import lombok.Getter;

@Getter
public class SetConnectionWindow {

    private Label ipLabel, nameLabel, portLabel ;
    private TextField ipField, nameField, portField;
    private GridPane gridPane;
    private Button loginButton;
    public SetConnectionWindow() {
        loginButton=new Button("Zaloguj");
        gridPane=new GridPane();
        ipLabel=new Label("Podaj ip serwera");
        nameLabel=new Label("Podaj nick");
        portLabel=new Label("Wpisz port serwera");
        ipField=new TextField();
        nameField=new TextField();
        portField=new TextField();
        GridPane.setConstraints(ipLabel,0,0);
        GridPane.setConstraints(ipField,0,1);
        GridPane.setConstraints(portLabel,1,0);
        GridPane.setConstraints(portField,1,1);
        GridPane.setConstraints(nameLabel,2,0);
        GridPane.setConstraints(nameField,2,1);
        GridPane.setConstraints(loginButton,3,1);
        gridPane.getChildren().addAll(ipLabel,ipField,portLabel,portField,nameLabel,nameField,loginButton);
        gridPane.setPadding(new Insets(20,20,20,20));
    }

}
