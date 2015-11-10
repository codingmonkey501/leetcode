package interview.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

	
	/**
	 * Given a digit string, return all possible letter combinations that the number could represent.

		A mapping of digit to letters (just like on the telephone buttons) is given below.
		
		Input:Digit string "23"
		Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
		Note:
		Although the above answer is in lexicographical order, your answer could be in any order you want.
	 */

	
    public List<String> letterCombinations2(String digits) {
        String[] str = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", };
        List<String> list = new ArrayList<String>();
        letterCombinations(str, digits, list, new char[digits.length()], 0);
        return list;
    }
    
    
    private void letterCombinations(String[] str, String digits, List<String> list, char[] path, int i){
        
        if(i == digits.length()){
            list.add(String.valueOf(path));
            return;
        }
        
        char c = digits.charAt(i);
        String s = str[c - '0'];
        
        for(int j=0; j<s.length(); j++){
            path[i] = s.charAt(j);
            letterCombinations(str, digits, list, path, i+1);
        }            
    }
    
    
	
	public ArrayList<String> letterCombinations(String digits) {
		// '0','1','2',... '9'
		String[] keyboard = new String[] { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ArrayList<String> result = new ArrayList<String>();
		dfs(digits, keyboard, 0, "", result);
		return result;
	}

	void dfs(String digits, String[] keyboard, int cur, String path, ArrayList<String> result) {

		if (cur == digits.length()) {
			result.add(path);
			return;
		}
		String str = keyboard[digits.charAt(cur) - '0'];
		for (int i = 0; i < str.length(); i++) {
			dfs(digits, keyboard, cur + 1, path + str.charAt(i), result);
		}
	}
}
