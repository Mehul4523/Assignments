package linkedlist_mid_element_search;

public class SinglyLinkedList {

	public static ListNode findMiddle(ListNode head) {
			if (head == null)
				return null;
			ListNode slow = head;
			ListNode fast = head;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
			}
			public static void printMiddle(ListNode head) {
				ListNode mid = findMiddle(head);
				if (mid != null)
					System.out.println("Middle Element is :" + mid.val);
				else
					System.out.println("The List is Empty!");
			}
			public static void main(String[] args) {
				ListNode head = new ListNode(55);
				head.next = new ListNode(45);
				head.next.next = new ListNode(22);
				head.next.next.next = new ListNode(35);
				head.next.next.next.next = new ListNode(14);
				printMiddle(head);
			}
}
