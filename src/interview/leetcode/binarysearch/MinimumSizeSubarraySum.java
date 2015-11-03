package interview.leetcode.binarysearch;


public class MinimumSizeSubarraySum {
	/**
	 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
	
		For example, given the array [2,3,1,2,4,3] and s = 7,
		the subarray [4,3] has the minimal length under the problem constraint.
		
		More practice:
		If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).


	 */
	
    //O(nlogn)
    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) 
            sums[i] = sums[i - 1] + nums[i - 1];
        
        int minLen = Integer.MAX_VALUE;
        
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length)
                break;
            minLen = Math.min(minLen, end - i);
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }
    
    //O(n^2)
    public int minSubArrayLen2(int s, int[] nums) {
        int sum = 0, len = nums.length, start = 0;
        boolean flag = false;
        for (int end = 0; end < nums.length; ++end) {
            sum += nums[end];
            while (sum >= s) {
                flag = true;
                len = Math.min(len, end - start + 1);
                sum -= nums[start++];
            }
        }
        return flag ? len : 0;
    }
    
    
    private int binarySearch(int s, int e, int target, int[] sums) {
        while (s <= e) {
           int m = (s + e) / 2;
           if (sums[m] >= target){
               e = m - 1;
           } else {
               s = m + 1;
           }
        }
        return s;
    }
}
