package serialization;

import java.io.*; 

public class SerializationExample {
	  public static void main(String[] args) {
	    // Serialization
	    Persons person = new Persons("Mehul Anjikhane", 23);
	    String filename = "person.ser";

	    try (FileOutputStream fileOut = new FileOutputStream(filename);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
	      out.writeObject(person);
	    } catch (IOException i) {
	      i.printStackTrace();
	    }

	    // Deserialization
	    Persons deserializedPerson = null;
	    try (FileInputStream fileIn = new FileInputStream(filename);
	         ObjectInputStream in = new ObjectInputStream(fileIn)) {
	      deserializedPerson = (Persons) in.readObject();
	    } catch (IOException | ClassNotFoundException i) {
	      i.printStackTrace();
	    }

	    System.out.println("Deserialized Person: " + deserializedPerson);
	  }
	}
