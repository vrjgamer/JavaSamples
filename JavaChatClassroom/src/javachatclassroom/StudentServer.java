package javachatclassroom;

import java.io.IOException;
import java.net.Socket;

public class StudentServer {

    private static final String HOST = "localhost";
    private static final int PORT = 555;

    private Socket socket;
    private String username;

    public static void main(String[] args) throws Exception {

        StudentServer server = new StudentServer();
        server.connectSocket("hobo");

    }

    private void connectSocket(String username) {
        try {
            // connect to hosted server socket with username
            System.out.println("##> Intializing connection...");
            socket = new Socket(HOST, PORT);
            this.username = username;
            try {
                StudentSocketThread studentSocketThread = new StudentSocketThread(socket, username);
                //create socket thread
                Thread socketThread = new Thread(studentSocketThread);
                socketThread.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
