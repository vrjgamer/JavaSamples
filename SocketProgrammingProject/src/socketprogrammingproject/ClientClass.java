package socketprogrammingproject;

import java.io.*;
import java.net.*;

public class ClientClass {

  public static void main(String[] args) throws Exception{
        ClientClass clientClass = new ClientClass();
        clientClass.run();
    }

   public  void run() throws Exception{
          Socket sock = new Socket("localhost", 555);
          InputStreamReader inputReader = new InputStreamReader(sock.getInputStream());
          BufferedReader bufferedReader = new BufferedReader(inputReader);
          
          PrintStream printStream = new PrintStream(sock.getOutputStream());
          printStream.println("Hello Server");
   
          String message = bufferedReader.readLine();
          System.err.println("Server : "+message);
        
      } 
}
