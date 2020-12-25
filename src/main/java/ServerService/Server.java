package ServerService;

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

    public void runServer() throws IOException {
        while (true) {
            socket = serverSocket.accept();
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            ClientHandler clientHandler = new ClientHandler(printWriter, bufferedReader, socket, clientHandlers);
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
}