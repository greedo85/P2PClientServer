package ClientService.GUI;


import ClientService.Client;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;
import java.util.Scanner;

@Getter
public class GUI extends Application {
    Scanner scanner = new Scanner(System.in);
    private Scene mainScene, loginScene;
    private BorderPane borderPane;
    private BoxElements boxElements;
    private Client client;
    private Thread sendMessage, readMessage;
    private String port;
    private String ip, name;
    private SetConnectionWindow setConnectionWindow;

    public GUI() {

        setConnectionWindow = new SetConnectionWindow();
        boxElements = new BoxElements();
        borderPane = new BorderPane();
        borderPane.setLeft(boxElements.userListVbox());
        borderPane.setCenter(boxElements.textAreaVbox());
        borderPane.setBottom(boxElements.sendMessageHbox());
        sendMessage = new Thread(() -> {

            boxElements.getSendButton().setOnAction(msg ->
            {
                boxElements.setMessage(boxElements.getMessageField().getText());
                client.write(boxElements.getMessage());
            });
        });
        readMessage = new Thread(() -> {
            while (true)
                try {
                    boxElements.getUserMessagesTextArea().appendText(client.read() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }catch (NullPointerException e)
                {
                    e.printStackTrace();
                }
        });
    }

    @Override
    public void start( Stage primaryStage ) throws IOException {

        primaryStage.setTitle("Okno klienta");
        loginScene = new Scene(setConnectionWindow.getGridPane(), 500, 400);
        mainScene = new Scene(borderPane, 500, 400);
        primaryStage.setScene(loginScene);
        primaryStage.show();
        //setValues();
        setConnectionWindow.getLoginButton().setOnAction(log ->
        {
            name = setConnectionWindow.getNameField().getText();
            ip = setConnectionWindow.getIpField().getText();
            port = setConnectionWindow.getPortField().getText();
            try {
                client = new Client(ip, port, name);
            } catch (IOException e) {
                e.printStackTrace();
            }

            primaryStage.setScene(mainScene);
        });
        sendMessage.start();
        readMessage.start();

    }

    public synchronized void setValues() {
        name = setConnectionWindow.getNameField().getText();
        ip = setConnectionWindow.getIpField().getText();
        port = setConnectionWindow.getPortField().getText();
    }


}
