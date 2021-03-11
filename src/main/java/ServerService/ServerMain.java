package ServerService;

import java.io.IOException;
import java.net.Inet4Address;
import java.util.Scanner;

public class ServerMain {
    static Scanner scanner=new Scanner(System.in);
    static Server server;

    public static void main( String[] args ) throws IOException {
        System.out.println("Podaj port serwera: ");
        int port= scanner.nextInt();
        server=new Server(port);
        System.out.println("Serwer dostępny na porcie: "+port+ " IP serwera: "+ Inet4Address.getLocalHost().getHostAddress());
        server.runServer();
    }

}