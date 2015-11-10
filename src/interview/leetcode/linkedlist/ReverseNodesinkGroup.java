package interview.leetcode.linkedlist;

import interview.leetcode.ListNode;

public class ReverseNodesinkGroup {

	/**
	 * Given a linked list, reverse the nodes of a linked list k at a time and
	 * return its modified list.
	 * 
	 * If the number of nodes is not a multiple of k then left-out nodes in the
	 * end should remain as it is.
	 * 
	 * You may not alter the values in the nodes, only nodes itself may be
	 * changed.
	 * 
	 * Only constant memory is allowed.
	 * 
	 * For example, Given this linked list: 1->2->3->4->5
	 * 
	 * For k = 2, you should return: 2->1->4->3->5
	 * 
	 * For k = 3, you should return: 3->2->1->4->5
	 */

    public ListNode reverseKGroup3(ListNode head, int k) {
        
        if(k==1)
            return head;
            
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode p=dummy;
        ListNode q=dummy;
        
        while(p!=null){
            for(int i=0;i<k+1;i++){
                if(p==null)
                    return dummy.next;
                p=p.next;
            }
            
            q=reverse3(q, p);
            p=q;
        }
        return dummy.next;
    }
    
    
    ListNode reverse3(ListNode pre, ListNode stoper){
        ListNode dummy=pre;
        ListNode r=dummy;
        
        ListNode first=pre.next;
        ListNode p=first;
        while(p!=stoper){
            ListNode t1=r.next;
            r.next=p;
            
            ListNode t2=p.next;
            p.next=t1;
            p=t2;
        }
        
        first.next=stoper;
        return first;
    }
    
    
    
    
    public ListNode reverseKGroup2(ListNode head, int k) {
        if(head == null || head.next == null || k==1) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode last = dummy;
        
        while(p!=null){
            int i=0;
            while(p!=null && i<k){
                p=p.next;
                i++;
            }

            if(i==k && p!=null){
            	last = reverse2(last, p.next);
            	p = last;
            }
        }
        return dummy.next;
    }
    
    
    private ListNode reverse2(ListNode pre, ListNode stopper){
        
    	ListNode first = pre.next;
        for(ListNode cur=pre.next.next; cur!=stopper; ){
            ListNode temp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            first.next = temp;
            cur = temp;
        }
        
        return first;
        
    }
    
    



    
    

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k < 2)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		for (ListNode prev = dummy, end = head; end != null; end = prev.next) {
			for (int i = 1; i < k && end != null; i++)
				end = end.next;
			if (end == null)
				break; // not reach k
			prev = reverse(prev, end);
		}
		return dummy.next;
	}

	// prev in the ele before first, [begin, end] is close area,none of the
	// three is null
	// return the first ele after reverse
	public ListNode reverse(ListNode prev, ListNode end) {
		ListNode begin = prev.next;
		ListNode endNext = end.next;
		for (ListNode p = begin, cur = p.next, next = cur.next;
				cur != endNext;
				p = cur, cur = next, next = (next != null ? next.next : null)) {
			
			cur.next = p;
		}
		begin.next = endNext;
		prev.next = end;
		return begin;
	}


}
