package interview.leetcode.hash;

import java.util.HashSet;
import java.util.Set;


public class HappyNumber {

	/**
	 * Write an algorithm to determine if a number is "happy".

		A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
		
		Example: 19 is a happy number
		
		12 + 92 = 82
		82 + 22 = 68
		62 + 82 = 100
		12 + 02 + 02 = 1
	 */
	
	
	public boolean isHappy(int n) {

		Set<Integer> numSet = new HashSet<Integer>();
		while (n != 1 && !numSet.contains(n)) {
			numSet.add(n);
			int sum = 0;
			while (n != 0) {
				int digit = n % 10;
				sum += digit * digit;
				n /= 10;
			}
			n = sum;
		}

		return n == 1;
	}
}
