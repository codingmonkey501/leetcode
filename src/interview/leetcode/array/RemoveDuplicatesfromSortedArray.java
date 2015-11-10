package interview.leetcode.array;

public class RemoveDuplicatesfromSortedArray {

	/**
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 * 
	 * For example, Given input array A = [1,1,2],
	 * 
	 * Your function should return length = 2, and A is now [1,2].
	 */
	
	public static void main(String[] args) {
		new RemoveDuplicatesfromSortedArray().removeDuplicates(new int[]{1,1});
		new RemoveDuplicatesfromSortedArray().removeDuplicates(new int[]{1,1,2});
		new RemoveDuplicatesfromSortedArray().removeDuplicates(new int[]{1,1,2,2});
	}
	
	// concise way
	public int removeDuplicates(int[] A) {

		if (A == null)
			return 0;
		if (A.length == 0)
			return 0;
		if (A.length == 1)
			return 1;
		int index = 0;
		for (int i = 1; i < A.length; i++) { // start from 1
			if (A[index] != A[i])
				A[++index] = A[i]; // ++index
		}
		return index + 1;
	}


}
