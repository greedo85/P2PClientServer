package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class GUI extends Application {


    private Scene scene;
    private BorderPane borderPane;
    private VBoxElements vBoxElements;
    private HBoxElements hBoxElements;

    public GUI() {

        borderPane = new BorderPane();
        vBoxElements = new VBoxElements();
        hBoxElements = new HBoxElements();
        borderPane.setLeft(vBoxElements.userListVbox());
        borderPane.setCenter(vBoxElements.textAreaVbox());
        borderPane.setBottom(hBoxElements.sendMessageHbox());
    }

    @Override
    public void start( Stage primaryStage ) throws Exception {
        primaryStage.setTitle("Okno klienta");
        scene = new Scene(borderPane, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
