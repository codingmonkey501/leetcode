package interview.leetcode.binarysearch;

public class SearchinRotatedSortedArrayII {

	
	/**
	 * Follow up for "Search in Rotated Sorted Array":
		What if duplicates are allowed?
		
		Would this affect the run-time complexity? How and why?
		
		Write a function to determine if a given target is in the array.
	 */
	
	// two ways to mark the right end, result will be same
	
	public boolean search(int A[], int target) {

		int s = 0;
		int e = A.length - 1;

		while (s <= e) {
			int m = s + (e - s) / 2;
			if (A[m] == target)
				return true; // return m in Search in Rotated Array I
			if (A[s] < A[m]) { // left half is sorted
				if (A[s] <= target && target < A[m])
					e = m - 1;
				else
					s = m + 1;
			} else if (A[s] > A[m]) { // right half is sorted
				if (A[m] < target && target <= A[e])
					s = m + 1;
				else
					e = m - 1;
			} else
				s++;
		}
		return false;
	}
	
	public boolean search2(int A[], int target) {

		int s = 0, e = A.length;
		while (s != e) {
			int m = (s + e) / 2;
			if (A[m] == target)
				return true;
			if (A[s] < A[m]) {
				if (A[s] <= target && target < A[m])
					e = m;
				else
					s = m + 1;
			} else if (A[s] > A[m]) {
				if (A[m] < target && target <= A[e - 1])
					s = m + 1;
				else
					e = m;
			} else
				// skip duplicate one
				s++;
		}
		return false;
	}
		


}
