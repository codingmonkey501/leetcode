package interview.leetcode.dp;

public class MaximumSubarray {

	/**
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest sum.
	 * 
	 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous
	 * subarray [4,−1,2,1] has the largest sum = 6.
	 * 
	 * click to show more practice.
	 * 
	 * More practice: If you have figured out the O(n) solution, try coding
	 * another solution using the divide and conquer approach, which is more
	 * subtle.
	 */
	
	
//	Step1. Select the middle element of the array. So the maximum subarray may contain that middle element or not.
//	Step 2.1 If the maximum subarray does not contain the middle element, then we can apply the same algorithm to the the subarray to the left of the middle element and the subarray to the right of the middle element.
//	Step 2.2 If the maximum subarray does contain the middle element, then the result will be simply the maximum suffix subarray of the left subarray plus the maximum prefix subarray of the right subarray
//	Step 3 return the maximum of those three answer.
//	Here is a sample code for divide and conquer solution. Please try to understand the algorithm before look at the code

	public int maxSubArray3(int[] A) {
        if(A.length==0) return 0;
        return maxSubArrayHelperFunction(A,0,A.length-1);
    }

    private int maxSubArrayHelperFunction(int A[], int left, int right) {
        if(right == left) return A[left];
        int middle = (left+right)/2;
        System.out.println("divide [" + left + "," + right + "] mpos=" + middle + "  midval=" + A[middle]);
        int leftans = maxSubArrayHelperFunction(A, left, middle);
        int rightans = maxSubArrayHelperFunction(A, middle+1, right);
        
        int leftmax = A[middle];
        int rightmax = A[middle+1];
        int temp = 0;
        for(int i=middle;i>=left;i--) {
            temp += A[i];
            leftmax = Math.max(temp, leftmax);
        }
        temp = 0;
        for(int i=middle+1;i<=right;i++) {
            temp += A[i];
            rightmax = Math.max(temp, rightmax);
        }
        System.out.println("conqur midval="+ A[middle] +" lans=" + leftans + " rans=" + rightans 
        		+" lmax+rmax=" + (leftmax + rightmax) 
        		+ " return=" + Math.max(Math.max(leftans, rightans),leftmax+rightmax));
        return Math.max(Math.max(leftans, rightans),leftmax+rightmax);
    }
	
	public int maxSubArray2(int[] A) {
        
        int max=Integer.MIN_VALUE;
        int sum=0;
        for (int i=0; i<A.length; i++){
            int cur = A[i];
            sum += cur;
            if(cur > sum)
                sum = cur;
            max = Math.max(max, sum);    
        }
        
        return max;
    }
	
	//concise way
	public int maxSubArray(int[] A) {

		int result = Integer.MIN_VALUE, f = 0;
		for (int i = 0; i < A.length; ++i) {
			f = Math.max(f + A[i], A[i]);
			result = Math.max(result, f);
		}
		return result;
	}

	public int maxSubArray1(int[] A) {

		if (A == null)
			return 0;
		int sum = 0;
		int maxsum = A[0];
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			if (A[i] > sum) { // this is a hard part
				sum = A[i];
			}
			if (sum > maxsum)
				maxsum = sum;
		}
		return maxsum;
	}

	public static void main(String[] args) {
		new MaximumSubarray().maxSubArray3(new int[]{-2,1,-3,4,-1,2,1,-5,4});
	}

}
