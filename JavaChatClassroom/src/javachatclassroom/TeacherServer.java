package javachatclassroom;

import java.util.HashMap;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TeacherServer {

    //client Holder globally accessible 
    public static HashMap<String, Socket> clientsHolder = new HashMap<String, Socket>();
    public static ArrayList<String> clientList = new ArrayList<String>();

    //server private variables
    private static final int port_number = 555;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {

        //initalizing server:
        try {

            System.out.println("##> Initializing Server...");
            serverSocket = new ServerSocket(port_number);
            System.out.println("##> Server Started => address: " + serverSocket.getLocalSocketAddress());
            System.out.println("##> Waiting for clients to connect...");

            while (true) {

                Socket socket = serverSocket.accept();
                String user = addSocketToList(socket);

                if (user == null) {
                    ClientSocketThread clientSocketThread = new ClientSocketThread(socket, user);
                    Thread socketThread = new Thread(clientSocketThread);
                    socketThread.start();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String addSocketToList(Socket socket) throws IOException {

        Scanner userScanner = new Scanner(socket.getInputStream());
        if (userScanner.hasNext()) {
            String userName = userScanner.nextLine().split(">")[1];
            if (clientList.contains(userName)) {
                PrintStream printStream = new PrintStream(socket.getOutputStream());
                printStream.println("##> Error: Username already Exits!");
                printStream.println("##> Please change the Username and Try Again!!!");
                return null;
            }

            clientList.add(userName);
            clientsHolder.put(userName, socket);

            System.out.println("##> User Added: " + userName);
            return userName;
        }
        return null;
    }

}
