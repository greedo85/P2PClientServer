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

    }

}