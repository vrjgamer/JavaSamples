package teacherchatserver;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatServer extends JFrame {

    //GUI Components
    private JTextField userText;
    private JTextArea chatWindow;

    //Chat Stream Components
    private ObjectOutputStream outMsgWriter;
    private ObjectInputStream inMsgReader;

    //Server Components+
    private int port_number = 555;
    private ServerSocket server;
    private Socket connection;

    public ChatServer() {
        //setting JFrame title
        super("Teacher Chat Server");
        //initializing JTextField
        userText = new JTextField();
        
        //disable JTextField
        userText.setEditable(false); // to stop user  
        
        //attach action listener
        userText.addActionListener(new ActionListener() {
            //called when enter is pressed
            public void actionPerformed(ActionEvent event) {
                //send entered text as message
                sendMessage(event.getActionCommand());
                //make text field blank
                userText.setText("");
            }
        });
        //add textfield to frame
        add(userText, BorderLayout.NORTH);

        
        //initailizing JTextArea
        chatWindow = new JTextArea();

        //add JTextArea to frame with scroll enabled
        add(new JScrollPane(chatWindow), BorderLayout.CENTER);

        //setting size of JFrame
        setSize(600, 400);
        //setting JFrame visibility 
        setVisible(true);

    }

    //To start the server
    public void startRunning() {
        try {
            //starting server on port: port_number
            server = new ServerSocket(port_number);
            while (true) {
                try {
                    //Trying to connect
                    waitForClient();
                    //after connection setup in and out streams
                    setupStreams();
                    //after setting up streams start chat box
                    startChatting();
                } catch (Exception e) {
                    //on any error encountered 
                    e.printStackTrace();
                    showMessage("\n Connection Ended!");
                } finally {
                    //close all server connections and streams
                    closeServerConnections();
                }
            }
        } catch (IOException ioException) {
            //exception if not able to start server on defined port_number
            ioException.printStackTrace();
        }
    }

    private void closeServerConnections() {
        showMessage("\nClosing Connections... \n");
        //disable JTextField
        enableChatBox(false);

        try {
            //close student outgoing message stream
            outMsgWriter.close();
            //close student incoming message stream
            inMsgReader.close();
            //close student socket connection
            connection.close();

        } catch (IOException ioException) {
            //any error encountered 
            ioException.printStackTrace();
        }finally{
            showMessage("\nConnection closed! \n");
        }
    }

    private void waitForClient() throws IOException {
        showMessage("Wating for student to connect...");

        //waits for any student (socket) to connect.
        connection = server.accept();

        showMessage("\nConnected to Student: " + connection.getLocalSocketAddress());
    }

    private void setupStreams() throws IOException {
        //initializing outgoing message sender
        outMsgWriter = new ObjectOutputStream(connection.getOutputStream());
        outMsgWriter.flush(); //clear garbage values

        //initializing incoming message reader
        inMsgReader = new ObjectInputStream(connection.getInputStream());
    }

    private void startChatting() throws IOException {
        String message = " Connection Established! ";
        //send status message to student
        sendMessage(message);
        //enable JTextField
        enableChatBox(true);

        do {
            try {
                //read incoming messages from student
                message = (String) inMsgReader.readObject();
                //show incoming messages in JTextArea
                showMessage("\n" + message);

            } catch (ClassNotFoundException classNotFoundException) {
                //if user sends any unknow object
                showMessage("\nThe user has sent an unknown object!");
                classNotFoundException.printStackTrace();
            }

        } while (!message.equals("STUDENT - @END"));//stop loop when student types ''@END''  and end connections
    }

    private void sendMessage(String message) {
        try {
            //write message on output buffer
            outMsgWriter.writeObject("TEACHER - " + message);
            //send the message to student
            outMsgWriter.flush();
            //show message in JTextArea
            showMessage("\nTEACHER - " + message);
        } catch (IOException ioException) {
            //error if not able to send message
            showMessage("\n ERROR: CANNOT SEND MESSAGE, PLEASE RETRY");
            ioException.printStackTrace();
        }
    }

    private void showMessage(final String message) {
        //execute on underlying thread to prevent concurrent access 
//        SwingUtilities.invokeLater(
//                new Runnable() {
//                    public void run() {
//                        //append message to JTextArea
//                        chatWindow.append(message);
//                    }
//        });

        chatWindow.append(message);
        
    }

    private void enableChatBox(final boolean enable) {
//        SwingUtilities.invokeLater(
//                new Runnable() {
//                    public void run() {
//                        userText.setEditable(enable);
//                    }
//                }
//        );

         userText.setEditable(enable); 
    }
}
