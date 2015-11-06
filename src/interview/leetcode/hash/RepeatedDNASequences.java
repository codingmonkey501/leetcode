package interview.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RepeatedDNASequences {

	/**
	 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

		Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
		
		For example,
		
		Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
		
		Return:
		["AAAAACCCCC", "CCCCCAAAAA"].
	 */
	
	public List<String> findRepeatedDnaSequences(String s) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<String> result = new ArrayList<String>();

		for (int i = 10; i <= s.length(); i++) {
			String str = s.substring(i - 10, i);
			int code = convert(str);

			if (map.containsKey(code)) {
				if (map.get(code) == 1)
					result.add(str);

				map.put(code, map.get(code) + 1);
			} else {
				map.put(code, 1);
			}
		}
		return result;
	}

	private int convert(String dna) {

		int value = 0;
		for (int i = 0; i < 10; ++i) {
			value <<= 2;
			if (dna.charAt(i) == 'A')
				value |= 0;
			else if (dna.charAt(i) == 'C')
				value |= 1;
			else if (dna.charAt(i) == 'G')
				value |= 2;
			else if (dna.charAt(i) == 'T')
				value |= 3;
		}
		return value;
	}
}
