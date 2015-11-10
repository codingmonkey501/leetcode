package interview.leetcode.linkedlist;

import interview.leetcode.ListNode;


public class ReverseLinkedListII {

	/**
	 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

		For example:
		Given 1->2->3->4->5->NULL, m = 2 and n = 4,
		
		return 1->4->3->2->5->NULL.
		
		Note:
		Given m, n satisfy the following condition:
		1 ≤ m ≤ n ≤ length of list.
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode p = dummy;

		for (int i = 1; i < m; i++)
			p = p.next;

		ListNode pre = p;
		ListNode first = pre.next;
		for (int i = 0; i < n - m; i++) {
			ListNode insertNode = first.next;
			first.next = insertNode.next;
			ListNode temp = pre.next;
			pre.next = insertNode;
			insertNode.next = temp;
		}

		return dummy.next;
	}
	
}
