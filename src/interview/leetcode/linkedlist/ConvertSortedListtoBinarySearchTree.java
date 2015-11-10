package interview.leetcode.linkedlist;

import interview.leetcode.TreeNode;


public class ConvertSortedListtoBinarySearchTree {
	/**
	  Given a singly linked list where elements are sorted in ascending order,
	  convert it to a height balanced BST.
	 */

	public static void main(String[] args) {

		ListNode n0 = new ListNode(0);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n0.next = n1;
		n1.next = n2;

		new ConvertSortedListtoBinarySearchTree().sortedListToBST(n0);
	}
	
	public TreeNode sortedListToBST3(ListNode head) {
        
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode r = slow.next;
        slow.next=null;
        TreeNode root = new TreeNode(r.val);
        
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(r.next);
        
        return root;
    }


	// O(log(n))
	public TreeNode sortedListToBST(ListNode head) {

		int len = 0;
		ListNode p = head;
		while (p != null) {
			len++;
			p = p.next;
		}
		return sortedListToBST(head, 0, len - 1);
	}

	private TreeNode sortedListToBST(ListNode list, int start, int end) {

		if (start > end)
			return null;
		int mid = start + (end - start) / 2;
		TreeNode leftChild = sortedListToBST(list, start, mid - 1);
		TreeNode parent = new TreeNode(list.val);
		parent.left = leftChild;
		list = list.next;
		parent.right = sortedListToBST(list, mid + 1, end);
		return parent;
	}
	
	//O(nlogn)
	public TreeNode sortedListToBST1(ListNode head) {
		return sortedListToBST(head, listLength(head));
	}

	private TreeNode sortedListToBST(ListNode head, int len) {
		if (len == 0)
			return null;
		if (len == 1)
			return new TreeNode(head.val);
		TreeNode root = new TreeNode(nthNode(head, len/2+1).val);
		root.left = sortedListToBST(head, len / 2);
		root.right = sortedListToBST(nthNode(head, len/2+2), (len - 1)/2);
		return root;
	}

	private int listLength(ListNode node) {
		int n = 0;
		while (node != null) {
			++n;
			node = node.next;
		}
		return n;
	}

	private ListNode nthNode(ListNode node, int n) {
		while (--n != 0)
			node = node.next;
		return node;
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
