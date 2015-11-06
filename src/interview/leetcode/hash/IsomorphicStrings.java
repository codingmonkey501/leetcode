package interview.leetcode.hash;


public class IsomorphicStrings {

	/**
	 * Given two strings s and t, determine if they are isomorphic.

		Two strings are isomorphic if the characters in s can be replaced to get t.
		
		All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
		
		For example,
		Given "egg", "add", return true.
		
		Given "foo", "bar", return false.
		
		Given "paper", "title", return true.
		
		Note:
		You may assume both s and t have the same length.
	 */
	
	public boolean isIsomorphic(String s, String t) {

		if (s.length() != t.length())
			return false;

		int[] mp = new int[255];
		int[] mp1 = new int[255];

		// ASKII 0 = NUL
		for (int i = 0; i < s.length(); ++i) {
			int sc = s.charAt(i);
			int tc = t.charAt(i);

			if (mp[sc] == 0 && mp1[tc] == 0) {
				mp[sc] = tc;
				mp1[tc] = sc;
			} else if (mp[sc] != tc || mp1[tc] != sc) {
				return false;
			}
		}

		return true;
	}
}
