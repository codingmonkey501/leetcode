package interview.leetcode.linkedlist;

import interview.leetcode.ListNode;

public class RemoveNthNodeFromEndofList {

	
	/**
	 * Given a linked list, remove the nth node from the end of list and return its head.

		For example,
		
		   Given linked list: 1->2->3->4->5, and n = 2.
		
		   After removing the second node from the end, the linked list becomes 1->2->3->5.
		Note:
		Given n will always be valid.
		Try to do this in one pass.
	 */

	public ListNode removeNthFromEnd2(ListNode head, int n) {

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p1 = dummy;
		for (int i = 0; i < n + 1; i++) {
			p1 = p1.next;
		}
		ListNode p2 = dummy;
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		p2.next = p2.next.next;
		return dummy.next;
	}
    
	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode pre = head, cur = head;
		int step = 0;
		while (step < n && cur != null) {
			cur = cur.next;
			step++;
		}
		if (step == n && cur == null) {
			head = head.next;
			return head;
		}
		while (cur.next != null) {
			pre = pre.next;
			cur = cur.next;
		}
		ListNode temp = pre.next;
		pre.next = temp.next;
		return head;
	}

	
}
