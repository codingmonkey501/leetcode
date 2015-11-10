package interview.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;


public class PermutationsII {

	/**
	 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

		For example,
		[1,1,2] have the following unique permutations:
		[1,1,2], [1,2,1], and [2,1,1].
	 */
	
	public List<List<Integer>> permuteUnique(int[] num) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		permuteUnique(num, 0, result);
		return result;
	}

	private void permuteUnique(int[] num, int start, List<List<Integer>> result) {

		if (start >= num.length) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
		}

		for (int j = start; j <= num.length - 1; j++) {
			if (containsDuplicate(num, start, j)) {
				swap(num, start, j);
				permuteUnique(num, start + 1, result);
				swap(num, start, j);
			}
		}
	}

	private ArrayList<Integer> convertArrayToList(int[] num) {

		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}

	private boolean containsDuplicate(int[] arr, int start, int end) {

		for (int i = start; i <= end - 1; i++) {
			if (arr[i] == arr[end]) {
				return false;
			}
		}
		return true;
	}

	private void swap(int[] a, int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
