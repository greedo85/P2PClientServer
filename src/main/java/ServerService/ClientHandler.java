package ServerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ClientHandler implements Runnable {

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
        String received = null;
        while (true) {
            try {
                try {
                    received = bufferedReader.readLine();
                } catch (SocketException e) {
                    System.exit(0);
                }
                for (ClientHandler ch : clientHandlerList) {
                    ch.printWriter.println(received);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

