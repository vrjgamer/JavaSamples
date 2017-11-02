package teacherchatserver;

import javax.swing.JFrame;

public class TeacherChatServer {

    public static void main(String[] args) {
        ChatServer teacher = new ChatServer();
        teacher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teacher.startRunning();
    }

}
