package interview.leetcode.linkedlist;

import interview.leetcode.ListNode;

public class RemoveDuplicatesfromSortedList {
	
	/**
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.

		For example,
		Given 1->1->2, return 1->2.
		Given 1->1->2->3->3, return 1->2->3.
	 */

	
	//easer to understand
	public ListNode deleteDuplicates3(ListNode head) {

		if (head == null)
			return null;
		ListNode q = head;
		ListNode p = head.next;

		while (p != null) {
			if (p.val == q.val) {
				q.next = p.next;
			} else {
				q = q.next;
			}
			p = p.next;
		}

		return head;

	}
	
	//concise way
	public ListNode deleteDuplicates(ListNode head) {

		if (head == null)
			return null;

		for (ListNode prev = head, curr = head.next; curr != null; curr = curr.next) {
			if (prev.val == curr.val) {
				prev.next = curr.next;
			} else {
				prev = curr;
			}
		}
		return head;
	}

	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null)
			return null;
		ListNode prev = head;
		ListNode curr = head.next;
		while (curr != null) {
			if (curr.val == prev.val) {
				prev.next = null;
			} else {
				prev.next = curr;
				prev = prev.next;
			}
			curr = curr.next;
		}
		return head;

		// 1
		// null
		// 1,1
		// 1,2
		// 1,1,2
		// 1,1,2,2
	}

}
