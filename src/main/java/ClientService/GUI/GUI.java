package ClientService.GUI;


import ClientService.Client;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;
import java.util.Scanner;

@Getter
public class GUI extends Application {
    Scanner scanner=new Scanner(System.in);
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
            });
        });
        readMessage = new Thread(() -> {
            while (true)
                try {

                    boxElements.getUserMessagesTextArea().appendText(client.read()+"\n");
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
        setConnectionData();
        setName();
        sendMessage.start();
        readMessage.start();

    }
    public synchronized void setName() {
        System.out.println("Wpisz imię: ");
        client.setName(scanner.nextLine());
    }

    public synchronized void setConnectionData()
    {
        System.out.println("Podaj ip serwera: ");
        client.setIp(scanner.nextLine());
        System.out.println("Podaj port serwera: ");
        client.setPort(scanner.nextInt());
    }


}
