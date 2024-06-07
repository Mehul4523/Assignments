package merging_linkedlist;

public class MergeSortedLinkedList {
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				current.next = l1;
				l1 = l1.next;
			}
			else {
					current.next = l2;
					l2 = l2.next;
				}
			current = current.next;
		}
		
		if (l1 != null) {
			current.next = l1;
			} else {
				current.next = l2;
			}
		
			return dummy.next;
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
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
	
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		System.out.println("List 1:");
		printList(l1);
		
		System.out.println("List 2:");
		printList(l2);
		
		ListNode mergedHead = mergeTwoLists(l1, l2);
		
		System.out.println("Merged Sorted list:");
		printList(mergedHead);
		}


}
