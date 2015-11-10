package interview.leetcode.detail;

import java.util.ArrayList;
import java.util.Arrays;

public class PascalsTriangle {
	
	/**
	 * 
	 * 
	 * Given numRows, generate the first numRows of Pascal's triangle.

		For example, given numRows = 5,
		Return
		
		[
		     [1],
		    [1,1],
		   [1,2,1],
		  [1,3,3,1],
		 [1,4,6,4,1]
		]
	 */
	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> result = new PascalsTriangle().generate2(4);
		for (ArrayList<Integer> arr: result){
			for(Integer i: arr)
				System.out.print(i);
			System.out.println();
		}
	}
	
	// iterative way
	public ArrayList<ArrayList<Integer>> generate2(int numRows) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (numRows == 0)
			return result;
		result.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { 1 })));
		if (numRows == 1)
			return result;
		result.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 1 })));
		if (numRows == 2)
			return result;

		for (int i = 2; i <= numRows; i++) {

			ArrayList<Integer> prev = result.get(i - 1);
			Integer[] current = new Integer[prev.size() + 1];
			current[0] = 1;
			current[current.length - 1] = 1;
			for (int j = 1; j < i; j++) {
				current[j] = prev.get(j - 1) + prev.get(j);
			}
			result.add(new ArrayList<Integer>(Arrays.asList(current)));
		}

		return result;

	}

	
	
	

	public ArrayList<ArrayList<Integer>> generate(int numRows) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numRows == 0)
			return result; // input 0 expects []
		recusive(numRows, result);
		return result;

	}

	public void recusive(int numRows, ArrayList<ArrayList<Integer>> result) {
		if (numRows == 1) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			row.add(1);
			result.add(row);
			return;
		}
		recusive(numRows - 1, result);
		ArrayList<Integer> row = result.get(numRows - 2); // out of bound
															// because it start
															// from 0
		ArrayList<Integer> newrow = new ArrayList<Integer>();

		newrow.add(1);
		for (int i = 0; i < row.size(); i++) {
			Integer sum = row.get(i);
			if (i + 1 < row.size()) {
				sum += row.get(i + 1);
			}
			newrow.add(sum);
		}
		result.add(newrow);

	}
}
