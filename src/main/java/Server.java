import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader bufferedReader;
    private OutputStream outputStream;
    private String read;
    private String write;


    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.socket = serverSocket.accept();
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.outputStream = socket.getOutputStream();
    }

    public void read() throws IOException {
        read= bufferedReader.readLine();
    }

    public void send(String text) throws IOException {
        write=text;
        outputStream.write(text.getBytes());
    }
}
