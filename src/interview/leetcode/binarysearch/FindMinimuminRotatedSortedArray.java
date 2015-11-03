package interview.leetcode.binarysearch;


public class FindMinimuminRotatedSortedArray {

	/**
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

		(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
		
		Find the minimum element.
		
		You may assume no duplicate exists in the array.
	 */
	
	// solution 1
	public int findMin(int[] nums) {

		int s = 0;
		int e = nums.length - 1;
		while (s < e) {

			int m = (s + e) / 2;
			if (nums[m] < nums[e]) {
				e = m;
			} else if (nums[m] > nums[e]) {
				s = m + 1;
			}
		}

		return nums[s];
	}

	// solution 2
	public int findMin2(int[] nums) {

		int start = 0;
		int end = nums.length;
		int min = nums[0];
		while (start < end) {

			int mid = (start + end) / 2;
			if (nums[mid] <= nums[end - 1]) {
				min = Math.min(min, nums[mid]);
				end = mid;
			} else if (nums[mid] >= nums[start]) {
				min = Math.min(min, nums[start]);
				start = mid + 1;
			}
		}

		return min;
	}
}
