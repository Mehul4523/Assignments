package networking_serialization;

import java.io.Serializable;

class CalculationRequest implements Serializable { 
	 private static final long serialVersionUID = 1L; 
	 int number1; 
	 int number2; 
	 String operation; 
	 
	 CalculationRequest(int number1, int number2, String operation) { 
	  this.number1 = number1; 
	  this.number2 = number2; 
	  this.operation = operation; 
	 } 
} 

