package interview.leetcode.binarysearch;


public class FindMinimuminRotatedSortedArrayII {
/**
 * Follow up for "Find Minimum in Rotated Sorted Array":
	What if duplicates are allowed?
	
	Would this affect the run-time complexity? How and why?
	Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	
	Find the minimum element.
	
	The array may contain duplicates.
 */
	
	public int findMin(int[] nums) {

		int s = 0;
		int e = nums.length - 1;
		while (s <= e) {

			int m = (s + e) / 2;
			if (nums[m] > nums[e]) {
				s = m + 1;
			} else if (nums[m] < nums[e]) {
				e = m;
			} else {
				e--;
			}
		}

		return nums[s];
	}
}
