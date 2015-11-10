package interview.leetcode.linkedlist;

import interview.leetcode.ListNode;


public class RemoveDuplicatesfromSortedListII {

	
	/**
	 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

		For example,
		Given 1->2->3->3->4->4->5, return 1->2->5.
		Given 1->1->1->2->3, return 2->3.
	 */
	
	public ListNode deleteDuplicates3(ListNode head) {

		if (head == null)
			return null;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p1 = dummy;
		ListNode p2 = head;
		int dup = head.val;
		int i = 0;

		while (p2 != null) {
			if (p2.val != dup) {
				dup = p2.val;
				if (i > 1)
					p1.next = p2;
				else
					p1 = p1.next;
				i = 0;
			}
			p2 = p2.next;
			i++;
		}
		if (p1.next != null && i > 1)
			p1.next = null;
		return dummy.next;
	}
    
    
	public ListNode deleteDuplicates2(ListNode head) {

		if (head == null)
			return null;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode p1 = dummy;
		ListNode p2 = head;
		ListNode p3 = head.next;

		while (p3 != null) {

			if (p2.val == p3.val) {
				while (p3 != null && p3.val == p2.val) {
					p3 = p3.next;
				}

				p1.next = p3;
				if (p3 != null) {
					p2 = p3;
					p3 = p2.next;
				}
			} else {

				p3 = p3.next;
				p2 = p2.next;
				p1 = p1.next;

			}

		}

		return dummy.next;
	}

	//recusive way
	public ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode p = head.next;
		if (head.val == p.val) {
			while (p != null && head.val == p.val) {
				p = p.next;
			}
			head.next = null; //delete head
			return deleteDuplicates(p);
		} else {
			head.next = deleteDuplicates(head.next);
			return head;
		}
	}
	
}
