import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket;

    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    List<Socket> socketList;

    public void setStreams() throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter = new PrintWriter(socket.getOutputStream(), true);
    }

    public void acceptClient() throws IOException {
        socket = serverSocket.accept();
        socketList.add(socket);
        System.out.println("podłączono klienta:" + socket.getPort());
    }

    public Server( int port ) throws IOException {
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (SocketException e) {
            System.exit(0);
        }
        socketList = new ArrayList<>();
    }

    public void write() throws IOException {
        for (Socket c : socketList) {
            if (!socketList.equals(c)) {
                printWriter.println("server: " + bufferedReader.readLine());
            }

        }
    }
}
