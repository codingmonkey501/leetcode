package interview.leetcode.dp;

public class MinimumPathSum {

	/**
	 * Given a m x n grid filled with non-negative numbers, find a path from top
	 * left to bottom right which minimizes the sum of all numbers along its
	 * path.
	 * 
	 * Note: You can only move either down or right at any point in time.
	 */
	
	
	public int minPathSum3(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        for (int j=1; j<n; j++){
            grid[0][j] += grid[0][j-1];
        }
        
        for (int i=1; i<m; i++) {
            grid[i][0] += grid[i-1][0];
        }
        
        for (int i=1; i<m; i++) {
            for(int j=1; j<n; j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        
        return grid[m-1][n-1];
    }
	
	// DP
	public int minPathSum(int[][] grid) {

		if (grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		int[][] f = new int[m][n];
		f[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			f[i][0] = f[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < n; i++) {
			f[0][i] = f[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
			}
		}
		return f[m - 1][n - 1];
	}

	int min = 0;

	public int minPathSum1(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		for (int n = 0; n < grid[0].length; n++) {
			min += grid[0][n];
		}
		
		// should start from 1 : the corner value have been calculate twice
		for (int m = 1; m < grid.length; m++) { 
			min += grid[m][grid[0].length - 1];
		}
		dfs(grid, 0, 0, 0);
		return min;
	}

	public void dfs(int[][] grid, int sum, int m, int n) {
		// only when the n==length compare the min : don't use m==grid.length&&n==grid[0].length as condition
		if (m == grid.length - 1 && n == grid[0].length - 1) {
			sum += grid[m][n];
			if (sum < min)
				min = sum;
			return;
		}
		if (n == grid[0].length || m == grid.length)
			return;
		// because m!=length; it's wrong
		sum += grid[m][n]; // don't put sum + num into parameter otherwise it will caculate wrong
		dfs(grid, sum, m + 1, n);
		dfs(grid, sum, m, n + 1);

	}

}
