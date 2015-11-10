package interview.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subsets {

	/**
	 * 
	 Given a set of distinct integers, S, return all possible subsets.
	 * 
	 * Note: Elements in a subset must be in non-descending order. The solution
	 * set must not contain duplicate subsets. For example, If S = [1,2,3], a
	 * solution is:
	 * 
	 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
	 */
	public static void main(String[] args) {
		Subsets s = new Subsets();
		ArrayList<ArrayList<Integer>> result = s.subsets1(new int[] {0,1,2});
		for (ArrayList<Integer> arr : result) {
			for (Integer i : arr) {
				System.out.print(i + " , ");
			}
			System.out.print("\n");
		}
	}
	
	
	
	//recusive O(2^n)
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		subsets(S, path, 0, result);
		return result;
	}

	public void subsets(int[] S, ArrayList<Integer> path, int step, ArrayList<ArrayList<Integer>> result) {
		if (step == S.length) {
			ArrayList<Integer> arr = sortArr(path);
			result.add(arr);
			return;
		}
		// not choose S[step]
		subsets(S, path, step+1, result);
		// choose S[step]
		path.add(S[step]);
		subsets(S, path, step+1, result);
		path.remove(path.size()-1);
	}
	
	
	
	
	//better and easier to understand in interative way
	public ArrayList<ArrayList<Integer>> subsets4(int[] S) {

		if (S == null) {
			return null;
		}
		Arrays.sort(S);

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		list.add(arr);
		
		for (int i = 0; i < S.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> a : list) {
				ArrayList<Integer> newarr = new ArrayList<Integer>(a);
				newarr.add(S[i]);
				temp.add(newarr);
			}
			list.addAll(temp);
		}

		return list;
	}
	
	
	// easier to under the recusive way and easier to implement the follow up
	// question - what if duplicate exist?
	public ArrayList<ArrayList<Integer>> subsets1(int[] S) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		subsets1(S, path, 0, result);
		return result;
	}

	public void subsets1(int[] S, ArrayList<Integer> path, int start, ArrayList<ArrayList<Integer>> result) {

		ArrayList<Integer> sortedClone = sortArr(path);
		result.add(sortedClone);

		for (int step = start; step < S.length; step++) {
			path.add(S[step]);
			subsets1(S, path, step + 1, result);
			path.remove(path.size() - 1);
		}
	}

	
	private ArrayList<Integer> sortArr(ArrayList<Integer> path) {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (Integer num : path) {
			arr.add(num);
		}
		Collections.sort(arr);
		return arr;
	}

}
