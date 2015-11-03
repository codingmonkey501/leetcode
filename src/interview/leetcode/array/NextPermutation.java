package interview.leetcode.array;

import interview.careercup.Introduction.SwapInPlace;

public class NextPermutation {

	/**
	 * Implement next permutation, which rearranges numbers into the
	 * lexicographically next greater permutation of numbers.
	 * 
	 * If such arrangement is not possible, it must rearrange it as the lowest
	 * possible order (ie, sorted in ascending order).
	 * 
	 * The replacement must be in-place, do not allocate extra memory.
	 * 
	 * Here are some examples. Inputs are in the left-hand column and its
	 * corresponding outputs are in the right-hand column. 
	 *  1,2,3 → 1,3,2
		3,2,1 → 1,2,3
		1,1,5 → 1,5,1
	 */
	public static void main(String[] args) {

		NextPermutation n = new NextPermutation();
		int[] num1 = new int[] { 1, 2, 3 };
		n.nextPermutation(num1);

		int[] num2 = new int[] { 2, 1, 3, 9, 8 };
		n.nextPermutation(num2);

		int[] num3 = new int[] { 1, 1, 3 };
		n.nextPermutation(num3);

		int[] num4 = new int[] { 1, 1 };
		n.nextPermutation(num4);

		int[] num5 = new int[] { 3, 2, 1 };
		n.nextPermutation(num5);

		int[] num6 = new int[] { 1, 3, 2 };
		n.nextPermutation(num6);

		int[] num7 = new int[] { 1, 5, 1 };
		n.nextPermutation(num7);
		return;
	}

	
	/**
	 * Solution 1
	 */
	public void nextPermutation3(int[] num) {

		int i = num.length - 1;
		while (i > 0) {
			if (num[i] > num[i - 1]) {

				for (int j = num.length - 1; j >= 0; j--) {
					if (num[j] > num[i - 1]) {
						SwapInPlace.swap2(num, i - 1, j);
						break;
					}
				}
				break;
			}
			i--;
		}
		reverse2(num, i, num.length - 1);
	}

	private void reverse2(int[] num, int start, int end) {

		while (start < end) {
			SwapInPlace.swap2(num, start, end);
			start++;
			end--;
		}
	}

	
	/**
	 * Solution 2
	 */
	public void nextPermutation(int[] num) {

		if (num.length == 1)
			return;

		// Get a reversed range to simplify reversed traversal.
		int last = num.length - 1;
		int pivot = last - 1;
		while (pivot != -1 && num[pivot] >= num[pivot + 1])
			pivot--;

		if (pivot == -1) {
			reverse(num, 0, num.length - 1);
			return;
		}

		int change = last;
		while (pivot != change) {
			if (num[change] > num[pivot])
				break;
			change--;
		}

		SwapInPlace.swap2(num, change, pivot);

		reverse(num, pivot + 1, num.length - 1);

	}

	// how to reverse array
	private void reverse(int[] num, int first, int last) {

		int len = last - first + 1;
		for (int i = 0; i < len / 2; i++) {
			int tmp = num[first + i];
			num[first + i] = num[last - i];
			num[last - i] = tmp;
		}
	}

}
