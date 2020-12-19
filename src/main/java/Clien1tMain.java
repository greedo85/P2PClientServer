import java.io.IOException;
import java.util.Scanner;

public class Clien1tMain {
    static Scanner scanner = new Scanner(System.in);
    static Client1 client1;

    static {
        try {
            client1 = new Client1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) {
        setName();
        Thread thread1 = new Thread(() -> {
            while (true)
                try {
                    System.out.println(client1.read());
                } catch (IOException e) {
                    e.printStackTrace();
                }

        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    client1.write(scanner.nextLine());
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
        client1.setName(scanner.nextLine());
    }
}