package interview.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	/**
	 * Given a collection of candidate numbers (C) and a target number (T), find
	 * all unique combinations in C where the candidate numbers sums to T.
	 * 
	 * Each number in C may only be used once in the combination.
	 * 
	 * Note: All numbers (including target) will be positive integers. Elements
	 * in a combination (a1, a2, … , ak) must be in non-descending order. (ie,
	 * a1 ≤ a2 ≤ … ≤ ak). The solution set must not contain duplicate
	 * combinations. For example, given candidate set 10,1,2,7,6,1,5 and target
	 * 8, A solution set is: [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
	 */

	public List<List<Integer>> combinationSumII(int[] candidates, int target) {

		Arrays.sort(candidates);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		combinationSum(candidates, target, 0, 0, list, path);

		return list;
	}

	public void combinationSum(int[] candidates, int target, int start, int sum, List<List<Integer>> list, List<Integer> path) {

		if (sum > target) {
			return;
		} else if (sum == target) {
			list.add(new ArrayList<Integer>(path));
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			
			if (i != start && candidates[i] == candidates[i - 1]) {
				continue;
			}

			sum += candidates[i];
			path.add(candidates[i]);
			combinationSum(candidates, target, i + 1, sum, list, path);
			sum -= candidates[i];
			path.remove(path.size() - 1);
		}
	}
}