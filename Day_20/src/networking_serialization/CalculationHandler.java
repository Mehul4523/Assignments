package networking_serialization;

import java.io.*; 
import java.net.*; 

class CalculationHandler extends Thread { 
	 private Socket socket; 
	 
	 public CalculationHandler(Socket socket) { 
	  this.socket = socket; 
	 } 
	 
	 public void run() { 
	  try (ObjectInputStream in = new 
	ObjectInputStream(socket.getInputStream()); 
	    ObjectOutputStream out = new 
	ObjectOutputStream(socket.getOutputStream())) { 
	 
		  CalculationRequest request = (CalculationRequest) 
	in.readObject(); 
	   int result = 0; 
	   
	   switch (request.operation) { 
	   case "+": 
	    result = request.number1 + request.number2; 
	    			break; 
	   
	   case "-": 
	    result = request.number1 - request.number2; 
	    			break; 
	   case "*": 
	    result = request.number1 * request.number2; 
	    			break; 
	   case "/": if (request.number2 != 0) { 
		   			result = request.number1 / request.number2; 
	    } else { 
	     out.writeObject("Error: Division by zero"); 
	     return; 
	    } 
	    break; 
	   default: 
	    out.writeObject("Error: Invalid operation"); 
	    return; 
	   } 
	 
	   out.writeObject(result); 
	  } catch (IOException | ClassNotFoundException ex) { 
	   ex.printStackTrace(); 
	  } 
	 } 
} 

