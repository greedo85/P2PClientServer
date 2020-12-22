import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

<<<<<<< HEAD
class ClientHandler implements Runnable {
=======
public class ClientHandler implements Runnable{
>>>>>>> 7001e913ac7efa042d218fcdd5265fdd90315759

    private PrintWriter printWriter;
    private BufferedReader bufferedReader;
    Socket socket;
    List<ClientHandler> clientHandlerList;

    public ClientHandler( PrintWriter printWriter, BufferedReader bufferedReader, Socket socket, List<ClientHandler> clientHandlers ) {

        this.printWriter = printWriter;
        this.bufferedReader = bufferedReader;
        this.socket = socket;
        this.clientHandlerList = clientHandlers;
    }

    @Override
    public void run() {
<<<<<<< HEAD
        while (true) {
            try {
=======
        while (true)
        {
            try
            {
>>>>>>> 7001e913ac7efa042d218fcdd5265fdd90315759
                String received="";
                try {
                    received = bufferedReader.readLine();
                } catch (SocketException e) {
                    System.exit(0);
                }
                System.out.println(received);
                for (ClientHandler ch : clientHandlerList) {
                    ch.printWriter.println(received);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


