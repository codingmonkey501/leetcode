package interview.leetcode.linkedlist;

public class CopyListwithRandomPointer {

	/**
	 * A linked list is given such that each node contains an additional random
	 * pointer which could point to any node in the list or null. Return a deep
	 * copy of the list.
	 */

	//solution 1, can you use hashmap?
	
	//solution 2
    public RandomListNode copyRandomList2(RandomListNode head) {
        
        if(head==null) return null;
        
        RandomListNode p = head;
        
        while (p!=null){
            
            RandomListNode node = new RandomListNode(p.label);
            
            RandomListNode temp = p.next;
            p.next = node;
            node.next = temp;
            
            p = p.next.next;
        }
        
        p = head;
        while (p!=null){
            
            if(p.random != null) {
                //link random
                RandomListNode pointTo = p.random;
                RandomListNode first = p.next;
                RandomListNode second = pointTo.next;
                first.random = second;
            }
            
            p = p.next.next;
        }
        
        //break
        p = head;
        RandomListNode res = head.next;
        RandomListNode p2 = head.next;
        while (p!=null){
            
            p.next = p.next.next;
            if(p2.next==null) break;
            p2.next = p2.next.next;
            
            p = p.next;
            p2 = p2.next;
        }
        return res;
    }





    
    

	public RandomListNode copyRandomList(RandomListNode head) {
		
		//add in between
		for (RandomListNode cur = head; cur != null;) {
			RandomListNode node = new RandomListNode(cur.label);
			node.next = cur.next;
			cur.next = node;
			cur = node.next;
		}

		//copy random
		for (RandomListNode cur = head; cur != null;) {
			if (cur.random != null)
				cur.next.random = cur.random.next;
			cur = cur.next.next;
		}

		//seperate two list
		RandomListNode dummy = new RandomListNode(-1);

		for (RandomListNode cur = head, newcur = dummy; cur != null;) {
			newcur.next = cur.next;
			newcur = newcur.next;
			cur.next = cur.next.next;
			cur = cur.next;
		}
		return dummy.next;
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}