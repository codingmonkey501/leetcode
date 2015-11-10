package interview.leetcode.linkedlist;

import interview.leetcode.linkedlist.AddTwoNumbers.ListNode;

public class ReorderList {

	
	/**
	  Given a singly linked list L: L0→L1→…→Ln-1→Ln,
		reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
		
		You must do this in-place without altering the nodes' values.
		
		For example,
		Given {1,2,3,4}, reorder it to {1,4,2,3}.
	*/
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		new ReorderList().reorderList3(n1);
		ListNode p = n1;
		while(p!=null){
			System.out.println(p.val);
			p = p.next;
		}
			
	}
	
	
	public void reorderList3(ListNode head) {

		if (head == null || head.next == null)
			return;

		ListNode slow = head;
		ListNode fast = head;

		// find middle and split
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode first = head;
		ListNode second = slow.next;
		slow.next = null;

		// reverse
		second = reverse3(second);

		// merge two lists
		while (second != null) {
			ListNode tmp = first.next;
			first.next = second;
			second = second.next;
			first.next.next = tmp;
			first = first.next.next;
		}
	}

	private ListNode reverse3(ListNode head) {

		ListNode dummy = new ListNode(-1);
		for (ListNode n = head; n != null;) {
			ListNode tmp = dummy.next;
			dummy.next = n;
			n = n.next;
			dummy.next.next = tmp;
		}
		return dummy.next;
	}
	
	
	
	public void reorderList1(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode slow = head, fast = head, prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null; // cut at middle
		
		slow = reverse1(slow);
		
		// merge two lists
		ListNode curr = head;
		while (curr.next != null) {
			ListNode tmp = curr.next;
			curr.next = slow;
			slow = slow.next;
			curr.next.next = tmp;
			curr = tmp;
		}
		curr.next = slow;
	}

	private ListNode reverse1(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prev = head;
		for (ListNode curr = head.next, next = curr.next; curr != null; prev = curr, curr = next, next = (next != null ? next.next
				: null)) {
			curr.next = prev;
		}
		head.next = null;
		return prev;
	}

}
