package interview.leetcode.array;

public class RemoveDuplicatesfromSortedArrayII {

	/**
	 * 
	 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
	 * twice?
	 * 
	 * For example, Given sorted array A = [1,1,1,2,2,3],
	 * 
	 * Your function should return length = 5, and A is now [1,1,2,2,3].
	 * 
	 */
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArrayII r=new RemoveDuplicatesfromSortedArrayII();
		r.removeDuplicates(new int[]{1,1,1});
		r.removeDuplicates(new int[]{1,1,1,2,2,3});
	}
	
	
	// concise way
	public int removeDuplicates(int[] A) {

		if (A.length <= 2)
			return A.length;
		int index = 2;
		for (int i = 2; i < A.length; i++) {
			if (A[index - 2] != A[i])
				A[index++] = A[i];
		}
		return index;
	}

}
