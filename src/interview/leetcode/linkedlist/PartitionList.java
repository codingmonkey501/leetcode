package interview.leetcode.linkedlist;

import interview.leetcode.ListNode;

public class PartitionList {

	
	/**
	 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

		You should preserve the original relative order of the nodes in each of the two partitions.
		
		For example,
		Given 1->4->3->2->5->2 and x = 3,
		return 1->2->2->4->3->5.
	 */
	
    public ListNode partition3(ListNode head, int x) {

        if(head == null) return null;        
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        
        ListNode p = head;
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        while(p!=null){
            if(p.val < x){
                p1.next = p;
                p1 = p1.next;
            }
            else if(p.val>=x) {
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
        }
        
        p2.next = null;
        p1.next = dummy2.next;
        
        return dummy1.next;
    }
	
	
	
	// what preserve nodes order means?
	public ListNode partition(ListNode head, int x) {

		ListNode dummyheadleft = new ListNode(Integer.MIN_VALUE);
		ListNode dummyheadright = new ListNode(Integer.MAX_VALUE);
		ListNode p = head;
		ListNode pleft = dummyheadleft;
		ListNode pright = dummyheadright;
		while (p != null) {
			ListNode tmp = p.next;
			p.next = null; // wrong here
			if (p.val < x) {// wrong here should not be <=
				pleft.next = p;
				pleft = pleft.next;
			} else {
				pright.next = p;
				pright = pright.next;
			}
			p = tmp;
		}
		if (pleft != null)// wrong here
			pleft.next = dummyheadright.next;
		else
			dummyheadleft.next = dummyheadright.next;
		return dummyheadleft.next;
	}
	
	
	
    public ListNode partition4(ListNode head, int x) {

        if(head == null) return null;        
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode dummy3 = new ListNode(-1);
        
        ListNode p = head;
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p3 = dummy3;
        while(p!=null){
            if(p.val < x){
                p1.next = p;
                p1 = p1.next;
            }
            else if(p.val>x) {
                p2.next = p;
                p2 = p2.next;
            }
            else if(p.val == x){
                p3.next = p;
                p3= p3.next;
            }
            p = p.next;
        }
        
        p2.next = null;
        p3.next = dummy2.next;
        p1.next = dummy3.next;
        
        return dummy1.next;
        
        
    }
	
	

}
