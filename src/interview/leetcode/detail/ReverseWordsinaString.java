package interview.leetcode.detail;


public class ReverseWordsinaString {

	
	/**
	 * Given an input string, reverse the string word by word.

		For example,
		Given s = "the sky is blue",
		return "blue is sky the".
		
		click to show clarification.
		
		Clarification:
		What constitutes a word?
		A sequence of non-space characters constitutes a word.
		Could the input string contain leading or trailing spaces?
		Yes. However, your reversed string should not contain leading or trailing spaces.
		How about multiple spaces between two words?
		Reduce them to a single space in the reversed string.
	 */
	
    
	public String reverseWords(String s) {

		if (s.isEmpty() || s.length() == 0)
			return s;

		StringBuffer res = new StringBuffer();

		int t, h;
		for (int i = s.length() - 1; i >= 0; i--) {
			while (i >= 0 && s.charAt(i) == ' ')
				i--;

			// set tail pointer
			if (i < 0)
				break;
			t = i;
			h = t;

			// set head pointer
			while (i >= 0 && s.charAt(i) != ' ') {
				h = i;
				i--;
			}

			// append this word (append a space if find more than two words)
			if (h <= t && res.length() > 0)
				res.append(' ');
			
			for (int j = h; j <= t; j++) {
				res.append(s.charAt(j));
			}
		}

		return res.toString();
	}
    
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) {
			return "";
		}
 
		// split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}
