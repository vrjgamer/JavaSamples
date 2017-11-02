package studentchatclient;

import javax.swing.JFrame;

public class StudentChatClient {

    public static void main(String[] args) {
        ChatClient student = new ChatClient();
        student.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        student.startRunning();
    }

}
