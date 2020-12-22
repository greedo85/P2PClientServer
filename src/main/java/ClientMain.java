import java.io.IOException;
import java.util.Scanner;

public class ClientMain {
    static Scanner scanner = new Scanner(System.in);
    static Client client;

    static {
        try {
            client = new Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) {
        setName();
        Thread readMessage = new Thread(() -> {
            while (true)
                try {
                    System.out.println(client.read());
                } catch (IOException e) {
                    e.printStackTrace();
                }

        });
        Thread sendMessage = new Thread(() -> {
            while (true) {
                client.write(scanner.nextLine());
            }
        });
        readMessage.start();
        sendMessage.start();
    }

    static synchronized void setName() {
        System.out.println("Wpisz imię: ");
        client.setName(scanner.nextLine());
    }
}