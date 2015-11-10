package interview.leetcode.greedy;


public class JumpGameII {

	
	/**
	 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

		Each element in the array represents your maximum jump length at that position.
		
		Your goal is to reach the last index in the minimum number of jumps.
		
		For example:
		Given array A = [2,3,1,1,4]
		
		The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
	 */
	
	
	public int jump3(int[] A) {

		if (A.length == 1)
			return 0;

		int max = A[0];
		int jump = 0;
		int futuremax = 0;

		for (int i = 0; i < A.length && i <= max; i++) {
			futuremax = Math.max(futuremax, A[i] + i);
			if (i == max || i == A.length - 1) {
				jump++;
				max = futuremax;
				futuremax = 0;
			}
		}

		return jump;

	}
	

	
	public int jump2(int[] A) {

		int jump = 0;
		// the maximum distance that has been reached
		int last = 0;
		// the maximum distance that can be reached by using "ret+1" steps
		int cur = 0;
		for (int i = 0; i < A.length; ++i) {
			if (i > last) {
				last = cur;
				jump++;
			}
			cur = Math.max(cur, i + A[i]);
		}
		return jump;
	}
	
	
	public int jump(int[] A) {

		int step = 0;
		int left = 0;
		int right = 0;
		if (A.length == 1)
			return 0;
		while (left <= right) {
			++step;
			int old_right = right;
			for (int i = left; i <= old_right; ++i) {
				int new_right = i + A[i];
				if (new_right >= A.length - 1)
					return step;
				if (new_right > right)
					right = new_right;
			}
			left = old_right + 1;
		}
		return 0;
	}


}
