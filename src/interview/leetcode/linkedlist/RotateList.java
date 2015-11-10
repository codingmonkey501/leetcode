package interview.leetcode.linkedlist;

import interview.careercup.Introduction.SwapInPlace;
import interview.leetcode.ListNode;

public class RotateList {

	/**
	 * Given a list, rotate the list to the right by k places, where k is
	 * non-negative.
	 * 
	 * For example: Given 1->2->3->4->5->NULL and k = 2, return
	 * 4->5->1->2->3->NULL.
	 */

	public ListNode rotateRight2(ListNode head, int n) {

		if (head == null)
			return head;

		ListNode p = head;
		while (p.next != null)
			p = p.next;
		p.next = head;

		ListNode p1 = head;
		ListNode p2 = head;
		for (int i = 0; i < n; i++) {
			p2 = p2.next;
		}

		while (p2 != p) {
			p1 = p1.next;
			p2 = p2.next;
		}

		head = p1.next;
		p1.next = null;
		return head;
	}


	
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null || n == 0)
			return head;

		ListNode endnode = head;
		int size = 1;
		while (endnode.next != null) {
			size++;
			endnode = endnode.next;
		}

		if (n % size == 0)
			return head;
		int k = size - n % size;

		ListNode p = head;
		endnode.next = head; // link head and endnode
		for (int i = 1; i < k; i++) {
			p = p.next;
		}
		head = p.next;
		p.next = null;
		return head;

		// ListNode pre=head;
		// for(int i=1;i<k;i++){ //attention here
		// pre=pre.next;
		// }
		// return rotateRight(pre, head); //attention here

	}

	// bad
	public ListNode rotateRight(ListNode n, ListNode head) {
		if (n.next == null)
			return head;
		ListNode newhead = rotateRight(n.next, head);
		ListNode tmp = n.next;
		n.next.next = newhead;
		n.next = null;
		return tmp;
	}
	
	/**
	 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
	 */
	
	public int[] rotateArray(int[] arr, int d) {

		for (int i = 0; i < arr.length - d; i++) {

			if (i - d < 0)
				SwapInPlace.swap(arr, i - d - arr.length, i);
			else if (i - d > 0)
				SwapInPlace.swap(arr, i - d, i);

		}
		return arr;
	}
	

}
