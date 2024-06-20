package networking_serialization;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	try (ServerSocket serverSocket = new ServerSocket(9090)) { 
    		   System.out.println("Server is listening on port 9090"); 
    		 
    		   while (true) { 
    		    Socket socket = serverSocket.accept(); 
    		    new CalculationHandler(socket).start(); 
    		   } 
    		  } catch (IOException ex) { 
    		   ex.printStackTrace(); 
    		 } 
    	} 
  } 
    		 
    		
