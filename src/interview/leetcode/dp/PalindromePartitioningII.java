package interview.leetcode.dp;


public class PalindromePartitioningII {

	
	/**
	 * Given a string s, partition s such that every substring of the partition is a palindrome.

		Return the minimum cuts needed for a palindrome partitioning of s.
		
		For example, given s = "aab",
		Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
	 */
	public static void main(String[] args) {

		System.out.println(new PalindromePartitioningII().minCut("aabaaa"));
		System.out.println(new PalindromePartitioningII().minCut("aab"));
	}
	
	
	//this is easier to understand than the way in longest palindrome
	public int minCut(String s) {

		int n = s.length();
		int[] f = new int[n + 1];
		boolean[][] p = new boolean[n][n]; // all false
		
		// the worst case is cutting by each char
		for (int i = 0; i <= n; i++)
			f[i] = n - 1 - i; // the last f[n]=-1
		
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				
				//P[i][j] = true if [i,j] is palindrome, then P[i][j] = str[i] == str[j] && P[i+1][j-1]
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || p[i + 1][j - 1])) {
					p[i][j] = true;
					f[i] = Math.min(f[i], f[j + 1] + 1);
				}
			}
		}
		return f[0];
	}
	
	//f(i; j) = min {f(i; k) + f(k + 1; j)} ; i < k < j; 0 < i < j < n
}
