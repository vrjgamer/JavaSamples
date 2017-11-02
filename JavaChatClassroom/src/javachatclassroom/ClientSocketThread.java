package javachatclassroom;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import static javachatclassroom.TeacherServer.clientList;
import static javachatclassroom.TeacherServer.clientsHolder;

public class ClientSocketThread implements Runnable {

    Socket socket;
    private String username;
    private PrintWriter socketWriter;
    private Scanner socketReader;
    private String msg;

    public ClientSocketThread(Socket socket, String username) {
        this.socket = socket;
        this.username = username;
    }

    private boolean checkSocketConnection() throws IOException {
        if (!socket.isConnected()) {
            clientList.remove(username);
            clientsHolder.remove(username);
            for (int i = 0; i < clientList.size(); ++i) {
                Socket dSocket = clientsHolder.get(clientList.get(i));
                PrintWriter dPrinter = new PrintWriter(dSocket.getOutputStream());
                dPrinter.println(username + " : " + msg);
                dPrinter.flush();
                System.out.println("Server: " + username + "l̥ Disconnected!");
            }
            System.out.println("##> Server: Client Disconnected! User: " + username);
            return false;
        }
        return true;
    }

    @Override
    public void run() {

        try {
            socketWriter = new PrintWriter(socket.getOutputStream());
            socketReader = new Scanner(socket.getInputStream());

            while (true) {

                if (!checkSocketConnection()) {
                    return;
                }

                if (!socketReader.hasNext()) {
                    continue;
                }

                msg = socketReader.nextLine();
                if (!msg.startsWith("##>")) {
                    System.out.println("Client: " + username + ": " + msg);
                    for (int i = 0; i < clientList.size(); ++i) {
                        Socket dSocket = clientsHolder.get(clientList.get(i));
                        PrintWriter dPrinter = new PrintWriter(dSocket.getOutputStream());
                        dPrinter.println(username + " : " + msg);
                        dPrinter.flush();
                        System.out.println("##> Copy to: " + clientList.get(i));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socketReader.close();
                socketWriter.close();
                this.socket.close();
                System.out.println("##> Server: Client Disconnected! User: " + username);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

}
