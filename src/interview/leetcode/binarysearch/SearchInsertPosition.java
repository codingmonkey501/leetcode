package interview.leetcode.binarysearch;

public class SearchInsertPosition {

	/**
	 * Given a sorted array and a target value, return the index if the target
	 * is found. If not, return the index where it would be if it were inserted
	 * in order.
	 * 
	 * You may assume no duplicates in the array.
	 * 
	 * Here are few examples. 
	 * [1,3,5,6], 5 → 2 
	 * [1,3,5,6], 2 → 1 
	 * [1,3,5,6], 7 → 4
	 * [1,3,5,6], 0 → 0
	 */
	
	public int searchInsert(int[] A, int target) {

		int s = 0;
		int e = A.length - 1;
		while (s <= e) {
			int m = (s + e) / 2;
			if (A[m] == target) {
				return m;
			} else if (target > A[m]) {
				s = m + 1;
			} else {
				e = m - 1;
			}
		}
		return s;
	}
    
	//recusive
	public int searchInsert(int[] A, int target, int start, int end) {

		int mid = (start + end) / 2;

		if (target == A[mid])
			return mid;
		else if (target < A[mid])
			return start < mid ? searchInsert(A, target, start, mid - 1) : start;
		else
			return end > mid ? searchInsert(A, target, mid + 1, end) : (end + 1);
	}
	
	//O(n)
	public int searchInsert2(int[] A, int target) {
        if(A==null) return -1;
        int i=0;
        while(target>A[i]){ //wrong here 
            i++;
            if(i==A.length) break;
        }
        return i;
    }
	

	
	
}
