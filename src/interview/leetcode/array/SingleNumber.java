package interview.leetcode.array;

public class SingleNumber {

	/**
	 * Given an array of integers, every element appears twice except for one.
	 * Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */
	
	
	public int singleNumber(int[] A) {

		int x = 0;
		for (int i = 0; i < A.length; ++i)
			x ^= A[i];
		return x;
	}

	public int singleNumber1(int[] A) {

		int res = 0;
		for (int j = 0; j < 32; j++) {
			int countOnes = 0;
			for (int i = 0; i < A.length; i++) {
				if ((A[j] & 0x01 << i) == 0x01 << i)
					countOnes++;
			}
			if (countOnes % 2 != 0)
				res = res | (1 << j);

		}
		return res;
	}

	public static void main(String[] args) {

		int num = new SingleNumber().singleNumber(new int[] { 1, 65535, 1, 2, 2, 7, 65535 });
		System.out.println(num);
	}
}
