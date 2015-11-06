package interview.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {

	/**
	 * You are given a string, S, and a list of words, L, that are all of the
	 * same length. Find all starting indices of substring(s) in S that is a
	 * concatenation of each word in L exactly once and without any intervening
	 * characters.
	 * 		
	 * For example, given:
		S: "barfoothefoobarman"
		L: ["foo", "bar"]
		
		You should return the indices: [0,9].
		(order does not matter).
	 */

	
	public ArrayList<Integer> findSubstring(String S, String[] L) {

		int listLen = L.length;
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (listLen == 0)
			return result;
		int wordLen = L[0].length();
		int totalLen = wordLen * listLen;

		Map<String, Integer> wordsMap = new HashMap<String, Integer>();
		for (String string : L)
			this.addMap(wordsMap, string);

		for (int indice = 0; indice <= S.length() - totalLen; indice++) {

			Map<String, Integer> matchMap = new HashMap<String, Integer>();
			int pos = indice;
			for (; pos < indice + totalLen; pos += wordLen) {
				String subString = S.substring(pos, pos + wordLen);
				if (wordsMap.containsKey(subString)) {
					this.addMap(matchMap, subString);
					if (matchMap.get(subString) > wordsMap.get(subString))
						break;
				} else
					break;
			}
			if (pos == indice + totalLen)
				result.add(indice);
		}
		return result;
	}

	private void addMap(Map<String, Integer> map, String key) {

		if (map.containsKey(key))
			map.put(key, map.get(key) + 1);
		else
			map.put(key, 1);
	}
}
