import java.io.*;
import java.net.Socket;

public class Client {

    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;
    private String read;
    private String write;
    private String name;

    public Client() throws IOException {
        socket= new Socket("localhost", 8234);
        printWriter = new PrintWriter(socket.getOutputStream(),true);
        bufferedReader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    public void setName( String name ) {
        this.name = name;
    }


    public Socket getSocket() {
        return socket;
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
