package interview.leetcode.array;

public class ClimbingStairs {

	/**
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * 
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways
	 * can you climb to the top?
	 */
	
	public int climbStair5(int n) {
		if(n==1 || n==0) return 1;
		return climbStair5(n-1) + climbStair5(n-2);
	}
	
	public int climbStairs4(int n) {
        
        int a=1;
        int b=1;
        int c=1;
        for (int i=2; i<=n; i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }

	public int climbStairs3(int n) {
        
        int[] nums = new int[n+1];
        nums[0] =1;
        nums[1] =1;
        for (int i=2; i<=n; i++){
            nums[i]=nums[i-1]+nums[i-2];
        }
        return nums[n];
    }

	public int climbStairs(int n) { 
		//Fabonacci number
		if (n == 0) return 0;
		int lastonesteps = 0;
		int onesteps = 1;
		int allsteps = 1;
		for (int i = 1; i < n; i++) {
			lastonesteps = onesteps;
			onesteps = allsteps;
			allsteps = onesteps + lastonesteps;
		}
		return allsteps;
	}

}
