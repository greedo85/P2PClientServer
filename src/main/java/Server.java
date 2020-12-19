import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private String read;
    private String write;
    public void setSocket() throws IOException {
         socket=serverSocket.accept();
    }

    public Server( int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.socket = serverSocket.accept();
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.printWriter =new PrintWriter(socket.getOutputStream(),true);
    }

    public String read() throws IOException {
        read = bufferedReader.readLine();
        return read;
    }

    public void write(String text) throws IOException {
        write=text;
        printWriter.println("server: "+text);
    }
}
