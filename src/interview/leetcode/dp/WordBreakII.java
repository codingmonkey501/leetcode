package interview.leetcode.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class WordBreakII {
	
	/**
	 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word
		is a valid dictionary word.
		Return all such possible sentences.
		For example, given
		
		s = "catsanddog",
		dict = ["cat", "cats", "and", "sand", "dog"].
		
		A solution is ["cats and dog", "cat sand dog"].
	 */

	public static void main(String[] args) {

		Set<String> dict1 = new HashSet<String>();
		dict1.add("a");
		dict1.add("b");
		dict1.add("cd");
		dict1.add("ab");
		new WordBreakII().wordBreak("abcd", dict1);
 
		// time limit exceed for solution 2
		Set<String> dict2 = new HashSet<String>();
		dict2.add("a");
		dict2.add("aa");
		dict2.add("aaa");
		dict2.add("aaaa");
		dict2.add("aaaaa");
		dict2.add("aaaaaa");
		dict2.add("aaaaaaa");
		dict2.add("aaaaaaaa");
		dict2.add("aaaaaaaaa");
		dict2.add("aaaaaaaaaa");
		new WordBreakII().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict2);
	}

	public List<String> wordBreak(String s, Set<String> dict) {

		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;
		
		// if prev(i)(j) is true, then s[j, i) is exist in dict
		boolean[][] pre = new boolean[s.length() + 1][s.length()];
		
		for (int i = 1; i <= s.length(); ++i) {
			for (int j = i - 1; j >= 0; --j) {
				if (f[j] && dict.contains(s.substring(j, i))) {
					f[i] = true;
					pre[i][j] = true;
				}
			}
		}

		List<String> result = new ArrayList<String>();
		List<String> path = new ArrayList<String>();
		generatePath(s, pre, s.length(), path, result);
		return result;
	}

	private void generatePath(String s, boolean[][] pre, int i, List<String> path, List<String> result) {

		if (i == 0) {
			String tmp = "";
			for (String iter : Reversed.reversed(path)) {
				tmp += iter + " ";
			}
			result.add(tmp.substring(0, tmp.length() - 1));
		}
		
		for (int j = 0; j < s.length(); ++j) {
			if (pre[i][j]) {
				path.add(s.substring(j, i));
				
				//j becomes i
				generatePath(s, pre, j, path, result);
				path.remove(path.size() - 1);
			}
		}
	}

	
	
	
	
	// time limit exceed
	public List<String> wordBreak2(String s, Set<String> dict) {

		List<String> result = new ArrayList<String>();
		List<String> path = new ArrayList<String>();
		if (dict.size() == 0)
			return result;
		dfs2(s, path, result, dict);
		return result;
	}

	void dfs2(String s, List<String> path, List<String> result, Set<String> dict) {

		if (s.length() == 0) {
			String tmp = "";
			for (String it : path)
				tmp += it + " ";
			result.add(tmp.substring(0, tmp.length() - 1));
		}

		for (int i = 1; i <= s.length(); i++) {
			if (dict.contains(s.substring(0, i))) {
				path.add(s.substring(0, i));
				dfs2(s.substring(i), path, result, dict);
				path.remove(path.size() - 1);
			}
		}
	}
}

// The Collections.reverse method actually returns a new list with the elements
// of the original list copied into it in reverse order, so this has O(n)
// performance with regards to the size of the original list.
// As a more efficient solution, you could write a decorator that presents a
// reversed view of a List as an Iterable. The iterator returned by your
// decorator would use the ListIterator of the decorated list to walk over the
// elements in reverse order.
class Reversed<T> implements Iterable<T> {

	private final List<T> original;

	public Reversed(List<T> original) {

		this.original = original;
	}

	public Iterator<T> iterator() {

		final ListIterator<T> i = original.listIterator(original.size());

		return new Iterator<T>() {

			public boolean hasNext() {

				return i.hasPrevious();
			}

			public T next() {

				return i.previous();
			}

			public void remove() {

				i.remove();
			}
		};
	}

	public static <T> Reversed<T> reversed(List<T> original) {

		return new Reversed<T>(original);
	}
}