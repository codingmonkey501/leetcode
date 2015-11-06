package interview.leetcode.dfs;

public class UniquePathsII {

	
	
	/**
	 * Follow up for "Unique Paths":

		Now consider if some obstacles are added to the grids. How many unique paths would there be?
		
		An obstacle and empty space is marked as 1 and 0 respectively in the grid.
		
		For example,
		There is one obstacle in the middle of a 3x3 grid as illustrated below.
		
		[
		  [0,0,0],
		  [0,1,0],
		  [0,0,0]
		]
		The total number of unique paths is 2.
		
		Note: m and n will be at most 100.
	 */
	public static void main(String[] args) {

		UniquePathsII u = new UniquePathsII();
		int[][] rows = new int[][]{
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }, 
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				new int[] { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, 
				new int[] { 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1 },
				new int[] { 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
				new int[] { 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0 },
				new int[] { 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				new int[] { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 },
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0 }, 
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				new int[] { 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				new int[] { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, 
				new int[] { 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				new int[] { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1 }, 
				new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, 
				new int[] { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1 },
				new int[] { 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1 }, 
				new int[] { 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				new int[] { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 }, 
				new int[] { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0 } 
				};

		//1637984640
		System.out.println(u.uniquePathsWithObstacles(rows));
	}
	
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] nums = new int[m][n];

		for (int j = 0; j < n; j++) {
			if (obstacleGrid[0][j] == 1)
				break;
			nums[0][j] = 1;
		}

		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1)
				break;
			nums[i][0] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1)
					continue;
				else
					nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
			}
		}
		return nums[m - 1][n - 1];
	}	
	
	
	
	
	
	//和Unique Path一样的转移方程： Step[i][j] = Step[i-1][j] + Step[i][j-1] 
	//if Array[i][j] ==0 or = 0 if Array[i][j] =1
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if (obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0) {
            return 0;
        }
        
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        cache=new int[m+1][n+1];
        return dfs(obstacleGrid, m, n);
    }
    
	// cache is used to make it faster, instead of going to take a lot stack and memory it just return the cached ones
    int[][] cache;
    
	private int dfs(int[][] obstacleGrid, int x, int y) {

		if (x < 1 || y < 1)
			return 0; // illegal
		if (obstacleGrid[x - 1][y - 1] == 1)
			return 0; // obstacle
		if (x == 1 && y == 1)
			return 1; // terminal condition
		return getOrUpdate(obstacleGrid, x - 1, y) + getOrUpdate(obstacleGrid, x, y - 1);
	}

	private int getOrUpdate(int[][] obstacleGrid, int x, int y) {

		if (cache[x][y] > 0)
			return cache[x][y];
		else
			return cache[x][y] = dfs(obstacleGrid, x, y);
	}

}
