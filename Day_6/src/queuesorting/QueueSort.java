package queuesorting;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueSort {

		public static void sortQueue(Queue<Integer> queue) {
			Stack<Integer> stack = new Stack<>();
			
			while (!queue.isEmpty()) {
				int temp = queue.poll();
				
				while (!stack.isEmpty() && stack.peek() < temp) {
					queue.add(stack.pop());
				}
				stack.push(temp);
			}
			
			while (!stack.isEmpty()) {
				queue.add(stack.pop());
			}
			
		}
			public static void printQueue(Queue<Integer> queue) {
				while (!queue.isEmpty()) {
					System.out.print(queue.poll() + " ");
				}
				System.out.println();
			}
			public static void main(String[] args) {
				Queue<Integer> queue = new LinkedList<Integer>();
				
					queue.add(48);
					queue.add(63);
					queue.add(41);
					queue.add(32);
					queue.add(19);
					queue.add(73);
					queue.add(56);
					queue.add(39);
					queue.add(17);
					queue.add(95);
					queue.add(8);
					
				System.out.println("Original Queue: ");
				printQueue(new LinkedList<Integer>(queue));
				
				sortQueue(queue);
				
				System.out.println("Sorted Queue: ");
				printQueue(queue);
			}

}
