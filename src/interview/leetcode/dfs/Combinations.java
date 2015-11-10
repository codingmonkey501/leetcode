package interview.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	
	/**
	 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

		For example,
		If n = 4 and k = 2, a solution is:
		
		[
		  [2,4],
		  [3,4],
		  [2,3],
		  [1,2],
		  [1,3],
		  [1,4],
		]
	 */
	
	
	
	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		combine(n, k, 0, path, list);
		return list;
	}

	private void combine(int n, int k, int start, List<Integer> path, List<List<Integer>> list) {

		if (path.size() == k) {
			list.add(new ArrayList<Integer>(path));
			return;
		}
		for (int i = start; i < n; i++) {

			path.add(i + 1);
			combine(n, k, i + 1, path, list);
			path.remove(path.size() - 1);
		}
	}
	

	public void swap(ArrayList<Integer> arr, int i, int j) {

		int temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}

}
