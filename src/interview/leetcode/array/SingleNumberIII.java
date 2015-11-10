package interview.leetcode.array;

public class SingleNumberIII {

	/**
	 * Given an array of integers, every element appears N times except for
	 * one. Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */

	public int singleNumber(int[] A, int times) {

		// 0001110
		// 00011100
		// 0001111
		// 00011111

		int res = 0;
		for (int i = 0; i < 32; i++) {
			int countOnes = 0;
			for (int j = 0; j < A.length; j++) {
				if ((A[j] & 0x01 << i) == 0x01 << i)
					countOnes++;
			}
			if (countOnes % times != 0)
				res |= 0x01 << i;
		}
		return res;
	}
	
	public static void main(String[] args) {

		int num = new SingleNumberIII().singleNumber(new int[] { 1, 1, 1, 1, 2, 2, 6, 6, 6, 6}, 4);
		System.out.println(num);
	}
	
}
