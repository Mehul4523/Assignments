package stacksorting;

import java.util.Stack;

public class StackSort {

	public static void sortStack(Stack<Integer> stack) {
			Stack<Integer> tempStack = new Stack<>();
		
			while (!stack.isEmpty()) {
				int temp = stack.pop();
		
			while (!tempStack.isEmpty() && tempStack.peek() < temp) {
				stack.push(tempStack.pop());
				}
				tempStack.push(temp);
			}
			
			while (!tempStack.isEmpty()) {
				stack.push(tempStack.pop());
			}
		}
		
		public static void printStack(Stack<Integer> stack) {
			for (Integer item : stack) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		
		public static void main(String[] args) {
			Stack<Integer> stack = new Stack<>();
		
			stack.push(32);
			stack.push(15);
			stack.push(41);
			stack.push(21);
			stack.push(56);
			stack.push(90);
			stack.push(26);
			stack.push(67);
			stack.push(85);
		
			System.out.println("Original stack:");
			printStack(stack);
		
			sortStack(stack);
			
			System.out.println("Sorted stack:");
			printStack(stack);
		}
}
