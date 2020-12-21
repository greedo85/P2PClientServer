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
    List<ClientHandler> clientHandlers;

    public void acceptClient() throws IOException {
        while(true)
        {
            socket = serverSocket.accept();
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            ClientHandler clientHandler=new ClientHandler(printWriter,bufferedReader,socket);
            Thread thread=new Thread(clientHandler);
            clientHandlers.add(clientHandler);
            System.out.println("podłączono klienta:" + socket.getPort());
            thread.start();
        }
    }

    public Server( int port ) throws IOException {
        serverSocket = new ServerSocket(port);
        clientHandlers = new ArrayList<>();
    }
    class ClientHandler implements Runnable{

        private PrintWriter printWriter;
        private BufferedReader bufferedReader;
        Socket socket;

        public ClientHandler( PrintWriter printWriter, BufferedReader bufferedReader, Socket socket ) {
            this.printWriter = printWriter;
            this.bufferedReader = bufferedReader;
            this.socket = socket;
        }


        @Override
        public void run() {
            while (true)
            {
                try
                {
                    String received=bufferedReader.readLine();
                    System.out.println(received);
                    for (ClientHandler ch: clientHandlers) {
                        ch.printWriter.println(received);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}