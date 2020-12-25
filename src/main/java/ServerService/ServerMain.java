package ServerService;

import java.io.IOException;
import java.util.Scanner;

public class ServerMain {
    static Scanner scanner=new Scanner(System.in);
    static Server server;

    public static void main( String[] args ) throws IOException {
        System.out.println("Podaj port serwera: ");
        int port= scanner.nextInt();
        server=new Server(port);
        server.runServer();
    }

}