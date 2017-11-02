package client.app;


import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatClient extends JFrame{
	
	public static void main(String[] args) {
		ChatClient client = new ChatClient();
		client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		client.startRunning();
	}
	
	private static String serverAdmin = "VAIDEHI";
	private static String clientName = "SAGARIKA";
	
	 //GUI Components
    private JTextField userText;
    private JTextArea chatWindow;

    //Chat Stream Components
    private ObjectOutputStream outMsgWriter;
    private ObjectInputStream inMsgReader;
    private String message = "";

    //Client Socket Components
    private int port_number = 555;
    private String serverHost = "localhost";
    private Socket connection;

    public ChatClient() {
        //setting JFrame title
        super(clientName+" Chat Client");
        //initializing JTextField
        userText = new JTextField();
        
        //disable JTextField
        userText.setEditable(false);
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

    //To start the client
    public void startRunning() {
        try {
            //connect to admin's server
            connectToServer();
            //after connection setup in and out streams
            setupStreams();
            //after setting up streams start chat box
            startChatting();
        } catch (EOFException eofException) {
            //on connection closed
            showMessage("\nConnection Ended!");
        } catch (IOException ioException) {
            //if not able to connect to server
            ioException.printStackTrace();
        } finally {
            //close all connections to server
            closeConnections();
        }
    }

    private void closeConnections() {
        showMessage("\nClosing Connections... \n");
        //disable JTextField
        enableChatBox(false);

        try {
            //close server outgoing message stream
            outMsgWriter.close();
            //close server incoming message stream
            inMsgReader.close();
            //close server server socket connection
            connection.close();

        } catch (IOException ioException) {
            //any error encountered 
            ioException.printStackTrace();
        }finally{
            showMessage("\nConnection closed! \n");
        }
    }

    private void connectToServer() throws IOException {
        showMessage("Trying to connect to Server...");

        //connect to server on host: serverHost, port: port_number
        connection = new Socket(serverHost, port_number);

        showMessage("\nConnected to Server: " + connection.getLocalAddress());
    }

    private void setupStreams() throws IOException {
        //initializing outgoing message sender
        outMsgWriter = new ObjectOutputStream(connection.getOutputStream());
        outMsgWriter.flush(); //clear garbage values

        //initializing incoming message reader
        inMsgReader = new ObjectInputStream(connection.getInputStream());
    }

    private void startChatting() throws IOException {
        //enable JTextField
        enableChatBox(true);

        do {
            try {
                //read incoming messages from server
                message = (String) inMsgReader.readObject();
                //show incoming messages in JTextArea
                showMessage("\n" + message);

            } catch (ClassNotFoundException classNotFoundException) {
                //if server sends any unknow object
                showMessage("\nThe server has sent an unknown object!");
                classNotFoundException.printStackTrace();
            }

        } while (!message.equals(serverAdmin+" - @END"));//stop loop when server types ''@END''  and end connections
    }

    private void sendMessage(String message) {
        try {
            //write message on output buffer
            outMsgWriter.writeObject(clientName+" - " + message);
            //send the message to server
            outMsgWriter.flush();
            //show message in JTextArea
            showMessage("\n"+clientName+" - " + message);
        } catch (IOException ioException) {
            //error if not able to send message
            showMessage("\n ERROR: CANNOT SEND MESSAGE, PLEASE RETRY");
            ioException.printStackTrace();
        }
    }

    private void showMessage(final String message) {
        chatWindow.append(message);
    }

    private void enableChatBox(final boolean enable) {
    	userText.setEditable(enable);
    }
}
