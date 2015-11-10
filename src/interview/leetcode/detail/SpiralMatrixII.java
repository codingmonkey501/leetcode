package interview.leetcode.detail;

public class SpiralMatrixII {

	
	/**
	 * 
	 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

		For example,
		Given n = 3,
		
		You should return the following matrix:
		[
		 [ 1, 2, 3 ],
		 [ 8, 9, 4 ],
		 [ 7, 6, 5 ]
		]
	 * 
	 */
	public static void main(String[] args) {
		SpiralMatrixII s=new SpiralMatrixII();
		s.generateMatrix(3);
	}
	
	public int[][] generateMatrix1(int n) {

		int[][] matrix = new int[n][n];
		int val = 1;
		if (matrix.length == 0)
			return matrix;
		int beginX = 0, endX = matrix[0].length - 1;
		int beginY = 0, endY = matrix.length - 1;

		while (true) {
			// From left to right
			for (int j = beginX; j <= endX; ++j)
				matrix[beginY][j] = val++;
			if (++beginY > endY)
				break;
			// From top to bottom
			for (int i = beginY; i <= endY; ++i)
				matrix[i][endX] = val++;
			if (beginX > --endX)
				break;
			// From right to left
			for (int j = endX; j >= beginX; --j)
				matrix[endY][j] = val++;
			if (beginY > --endY)
				break;
			// From bottom to top
			for (int i = endY; i >= beginY; --i)
				matrix[i][beginX] = val++;
			if (++beginX > endX)
				break;

		}

		return matrix;
	}

	public int[][] generateMatrix(int n) {

		int[][] result = new int[n][n];
		int r = 0;
		int c = 0;
		//boolean horizontal = true;
		//boolean vertical = false;
		int direction=0; //wrong here: use direction integer to faily control the direction.
		int hrightlimit = n;
		int hleftlimit = -1;
		int vbottomlimit = n;
		int vuplimit = 0;
		for (int i = 0; i < n * n; i++) {

			if (direction==0) {
				result[r][c] = i + 1;
				c++;
				if (c == hrightlimit) {
					direction=1;
					r++;
					c--;
					hrightlimit--;
				}
			} else if (direction==2) {
				result[r][c] = i + 1;
				c--;
				if (c == hleftlimit) {
					direction=3;
					r--;
					c++;
					hleftlimit++;
				}
			} else if (direction==1) {
				result[r][c] = i + 1;
				r++;
				if (r == vbottomlimit) {
					direction=2;
					r--;
					c--;
					vbottomlimit--;
				}
			} else if (direction==3) {
				result[r][c] = i + 1;
				r--;
				if (r == vuplimit) {
					direction=0;
					c++;
					r++;
					vuplimit++;
				}
			}
		}
		return result;
	}
	
	//better
	public int[][] generateMatrix2(int n) {
		int[][] matrix = new int[n][n];
		generate_order(matrix, 0, n, 0, n, 1);
		return matrix;
	}

	public void generate_order(int[][] matrix, int row_s, int row_len, int col_s, int col_len, int val) {
		if (row_len <= 0 || col_len <= 0)
			return;
		if (row_len == 1) {
			for (int i = col_s; i < col_s + col_len; i++)
				matrix[row_s][i] = val++;
			return;
		}
		if (col_len == 1) {
			for (int i = row_s; i < row_s + row_len; i++)
				matrix[i][col_s] = val++;
			return;
		}
		// up
		for (int i = col_s; i < col_s + col_len - 1; i++)
			matrix[row_s][i] = val++;
		// right
		for (int i = row_s; i < row_s + row_len - 1; i++)
			matrix[i][col_s + col_len - 1] = val++;
		// bottom
		for (int i = col_s; i < col_s + col_len - 1; i++)
			matrix[row_s + row_len - 1][2 * col_s + col_len - 1 - i] = val++;
		// left
		for (int i = row_s; i < row_s + row_len - 1; i++)
			matrix[2 * row_s + row_len - 1 - i][col_s] = val++;
		generate_order(matrix, row_s + 1, row_len - 2, col_s + 1, col_len - 2, val);
	}
        
}
