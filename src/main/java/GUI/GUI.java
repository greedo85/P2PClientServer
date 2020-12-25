package GUI;


import ClientService.Client;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;

@Getter
public class GUI extends Application {

    private Scene scene;
    private BorderPane borderPane;
    private BoxElements boxElements;
    private Client client;
    Thread sendMessage;
    Thread readMessage;
    public GUI() throws IOException {

        boxElements = new BoxElements();
        borderPane = new BorderPane();
        borderPane.setLeft(boxElements.userListVbox());
        borderPane.setCenter(boxElements.textAreaVbox());
        borderPane.setBottom(boxElements.sendMessageHbox());
        client = new Client();
        sendMessage = new Thread(() -> {

            boxElements.getSendButton().setOnAction(msg ->
            {
                boxElements.setMessage(boxElements.getMessageField().getText());
                client.write(boxElements.getMessage());
                System.out.println("message: " + boxElements.getMessage());

            });
        });
        readMessage = new Thread(() -> {
            while (true)
                try {

                    System.out.println("Wątek readMessage");
                    System.out.println("client.read()");
                   // boxElements.getUserMessagesTextArea().appendText(client.read());
                    boxElements.getUserMessagesTextArea().appendText(client.getBufferedReader().readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
        });
    }

    @Override
    public void start( Stage primaryStage ) {
        primaryStage.setTitle("Okno klienta");
        scene = new Scene(borderPane, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        sendMessage.start();
        readMessage.start();
    }
}
