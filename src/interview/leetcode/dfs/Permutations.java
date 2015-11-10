package interview.leetcode.dfs;

import java.util.ArrayList;

public class Permutations {

	
	/**
	 * Given a collection of numbers, return all possible permutations.
		
		For example,
		[1,2,3] have the following permutations:
		[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 */
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = new Permutations().permute(new int[] {1,2,3});
		for (ArrayList<Integer> arr : result) {
			for (Integer i : arr) {
				System.out.print(i + " , ");
			}
			System.out.print("\n");
		}
	}
	
	
	public ArrayList<ArrayList<Integer>> permute(int[] num) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0)
			return result;
		dfs(num, 0, result);
		return result;
	}

	public void dfs(int[] num, int start, ArrayList<ArrayList<Integer>> result) {

		if (start == num.length - 1){
			result.add(toList(num));
			return;
		}
			
		for (int step = start; step < num.length; step++) {
			swap(num, start, step);
			dfs(num, start + 1, result);
			swap(num, start, step);
		}
	}

	public void swap(int[] num, int i, int j) {

		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public ArrayList<Integer> toList(int[] num) {

		ArrayList<Integer> list = new ArrayList<Integer>(num.length);
		for (int n : num) {
			list.add(n);
		}
		return list;
	}

}
