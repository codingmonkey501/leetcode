package interview.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainDuplicate {

	/**
	 * Given an array of integers, find if the array contains any duplicates.
	 * Your function should return true if any value appears at least twice in
	 * the array, and it should return false if every element is distinct.
	 */

	public boolean containsDuplicate(int[] nums) {

		final Set<Integer> distinct = new HashSet<Integer>();
		for (int num : nums) {
			if (distinct.contains(num)) {
				return true;
			}
			distinct.add(num);
		}
		return false;
	}
	

	/**
	 * Given an array of integers and an integer k, find out whether there are
	 * two distinct indices i and j in the array such that nums[i] = nums[j] and
	 * the difference between i and j is at most k.
	 */

	public boolean containsNearbyDuplicate(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			
			Integer orig = map.put(nums[i], i);
			if (orig != null && i - orig <= k) {
				return true;
			}
		}

		return false;
	}
	
	
	/**
	 * Given an array of integers, find out whether there are two distinct indices i 
	 * and j in the array such that the difference between nums[i] and nums[j] is at
	 *  most t and the difference between i and j is at most k.
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		if (k < 1 || t < 0)
			return false;
		
		Map<Long, Long> map = new HashMap<Long, Long>();
		
		for (int i = 0; i < nums.length; i++) {
			
			long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
			long bucket = remappedNum / ((long) t + 1);

			if (map.containsKey(bucket) 
					|| (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t) 
					|| (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
				return true;

			if (map.entrySet().size() >= k) {
				long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
				map.remove(lastBucket);
			}

			map.put(bucket, remappedNum);
		}
		
		return false;
	}
}
