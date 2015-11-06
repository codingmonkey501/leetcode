package interview.leetcode.dfs;

public class UniquePaths {

	/**
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
	 * in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * 'Finish' in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 */
	public static void main(String[] args) {
		UniquePaths u=new UniquePaths();
		System.out.println(u.uniquePaths2(23, 10));
		System.out.println(u.uniquePaths(23, 10));
	}
	
	
	public int uniquePaths3(int m, int n) {
        int[][] steps = new int[m][n];
        
        for (int i=0; i<n; i++)
            steps[0][i] = 1;
        
        for(int i=1; i<m; i++){
            steps[i][0] = 1;
            for(int j=1; j<n; j++){
                steps[i][j] = steps[i-1][j] + steps[i][j-1];
            }
        }
        return steps[m-1][n-1];
    }


    public int uniquePaths4(int m, int n) {
        int[] steps = new int[n];
        
        for (int i=0; i<n; i++)
            steps[i] = 1;
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                steps[j] += steps[j-1];
            }
        }
        return steps[n-1];
    }
    

	// Time Limit Exceeded
	public int uniquePaths2(int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		return dfs(0, 0, m, n);
	}

	public int dfs(int i, int j, int m, int n) {
		if (i == m - 1 && j == n - 1)
			return 1;
		if (i == m || j == n)
			return 0;
		return dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
	}

	// iterative way
	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		int[] row = new int[n];
		for (int i = 0; i < n; i++) {
			row[i] = 1;
		}
		for (int r = 1; r < m; r++) {
			for (int c = 1; c < n; c++) {
				// if(c==0) row[0]+=row[0]; //wrong : the first row should alway be 1
				row[c] += row[c - 1];
			}
		}
		return row[row.length - 1];
	}
}
