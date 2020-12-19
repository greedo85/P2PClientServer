import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

public class ServerMain {
    static Server server;

    static {
        try {
            server = new Server(8234);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) throws IOException {
        server.acceptClient();
        server.setStreams();
        Thread writeToClients = new Thread(() -> {
            while (true) {
                try {
                    server.write();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread acceptClients=new Thread(()->
        {
            while(true) {
                try {
                    server.acceptClient();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        acceptClients.start();
        writeToClients.start();
    }

}