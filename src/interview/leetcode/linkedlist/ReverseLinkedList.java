package interview.leetcode.linkedlist;

import interview.leetcode.ListNode;


public class ReverseLinkedList {

	/**
	 * 
	 * Reverse a singly linked list.

		click to show more hints.
		
		Hint:
		A linked list can be reversed either iteratively or recursively. Could you implement both?
	 */
	
	public ListNode reverseList(ListNode head) {

		ListNode dummy = new ListNode(-1);
		ListNode p2 = head;
		while (p2 != null) {
			ListNode p1 = dummy.next;
			dummy.next = p2;
			p2 = p2.next;
			dummy.next.next = p1;
		}
		return dummy.next;
	}
	
}
