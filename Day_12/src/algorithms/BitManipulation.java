package algorithms;

public class BitManipulation {

		// Count set bits in an integer using Brian Kernighan's algorithm
		public static int countSetBits(int n) {
			int count = 0;
			while (n > 0) {
				// This operation resets the least significant set bit to 0
					n &= (n - 1); 
					count++;
			}
			return count;
		}
		
		// Count set bits in all integers from 1 to n (naive approach)
		public static int countSetBitsNaive(int n) {
			int totalSetBits = 0;
			for (int i = 1; i <= n; i++) {
				// Call the previous function for each number
				totalSetBits += countSetBits(i); 
			}
			return totalSetBits;
		}
		
		// Convert Decimal to Binary
		public static String decToBinary(int num) {
			if (num == 0) {
				return "0";
			}
			
			StringBuilder binary = new StringBuilder();
			while (num > 0) {
					int remainder = num % 2;
					binary.append(remainder);
					num /= 2;
			}
			return binary.reverse().toString();
		}
		
		public static void main(String[] args) {
			int number = 15;
			int setBits = countSetBits(number);
		
			System.out.println("Number: " + number + ", Binary Representation: " +
decToBinary(number));
			System.out.println("Number of set bits in " + number + ": " + setBits);
		
			int n = 5;
			int totalSetBits = countSetBitsNaive(n); // Not efficient for large n
			for (int i = 1; i <= n; i++) {
					System.out.println("Number: " + i + ", Binary Form: " +
decToBinary(i));
			}
			System.out.println("Total set bits from 1 to " + n + ": " +
totalSetBits);
		}
}
