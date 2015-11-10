package interview.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	
	/**
	 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

		The same repeated number may be chosen from C unlimited number of times.
		
		Note:
		All numbers (including target) will be positive integers.
		Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
		The solution set must not contain duplicate combinations.
		For example, given candidate set 2,3,6,7 and target 7, 
		A solution set is: 
		[7] 
		[2, 2, 3] 
	 */
	public static void main(String[] args) {

		CombinationSum c = new CombinationSum();
		c.combinationSum(new int[] { 2, 3, 6, 7 }, 7);

	}

	
	/**
	 * Solution 1
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		Arrays.sort(candidates);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		combinationSum2(candidates, target, 0, 0, list, path);

		return list;
	}

	public void combinationSum2(int[] candidates, int target, int start, int sum, List<List<Integer>> list, List<Integer> path) {

		if (sum > target) {
			return;
		} else if (sum == target) {
			list.add(new ArrayList<Integer>(path));
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			sum += candidates[i];
			path.add(candidates[i]);
			combinationSum2(candidates, target, i, sum, list, path);
			sum -= candidates[i];
			path.remove(path.size() - 1);
		}
	}

	/**
	 * Solution 2
	 */
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {

		Arrays.sort(candidates);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> intermediate = new ArrayList<Integer>();
		combinationSum(candidates, target, 0, intermediate, result);
		return result;
	}

	private void combinationSum(int[] candidates, int gap, int start, ArrayList<Integer> intermediate, ArrayList<ArrayList<Integer>> result) {

		if (gap == 0) {
			ArrayList<Integer> r = new ArrayList<Integer>(intermediate);
			result.add(r);
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (gap < candidates[i])
				return;
			intermediate.add(candidates[i]);
			combinationSum(candidates, gap - candidates[i], i, intermediate, result);
			intermediate.remove(intermediate.size() - 1);
		}
	}
}
