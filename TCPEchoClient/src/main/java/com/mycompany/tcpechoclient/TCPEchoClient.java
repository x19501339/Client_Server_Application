
package com.mycompany.tcpechoclient;
import java.io.*;
import java.net.*;

/**
 *
 * @author x19501339
 */
public class TCPEchoClient {
 private static InetAddress host;
    private static final int PORT = 1234;

    public static void main(String[] args) {
     try 
     {
        host = InetAddress.getLocalHost();
     } 
     catch(UnknownHostException e) 
     {
	System.out.println("Host ID not found!");
	System.exit(1);
     }
     run();
   }
    
   private static void run() {
    Socket link = null;				
    try 
    {
	link = new Socket(host,PORT);		
        
	BufferedReader in = new BufferedReader(new InputStreamReader(link.getInputStream()));
	PrintWriter out = new PrintWriter(link.getOutputStream(),true);	 

	
	BufferedReader userEntry =new BufferedReader(new InputStreamReader(System.in));
	String message = null;
        String response= null;
        
	do{
            System.out.println("Enter message to be sent to server: ");
            message =  userEntry.readLine();
            out.println(message); 		
            response = in.readLine();		
            System.out.println("\nSERVER RESPONSE> " + response);
        }while (!message.equals("STOP"));     
    } 
    catch(IOException e)
    {
	e.printStackTrace();
    } 
    finally 
    {
        try 
        {
            System.out.println("\n* Closing connection... *");
            link.close();				
	}catch(IOException e)
        {
            System.out.println("Unable to disconnect/close!");
            System.exit(1);
	}
    }
 } 
}  
