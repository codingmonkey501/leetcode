package interview.leetcode.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	
	/**
	 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

		For example, given
		s = "leetcode",
		dict = ["leet", "code"].
		
		Return true because "leetcode" can be segmented as "leet code".
	 */
	public static void main(String[] args) {

		String s = "aaaaaaa";
		Set<String> dict = new HashSet<String>();
		dict.add("aaaa");
		dict.add("aa");
		WordBreak w = new WordBreak();
		System.out.println(w.wordBreak2(s, dict));
	}
	
	
	// O(n^2) dynamic programming
	// f[i] mean form 0 to i, is it can be work break
	public boolean wordBreak1(String s, Set<String> dict) {

		boolean[] f = new boolean[s.length() + 1];
		for (int i = 1; i < s.length() + 1; i++)
			f[i] = false;
		f[0] = true;

		// if s(0,j) can be work break and s(j,i) can be work break, then from
		// s(0,i) can be work break.
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (f[j] && dict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}
		return f[s.length()];
	}
	
	// time limit exceed
	// .......... O(2^n)............ O(n)
	public boolean wordBreak2(String s, Set<String> dict) {

		String match = "";
		int i = 0;
		boolean segmented = false;
		for (String rest = s; i < rest.length(); i++) {
			match += rest.charAt(i);
			if (dict.contains(match)) {
				if (i + 1 == rest.length())
					return true;
				rest = rest.substring(i + 1, rest.length());
				segmented |= wordBreak2(rest, dict);

			}
		}
		return segmented;
	}
	
	// DFS not good time limit exeed, but easier to understand
	public boolean wordBreak(String s, Set<String> dict) {

		return dfs(s, dict, 0, 0);
	}

	private boolean dfs(String s, Set<String> dict, int start, int cur) {

		if (cur == s.length()) {
			return dict.contains(s.substring(start, cur));
		}
		if (dfs(s, dict, start, cur + 1))
			return true;
		if (dict.contains(s.substring(start, cur)))
			if (dfs(s, dict, cur, cur + 1))
				return true;
		return false;
	}


	


	

}
