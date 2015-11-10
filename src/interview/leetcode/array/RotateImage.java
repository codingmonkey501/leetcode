package interview.leetcode.array;

public class RotateImage {

	/**
	 * You are given an n x n 2D matrix representing an image.
	 * 
	 * Rotate the image by 90 degrees (clockwise).
	 * 
	 * Follow up: Could you do this in-place?
	 */
	public static void main(String[] args) {
		RotateImage r = new RotateImage();
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		r.rotate(matrix);
		System.out.println(r);
	}
	
	
	public void rotate(int[][] matrix) {
        
		//m must be same as n
        int m = matrix.length;
        int n = matrix[0].length;
        
        //swap along the main diagonal
        for(int i=0; i<m; i++){
            for(int j=i; j<n; j++){
                swap(matrix, i, j, j, i);
            }
        }
        
        //swap along vertical line
        for(int i=0; i<m; i++){
            for(int j=0; j<n/2; j++){
                swap(matrix, i, j, i, n-j-1);
            }
        }
    }
	
	
	//rotate from outside to inner
	public void rotate2(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix.length == 1)
			return;
		int len = matrix.length;

		int r = 0;
		while (r < len / 2) {
			for (int c = r; c < len - r - 1; c++) { // wrong here the condition
													// should ignore the corner
													// and also consider the
													// inner corner when loop
													// inside
				int temp = matrix[r][c];
				matrix[r][c] = matrix[len - c - 1][r]; // wrong with the 90
														// degree rotate
				matrix[len - c - 1][r] = matrix[len - r - 1][len - c - 1];
				matrix[len - r - 1][len - c - 1] = matrix[c][len - r - 1];
				matrix[c][len - r - 1] = temp;
			}
			r++; // r should be outside for loop
		}
	}

	public void swap(int[][] matrix, int i, int j, int k, int l){
        int t = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = t;
    }
}
