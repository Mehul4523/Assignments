package removing_duplicates;

import java.util.LinkedList;

public class RemoveDuplicates {
	
	public static void removeDuplicates(ListNode head) {
		 if (head == null) return;
		 ListNode current = head;
		
		 while (current != null && current.next != null) {
			 if (current.val == current.next.val) {
				 current.next = current.next.next;
			 }
			 else {
				 	current = current.next;
			 	}
		 	}
		 }
		 
	public static void printList(ListNode head) {
		 ListNode current = head;
	
		 
		 while (current != null) {
			 System.out.print(current.val + " ");
			 current = current.next;
		 	}
		 	System.out.println();
		 }
		 
	public static void main(String[] args) {
		 ListNode head = new ListNode(10);
	
		 head.next = new ListNode(10);
		 head.next.next = new ListNode(21);
		 head.next.next.next = new ListNode(13);
		 head.next.next.next.next = new ListNode(13);
		 
		 System.out.println("Original list:");
		 printList(head);
		 
		 removeDuplicates(head);
		 
		 System.out.println("List after removing duplicates:");
		 printList(head);
		 }
	
}
