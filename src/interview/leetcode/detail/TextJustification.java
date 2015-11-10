package interview.leetcode.detail;

import java.util.ArrayList;
import java.util.List;


public class TextJustification {

	
	/**
	 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

			You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
			
			Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
			
			For the last line of text, it should be left justified and no extra space is inserted between words.
			
			For example,
			words: ["This", "is", "an", "example", "of", "text", "justification."]
			L: 16.
			
			Return the formatted lines as:
			[
			   "This    is    an",
			   "example  of text",
			   "justification.  "
			]
			Note: Each word is guaranteed not to exceed L in length.
			
			click to show corner cases.
			
			Corner Cases:
			A line other than the last line might contain only one word. What should you do in this case?
			In this case, that line should be left-justified.
	 */
	
	public List<String> fullJustify(String[] words, int L) {

		List<String> result = new ArrayList<String>();
		int begin = 0, wordsLen = 0;

		for (int i = 0; i < words.length; ++i) {
			int spaces = i - begin;
			int currWordLen = words[i].length();
			if (wordsLen + currWordLen + spaces > L) {
				result.add(this.connect(words, begin, i - 1, wordsLen, L, false));
				begin = i;
				wordsLen = 0;
			}
			wordsLen += currWordLen;
		}
		result.add(connect(words, begin, words.length - 1, wordsLen, L, true));
		return result;
	}

	private String connect(String[] words, int begin, int end, int len, int L, boolean isLast) {

		StringBuffer s = new StringBuffer();
		int numOfWords = end - begin + 1;
		for (int i = 0; i < numOfWords; ++i) {
			s.append(words[begin + i]);
			addSpaces(s, i, numOfWords - 1, L - len, isLast);
		}
		if (s.length() < L) {
			for (int spaces = L - s.length(); spaces > 0; spaces--)
				s.append(' ');
		}
		return s.toString();
	}

	void addSpaces(StringBuffer s, int i, int n, int L, boolean isLast) {

		if (n < 1 || i > n - 1)
			return;
		int spaces = isLast ? 1 : (L / n + (i < (L % n) ? 1 : 0));
		for (; spaces > 0; spaces--) {
			s.append(' ');
		}
	}
}
