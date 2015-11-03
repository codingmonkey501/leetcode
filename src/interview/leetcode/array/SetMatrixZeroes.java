package interview.leetcode.array;

public class SetMatrixZeroes {

	/**
	 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

		click to show follow up.
		
		Follow up:
		Did you use extra space?
		A straight forward solution using O(mn) space is probably a bad idea.
		A simple improvement uses O(m + n) space, but still not the best solution.
		Could you devise a constant space solution? 
	 */
	public void setZeroes2(int[][] matrix) {

		boolean firstrowhaszero = false;
		boolean firstcolhaszero = false;
		for (int c = 0; c < matrix[0].length; c++) {
			if (matrix[0][c] == 0)
				firstrowhaszero = true;
		}

		for (int r = 0; r < matrix.length; r++) {
			if (matrix[r][0] == 0)
				firstcolhaszero = true;
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		if (firstcolhaszero) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
		if (firstrowhaszero) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}

		return;

	}

}
