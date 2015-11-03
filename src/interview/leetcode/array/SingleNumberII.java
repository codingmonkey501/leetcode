package interview.leetcode.array;

public class SingleNumberII {

	/**
	 * Given an array of integers, every element appears three times except for
	 * one. Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */

	public int singleNumber2(int[] A) {
        // 0001110
        // 00011100
        // 0001111
        // 00011111
        
        int res=0;
        for (int i=0; i<32; i++){
            int ones=0;
            for(int j=0; j<A.length; j++){
                if((A[j] & 0x01<<i) == 0x01<<i)
                    ones++;
            }
            if(ones%3!=0)
                res|=0x01<<i;
        }
        return res;
    }
	
	public int singleNumber(int[] A) {

		int result = 0;
		for (int i = 0; i < 32; i++) {
			int one = 0;
			for (int j = 0; j < A.length; j++) {
				int n = A[j];
				int mask = (1 << i); // forget to move left
				int bit = n & mask;
				if (bit == mask)
					one++; // check if equal to mask
			}
			if (one % 3 != 0)
				result = result | (1 << i);
		}
		return result;
	}

}
