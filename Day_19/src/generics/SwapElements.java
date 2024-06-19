package generics;

import java.util.Arrays;

public class SwapElements {


	  public static <T> void switchElements(T[] arr, int index1, int index2) { // Method names changed
	    T temp = arr[index1];
	    arr[index1] = arr[index2];
	    arr[index2] = temp;
	  }

	  public static void main(String[] args) {
	    String[] fruits = { "apple", "banana", "cherry" }; // Input data changed
	    System.out.println("Original fruits: " + String.join(", ", fruits));
	    switchElements(fruits, 0, 2);
	    System.out.println("Swapped fruits: " + String.join(", ", fruits));

	    Double[] weights = { 5.2, 7.1, 4.8 }; // Input data and type changed
	    System.out.println("Original weights: " + String.join(", ", Arrays.toString(weights)));
	    switchElements(weights, 1, 2);
	    System.out.println("Swapped weights: " + String.join(", ", Arrays.toString(weights)));
	  }
	}

