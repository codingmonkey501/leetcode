package interview.leetcode.binarysearch;

public class Searcha2DMatrix {

	
	/**
	 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

		Integers in each row are sorted from left to right.
		The first integer of each row is greater than the last integer of the previous row.
		For example,
		
		Consider the following matrix:
		
		[
		  [1,   3,  5,  7],
		  [10, 11, 16, 20],
		  [23, 30, 34, 50]
		]
		Given target = 3, return true.
	 */

	public boolean searchMatrix2(int[][] matrix, int target) {

		int m = matrix.length;
		int n = matrix[0].length;
		int s = 0;
		int e = m * n - 1;

		while (s <= e) {
			int mid = (s + e) / 2;

			int i = mid / n;
			int j = mid % n;

			if (matrix[i][j] < target)
				s = mid + 1;
			else if (matrix[i][j] > target)
				e = mid - 1;
			else
				return true;

		}

		return false;
	}

	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix.length == 0)
			return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int first = 0;
		int last = m * n;
		while (first < last) {
			int mid = first + (last - first) / 2;
			int value = matrix[mid / n][mid % n];
			if (value == target)
				return true;
			else if (value < target)
				first = mid + 1;
			else
				last = mid;
		}
		return false;
	}

	public boolean searchMatrix1(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;

		int whichrow = -1; // start from undetermined is good idea
		for (int r = 0; r < matrix.length; r++) {
			if (matrix[r][0] <= target)
				whichrow++; // incase of no one bigger than target
			else
				break;
		}
		if (whichrow == -1)
			return false;
		for (int c = 0; c < matrix[0].length; c++) {
			if (matrix[whichrow][c] == target)
				return true;
			if (matrix[whichrow][c] > target)
				return false;
		}
		return false;
	}

}
