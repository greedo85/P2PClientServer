import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client1 {

    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;
    private String read;
    private String write;

    public void setName( String name ) {
        this.name = name;
    }

    private String name;

    public Client1() throws IOException {
        socket= new Socket("localhost", 8234);
        printWriter = new PrintWriter(socket.getOutputStream(),true);
        bufferedReader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public String read() throws IOException {
        read= bufferedReader.readLine();
        return read;
    }

    public void write(String text) throws IOException {
        write=text;
        printWriter.println(name+": "+write);
    }
}
