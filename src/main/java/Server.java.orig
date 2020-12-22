import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    List<ClientHandler> clientHandlers;

    public void acceptClient() throws IOException {
        while (true) {
            socket = serverSocket.accept();
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            ClientHandler clientHandler = new ClientHandler(printWriter, bufferedReader, socket, clientHandlers);
<<<<<<< HEAD
            Thread thread = new Thread(clientHandler);
=======
>>>>>>> 7001e913ac7efa042d218fcdd5265fdd90315759
            clientHandlers.add(clientHandler);
            Thread thread = new Thread(clientHandler);
            System.out.println("podłączono klienta:" + socket.getPort());
            thread.start();
        }
    }

    public Server( int port ) throws IOException {
        serverSocket = new ServerSocket(port);
        clientHandlers = new ArrayList<>();
    }
<<<<<<< HEAD
=======


>>>>>>> 7001e913ac7efa042d218fcdd5265fdd90315759
}