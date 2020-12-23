package ServerService;

import java.io.IOException;

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
        server.runServer();
    }

}