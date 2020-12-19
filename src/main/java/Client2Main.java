import java.io.IOException;
import java.util.Scanner;

public class Client2Main {
    static Scanner scanner = new Scanner(System.in);
    static Client2 client2;

    static {
        try {
            client2 = new Client2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) {
        setName();
        Thread thread1 = new Thread(() -> {
            while (true)
                try {
                    System.out.println(client2.read());
                } catch (IOException e) {
                    e.printStackTrace();
                }

        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    client2.write(scanner.nextLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        thread1.start();
        thread2.start();
    }

    static synchronized void setName() {
        System.out.println("Wpisz imię: ");
        client2.setName(scanner.nextLine());
    }
}