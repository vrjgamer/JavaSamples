package javachatclassroom;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class StudentSocketThread implements Runnable {

    //thread socket and username
    Socket socket;
    private String username;
    //socket input message reader
    private Scanner incomingMsgReader;
    //socket output message sender
    private PrintWriter outgoingMsgWriter;

    //terminal reader
    private Scanner terminal;

    public StudentSocketThread(Socket s, String username) {
        this.socket = s;
        this.username = username;
    }

    @Override
    public void run() {
        try {
            //initialize reader and sender
            this.incomingMsgReader = new Scanner(socket.getInputStream());
            this.outgoingMsgWriter = new PrintWriter(socket.getOutputStream());
            this.outgoingMsgWriter.println("##> "+this.username);
            this.outgoingMsgWriter.flush();
            System.out.println("##> Connected.");

            //temp section
            //temp terminal reader
            terminal = new Scanner(System.in);
            //temp section

            //checking for incoming messages
            checkIncomingStream();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //stop socket and disconnect it
                incomingMsgReader.close();
                outgoingMsgWriter.close();
                socket.close();
                System.out.println("##> You Disconnected.");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    private void checkIncomingStream() throws IOException{

        while (true) {
            if (incomingMsgReader.hasNext()) {
                //read incoming message
                String message = incomingMsgReader.nextLine();
                
                if(message.startsWith("##>")){
                     System.err.println("error : "+message);
                     disconnectSocket();
                }else{
                //display incoming message
                     System.out.println("receive : "+message);
                }
            }
             if (terminal.hasNext()) {
                sendOutgoingMessage(terminal.nextLine());
            }
        }
    }

    private void sendOutgoingMessage(String msgString) {

        System.out.println("##> send : "+msgString);
        //send outgoing message
        outgoingMsgWriter.println(msgString);
        outgoingMsgWriter.flush();

        //set message field empty
    }

    private void disconnectSocket() throws IOException {

        //send disconnecting status to server
        outgoingMsgWriter.println("##> User: " + username + " has disconnected.");
        outgoingMsgWriter.flush();

        //socket stop and disconnect
        socket.close();

        //close program
        System.exit(0);
    }

}
