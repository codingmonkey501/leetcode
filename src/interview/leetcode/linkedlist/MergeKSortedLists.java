package interview.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	/**
	 * Merge k sorted linked lists and return it as one sorted list. Analyze and
	 * describe its complexity.
	 */
	
    //O(log(k)*mn)
	public ListNode mergeKLists(ListNode[] lists) {

		if (lists.length == 0)
			return null;

		// PriorityQueue is a sorted queue
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			public int compare(ListNode a, ListNode b) {

				if (a.val > b.val)
					return 1;
				else if (a.val == b.val)
					return 0;
				else
					return -1;
			}
		});

		// add first node of each list to the queue
		for (ListNode list : lists) {
			if (list != null)
				q.add(list);
		}

		ListNode head = new ListNode(0);
		ListNode p = head; // serve as a pointer/cursor

		while (q.size() > 0) {
			ListNode temp = q.poll();
			// poll() retrieves and removes the head of the queue - q.
			p.next = temp;

			// keep adding next element of each list
			if (temp.next != null)
				q.add(temp.next);

			p = p.next;
		}

		return head.next;
	}
    
    
    //O(k^2*m)
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0)
			return null;
		if (lists.length == 1)
			return lists[0];

		ListNode first = lists[0];
		for (int i = 1; i < lists.length; i++) {
			ListNode second = lists[i];
            first = mergeTwoLists(first, second);
		}
		return first;
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        
        while(p1!=null && p2!=null){
            if(p1.val>p2.val){
                p.next=p2;
                p2 = p2.next;
            }else{
                p.next=p1;
                p1 = p1.next;
            }
            p=p.next;
        }
        
        while(p1!=null){
            p.next=p1;
            p1 = p1.next;
            p=p.next;
        }
        
        while(p2!=null){
            p.next=p2;
            p2 = p2.next;
            p=p.next;
        }
        
        return dummy.next;
    }
    

	// (1) time O(k*k*M) if triverse one by one and merge
	// (2) a better time O(k*k*m) also if merge first two and merge with the
	// third...
	public ListNode mergeKLists(ArrayList<ListNode> lists) {

		if (lists.size() == 0)
			return null;
		if (lists.size() == 1)
			return lists.get(0);

		ListNode first = lists.get(0);
		for (int i = 1; i < lists.size(); i++) {
			ListNode second = lists.get(i);
			

			if (first == null && second != null) {
				first = second; // in case of [{},{}]
				second = null;
			}
			if (second == null)
				continue;
			
			ListNode head = new ListNode(Integer.MIN_VALUE); //this make code clean
			ListNode p = head;

			while (first != null && second != null) {
				if (first.val > second.val) {
					p.next = second;
					second = second.next;
					p = p.next;
				} else {
					p.next = first;
					first = first.next;
					p = p.next;
				}
			}
			if (first != null)
				p.next = first;
			if (second != null)
				p.next = second;
			first = head.next; //do remember this
		}
		return first;
	}
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
