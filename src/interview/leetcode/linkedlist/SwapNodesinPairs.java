package interview.leetcode.linkedlist;

public class SwapNodesinPairs {

	/**
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * Your algorithm should use only constant space. You may not modify the
	 * values in the list, only nodes itself can be changed.
	 */
	
	public ListNode swapPairs4(ListNode head) {

		// dummy to hold head
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p = dummy;

		// even number of nodes
		// odd number of nodes
		while (p.next != null && p.next.next != null) {
			// swap n1 and n2
			ListNode n1 = p.next;
			ListNode n2 = p.next.next;

			p.next = n2;
			n1.next = n2.next;
			n2.next = n1;

			p = p.next.next;
		}

		return dummy.next;

	}
	
	public ListNode swapPairs2(ListNode head) {
        
        if(head==null) return null;
        
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode p1 = dummy;
        ListNode p2 = head;
        ListNode p3 = head.next;
        
        while(p3!=null){
            
            p1.next = p3;
            p2.next = p3.next;
            p3.next = p2;
            
            p1 = p2;
            p2 = p1.next;
            if(p2 == null) break;
            p3 = p2.next;
            
        }
        
        return dummy.next;
    }

	
	
	public ListNode swapPairs(ListNode head) {

		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		for (ListNode prev = dummy, cur = prev.next, next = cur.next; 
				next != null; 
				prev = cur, cur = cur.next, next = (cur != null ? cur.next : null)) {
			prev.next = next;
			cur.next = next.next;
			next.next = cur;
		}
		return dummy.next;
	}

	public ListNode swapPairs1(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode newHead = head.next;
		ListNode curr = head;
		ListNode next = head.next;

		while (next != null) {
			curr.next = next.next;
			next.next = curr;
			ListNode joinpoint = curr; // forget to link the joinpoint between
										// the two nodes
			curr = curr.next;
			if (curr == null)
				break;
			next = curr.next;
			if (next != null)
				joinpoint.next = next; // need to check next!=null when [1,2,3]
		}

		return newHead;
	}
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
