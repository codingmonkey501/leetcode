package interview.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	/**
	 * Given n pairs of parentheses, write a function to generate all
	 * combinations of well-formed parentheses.
	 * 
	 * For example, given n = 3, a solution set is:
	 * 
	 * "((()))", "(()())", "(())()", "()(())", "()()()"
	 */
	public static void main(String[] args) {

		List<String> arr1 = new GenerateParentheses().generateParenthesis2(3);
		
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i));
		}
		
		
		List<String> arr2 = new GenerateParentheses().generateParenthesis(7);
		for (int i = 0; i < arr2.size(); i++) {
			System.out.println(arr2.get(i));
		}
	}
	
	
	public List<String> generateParenthesis2(int n) {

		List<String> list = new ArrayList<String>();
		String path = "";
		generateParenthesis2(n, n, list, path);
		return list;
	}

	public void generateParenthesis2(int l, int r, List<String> list, String path) {

		if (l == 0 && r == 0) {
			list.add(path);
			return;
		}

		if (l > 0) {
			generateParenthesis2(l - 1, r, list, path + '(');
		}
		if (r > l) {
			generateParenthesis2(l, r - 1, list, path + ')');
		}
	}
	

	public List<String> generateParenthesis(int n) {

		List<String> list = new ArrayList<String>();
		char[] path = new char[n * 2];
		generateParenthesis(n, n, list, path);
		return list;
	}

	public void generateParenthesis(int l, int r, List<String> list, char[] path) {

		int n = path.length / 2;
		if (l == 0 && r == 0) {
			list.add(String.valueOf(path));
			return;
		}

		if (l > 0) {
			path[n - l + n - r] = '(';
			generateParenthesis(l - 1, r, list, path);
		}
		if (r > l) {
			path[n - l + n - r] = ')';
			generateParenthesis(l, r - 1, list, path);
		}
	}
}
