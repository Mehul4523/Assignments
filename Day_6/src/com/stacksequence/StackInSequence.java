package com.stacksequence;

import java.util.Arrays;
import java.util.Stack;

public class StackInSequence {

	public static boolean isSequencePresent(Stack<Integer> stack, int[] 
sequence) {
			Stack<Integer> tempStack = new Stack<>();
			int index = sequence.length - 1;
			
			while (!stack.isEmpty()) {
				int element = stack.pop();
				if (element == sequence[index]) {
						index--;
				}
				tempStack.push(element);
			
				if (index < 0)
					break;
				}
			
			while (!tempStack.isEmpty()) {
				stack.push(tempStack.pop());
			}
			
			return index < 0;
		}
		
	public static void main(String[] args) {
			Stack<Integer> stack = new Stack<>();
	
			stack.push(1);
			stack.push(2);
			stack.push(3);
			stack.push(4);
			stack.push(5);
			stack.push(6);
			System.out.println("Orignal Stack: " + stack);
			
			int[] sequence1 = { 3, 4, 5 };
			System.out.println("Sequence: " + Arrays.toString(sequence1));
			System.out.println("Is the sequence present in the stack? " + 
	isSequencePresent(stack, sequence1));
		
			int[] sequence2 = { 5, 4, 1 };
			System.out.println("Sequence: " + Arrays.toString(sequence2));
			System.out.println("Is the sequence present in the stack? " + 
	isSequencePresent(stack, sequence2));
			}

}
