package interview.leetcode.stackandqueue;

import interview.leetcode.Pair;

import java.util.Stack;

public class LongestValidParentheses {

	
	/**
	 * Given a string containing just the characters '(' and ')', find the
	 * length of the longest valid (well-formed) parentheses substring.
	 * 
	 * For "(()", the longest valid parentheses substring is "()", which has
	 * length = 2.
	 * 
	 * Another example is ")()())", where the longest valid parentheses
	 * substring is "()()", which has length = 4.
	 */
	
	public static void main(String[] args) {
		LongestValidParentheses l=new LongestValidParentheses();
		System.out.println(l.longestValidParentheses5(")()())"));
		System.out.println(l.longestValidParentheses5(")(()))"));
		System.out.println(l.longestValidParentheses5("(()")); //special case
		System.out.println(l.longestValidParentheses5("())")); //special case
		
		
		LongestValidParentheses l2=new LongestValidParentheses();
		System.out.println(l2.longestValidParentheses4(")()())"));
		System.out.println(l2.longestValidParentheses4(")(()))"));
		System.out.println(l2.longestValidParentheses4("(()")); //special case
		System.out.println(l2.longestValidParentheses4("())")); //special case
	}
	
	// better
	public int longestValidParentheses5(String s) {

		Stack<Pair<Character, Integer>> stk = new Stack<Pair<Character, Integer>>();
		int maxLen = 0;
		int curLen = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stk.push(new Pair<Character, Integer>(c, i));
			} else {
				if (stk.empty() || stk.peek().getLeft() == ')')
					stk.push(new Pair<Character, Integer>(')', i));
				else {
					stk.pop();
					if (stk.empty())
						curLen = i + 1;
					else
						curLen = i - stk.peek().getRight();
					maxLen = Math.max(maxLen, curLen);
				}
			}
		}

		return maxLen;
	}
	
	//DP
	public int longestValidParentheses4(String s) {

		int n = s.length();
		int maxLen = 0;
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int j = i - 2 - dp[i - 1];
			if (s.charAt(i - 1) == '(' || j < 0 || s.charAt(j) == ')')
				dp[i] = 0;
			else {
				dp[i] = dp[i - 1] + 2 + dp[j];
				maxLen = Math.max(maxLen, dp[i]);
			}
		}
		return maxLen;
	}
	
	// good
	public int longestValidParentheses3(String s) {

		Stack<Integer> st = new Stack<Integer>();
		int maxlen = 0;
		int lastRight = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ')') {
				if (st.empty()) {
					lastRight = i;
				} else {
					int currLen = 0;
					st.pop();
					if (st.empty()) {
						currLen = i - lastRight;
					} else {
						currLen = i - st.peek();
					}
					maxlen = Math.max(maxlen, currLen);
				}

			} else {
				st.push(i);
			}
		}

		return maxlen;
	}
    
	public int longestValidParentheses(String s) {
		// the position of the last ')'
		int max_len = 0, last = -1; 
		// keep track of the positions of non-matching '('s
		Stack<Integer> lefts = new Stack<Integer>(); 
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '(') {
				lefts.push(i);
			} else {
				if (lefts.empty()) {
					// no matching left
					last = i;
				} else {
					// find a matching pair
					lefts.pop();
					if (lefts.empty()) {
						max_len = Math.max(max_len, i - last);
					} else {
						max_len = Math.max(max_len, i - lefts.peek());
					}
				}
			}
		}
		return max_len;
	}
	
	//wrong answer
	public int longestValidParentheses2(String s) {
		int max = 0;
		int tmp = 0;
		String left = "([{";
		String right = ")]}";
		Stack<Character> stk = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (left.indexOf(c) >= 0) {
				stk.push(c);
			} else {
				if (stk.empty() || stk.peek() != left.charAt(right.indexOf(c))) {
					max = Math.max(tmp, max);
					tmp = 0;
				} else {
					stk.pop();
					tmp += 2;
				}
			}
		}
		return Math.max(tmp, max);
	}
	
	public int longestValidParentheses1(String s) {
		int maxlen = 0;
		
		for (int i = 0, start = -1, len = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '(') {
				++len;
			} else {
				--len;
				if (len < 0) {
					start = i;
					len = 0;
				} else if (len == 0) {
					maxlen = Math.max(maxlen, i - start);
				}
			}
		}

		for (int i = s.length() - 1, start = s.length(), len = 0; i >= 0; --i) {
			if (s.charAt(i) == ')') {
				++len;
			} else {
				--len;
				if (len < 0) {
					start = i;
					len = 0;
				} else if (len == 0) {
					maxlen = Math.max(maxlen, start - i);
				}
			}
		}
		return maxlen;
	}
	
}
