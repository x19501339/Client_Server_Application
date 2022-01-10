
package com.mycompany.tcpechoserver;
import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.ArrayList;

/**
 *
 * @author x19501339
 */
public class TCPEchoServer { 
  private static ServerSocket servSock;
  private static final int PORT = 1234;
  private static int clientConnections = 0;
  private static ArrayList<String> arraylist = new ArrayList<String>();

  public static void main(String[] args) {
    System.out.println("Opening port...\n");
    try 
    {
        servSock = new ServerSocket(PORT);      
    }
    catch(IOException e) 
    {
         System.out.println("Unable to attach to port!");
         System.exit(1);
    }
    
    do 
    {
         run();
    }while (true);

  }
  
  private static void run()
  {
    Socket link = null;                        
    try 
    {
      link = servSock.accept();    
      String message = in.readLine();
      String[] splitMessage = message.split(";");
        if (splitMessage[0].contains("add")){
            add(message);
            arraylist.add(message);
        }else if (splitMessage[0].contains("list")){
            //listing the array 
           for (int i = 0; i<splitMessage.length; i++){
               System.out.println(splitMessage[i]);
           }
         }else if (splitMessage[0].contains("remove")){
                      
         }
      
      clientConnections++;
      BufferedReader in = new BufferedReader( new InputStreamReader(link.getInputStream())); //Step 3.
      PrintWriter out = new PrintWriter(link.getOutputStream(),true); 
      
      String message = in.readLine();         
      System.out.println("Message received from client: " + clientConnections + "  "+ message);
      out.println("Echo Message: " + message);     
     }
    catch(IOException e)
    {
        e.printStackTrace();
    }
    finally 
    {
       try {
	    System.out.println("\n* Closing connection... *");
            link.close();				    
	}
       catch(IOException e)
       {
            System.out.println("Unable to disconnect!");
	    System.exit(1);
       }
    }
  } 
  
  public static void splitMessage(String message){
  
  }
  public static void add(String message){
      
  }
} 
