package algorithms;

import java.util.Arrays;

public class UniqueElementsIdentificationUsing_BitwiseXOR {

	// Find two unique elements using XOR
	public static void findUniqueElements(int[] arr) {
		int xor = 0;
		for (int num : arr) {
				xor ^= num;
		}
	
		// Get the rightmost set bit in XOR 
//(separates numbers with different LSBs)
		int rightmostSetBit = xor & ~(xor - 1);
		
		int unique1 = 0, unique2 = 0;
		for (int num : arr) {// If the rightmost set bit of num and 
//rightmostSetBit are the same, add num to unique1
			if ((num & rightmostSetBit) != 0) {
					unique1 ^= num;
			} else {
					unique2 ^= num;
			}
		}
		
		System.out.println("Unique Elements: " + unique1 + ", " + unique2);
	}
	
	public static void main(String[] args) {
		int[] arr = { 7, 3, 5, 4, 5, 3, 7, 1 };
		System.out.println("Given Array: " + Arrays.toString(arr));
		findUniqueElements(arr);
	}
}

