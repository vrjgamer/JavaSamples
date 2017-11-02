
package socketprogrammingproject;

import java.io.*;
import java.net.*;

public class ServerClass {
    
  public static void main(String[] args) throws Exception{
        ServerClass serverClass = new ServerClass();
        serverClass.run();
    }

      public  void run() throws Exception{
          
          ServerSocket serverSocket = new ServerSocket(555);
          Socket sock = serverSocket.accept();
          InputStreamReader inputReader = new InputStreamReader(sock.getInputStream());
          BufferedReader bufferedReader = new BufferedReader(inputReader);
          
          String message = bufferedReader.readLine();
          System.err.println("Client : "+message);
          
          if(message != null){
              PrintStream printStream = new PrintStream(sock.getOutputStream());
              printStream.println("Message Recieved");
          }

      } 
    
    
}
