package circular_queue;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchInCricularQueue {


	public static int searchInCircularQueue(int[] arr, int target) {
			int low = 0, high = arr.length - 1;
			
			while (low <= high) {
					int mid = low + (high - low) / 2;
					
					if (arr[mid] == target) {
						return mid;
					}
		
					if (arr[low] <= arr[mid]) {
						if (arr[low] <= target && target < arr[mid]) {
							high = mid - 1;
						} else {
								low = mid + 1;
							}
					} else {
							if (arr[mid] < target && target <= arr[high]) {
								low = mid + 1;
							} else {
								high = mid - 1;
							}
					}
			}
			return -1;
		}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int[] circularQueue = { 4, 5, 6, 7, 0, 1, 2 };
		
		System.out.println("Circular Queue: " + 
	Arrays.toString(circularQueue));
		
		System.out.print("Enter the Target Value: ");
		int target = sc.nextInt();
		
		int result = searchInCircularQueue(circularQueue, target);
		if (result != -1) {
		System.out.println("Element " + target + " found at index: " + 
	result);
		} else {
		System.out.println("Element " + target + " not found in the "
+ "circular queue.");
			}
			sc.close();
		}

}
