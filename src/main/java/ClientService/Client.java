package ClientService;

import GUI.*;
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
    private String write;
    private String name = "testowyKlient";

    public Client() throws IOException {
        socket = new Socket("localhost", 8234);
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
        write = msg;
        printWriter.println(name + ": " + write);
    }

}
