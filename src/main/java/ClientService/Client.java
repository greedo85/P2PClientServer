package ClientService;

import lombok.Getter;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

@Getter
public class Client {

    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;
    private String read;
    private String name = "testowyKlient";
   

    public Client( String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        printWriter = new PrintWriter(socket.getOutputStream(), true);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String read() throws IOException {
        try {
            read = bufferedReader.readLine();
        } catch (SocketException e) {
            bufferedReader.close();
            printWriter.close();
            socket.close();
            System.exit(0);
        }
        return read;
    }

    public void write( String msg ) {
        printWriter.println(name + ": " + msg);
    }

}
