import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

public class ServerMain {
    static Scanner scanner=new Scanner(System.in);
    public static void main( String[] args ) throws IOException {
        try {
            Server server = new Server(8234);
            Thread thread1 = new Thread(() -> {
                while (true)
                    try {
                        System.out.println(server.read());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            });
            Thread thread2 = new Thread(() -> {
                while (true) {
                    try {
                        server.write(scanner.nextLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            });
            Thread thread3 = new Thread(() -> {
                try {
                    server.setSocket();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread1.start();
            thread2.start();
            thread3.start();
        }
        catch (SocketException e)
        {
            System.out.println(e.toString());
            System.out.println("Błąd połączenia");
            System.exit(0);
        }
    }
}