package networking_serialization;

import java.io.*; 
import java.net.*; 
 
public class CalculationClient { 
 public static void main(String[] args) { 
  String hostname = "localhost"; 
  int port = 1234; 
 
  CalculationRequest request = new CalculationRequest(2, 2, "+"); 
 
  try (Socket socket = new Socket(hostname, port); 
    ObjectOutputStream out = new 
ObjectOutputStream(socket.getOutputStream()); 
    ObjectInputStream in = new 
ObjectInputStream(socket.getInputStream())) { 
 
   out.writeObject(request); 
   Object response = in.readObject(); 
 
   System.out.println("Result: " + response); 
  } catch (IOException | ClassNotFoundException ex) { 
   ex.printStackTrace(); 
  } 
 } 
}
