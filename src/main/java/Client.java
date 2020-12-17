import java.io.*;
import java.net.Socket;

public class Client {

    private Socket socket;
    private OutputStream outputStream;
    private BufferedReader bufferedReader;
    private String read;
    private String write;
    private String name;

    public Client() throws IOException {
        socket= new Socket("localhost", 888);
        outputStream= socket.getOutputStream();
        bufferedReader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void read() throws IOException {
        read= bufferedReader.readLine();
    }

    public void write(String text) throws IOException {
        write=text;
        outputStream.write((name+":"+write).getBytes());
    }
}
