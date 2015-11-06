package interview.leetcode.hash;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * Given a string, find the length of the longest substring without
	 * repeating characters. For example, the longest substring without
	 * repeating letters for "abcabcbb" is "abc", which the length is 3. For
	 * "bbbbb" the longest substring is "b", with the length of 1.
	 */
	
	public int lengthOfLongestSubstring4(String s) {

		int[] indexMap = new int[255];

		int last = 0;
		int max = 0;
		int length = 0;

		for (int i = 1; i < s.length() + 1; i++) {
			char c = s.charAt(i - 1);

			// "abba", "aab"
			if (indexMap[c] != 0 && indexMap[c] > last) {
				last = indexMap[c];
			}
			indexMap[c] = i;
			length = i - last;
			max = Math.max(max, length);
		}
		return max;
	}
	
	public int lengthOfLongestSubstring3(String s) {

		HashMap<Character, Integer> exist = new HashMap<Character, Integer>();
		int length = 0;
		int max = 0;
		int currStart = 0;
		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			if (!exist.containsKey(c)) {
				exist.put(c, i);
				length++;
			} else {

				if (exist.get(c) >= currStart) {
					length = i - exist.get(c);
					currStart = exist.get(c) + 1;
				} else {
					length++;
				}

				exist.put(c, i);
			}
			max = Math.max(max, length);
		}

		return max;
	}

	//greedy algorithm:
	// A greedy algorithm is an algorithm that follows the problem solving
	// heuristic of making the locally optimal choice at each stage with the
	// hope of finding a global optimum.
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> last = new HashMap<Character, Integer>();
		int start = 0;
		for (int i = 0; i < s.length(); i++)
			last.put(s.charAt(i), -1);

		int maxlen = 0;
		for (int i = 0; i < s.length(); i++) {
			if (last.get(s.charAt(i)) >= start) {
				maxlen = Math.max(i - start, maxlen);
				start = last.get(s.charAt(i)) + 1;
			}
			last.put(s.charAt(i), i);
		}
		return Math.max((int) s.length() - start, maxlen);
	}

	// only is alphabatic
	public int lengthOfLongestSubstring2(String s) {
		int ASCII_MAX = 26;
		int[] last = new int[ASCII_MAX];
		int start = 0;
		for (int i = 0; i < last.length; i++)
			last[i] = -1;

		int maxlen = 0;
		for (int i = 0; i < s.length(); i++) {
			if (last[s.charAt(i) - 'a'] >= start) {
				maxlen = Math.max(i - start, maxlen);
				start = last[s.charAt(i) - 'a'] + 1;
			}
			last[s.charAt(i) - 'a'] = i;
		}
		return Math.max((int) s.length() - start, maxlen);
	}
}
