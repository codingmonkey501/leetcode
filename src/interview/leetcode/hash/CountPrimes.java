package interview.leetcode.hash;

import java.util.HashSet;
import java.util.Set;


public class CountPrimes {

	/**
	 * Description:

		Count the number of prime numbers less than a non-negative number, n
		
		click to show more hints.
		
		References:
		How Many Primes Are There?
		
		Sieve of Eratosthenes
	 */
	
	//use hash set will exceed time
	public int countPrimes2(int n) {

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 2; i < n; i++) {
			set.add(i);
		}

		for (int i = 2; i < Math.sqrt(n); i++) {
			if (set.contains(i)) {
				for (int j = 2 * i; j < n; j += i) {
					set.remove(j);
				}
			}
		}
		return set.size();
	}

	// Sieve of Eratosthenes
	public int countPrimes(int n) {

		if (n <= 2)
			return 0;

		// init an array to track prime numbers
		boolean[] primes = new boolean[n];
		for (int i = 2; i < n; i++)
			primes[i] = true;

		for (int i = 2; i <= Math.sqrt(n - 1); i++) {
			// or for (int i = 2; i <= n-1; i++) {
			if (primes[i]) {
				for (int j = i + i; j < n; j += i)
					primes[j] = false;
			}
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}

		return count;
	}
}
