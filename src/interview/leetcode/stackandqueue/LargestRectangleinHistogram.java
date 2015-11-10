package interview.leetcode.stackandqueue;

import java.util.Stack;

public class LargestRectangleinHistogram {

	/**
	 * Given n non-negative integers representing the histogram's bar height
	 * where the width of each bar is 1, find the area of largest rectangle in
	 * the histogram.
	 * 
	 * 
	 * Above is a histogram where width of each bar is 1, given height =
	 * [2,1,5,6,2,3].
	 * 
	 * 
	 * The largest rectangle is shown in the shaded area, which has area = 10
	 * unit.
	 * 
	 * For example, Given height = [2,1,5,6,2,3], return 10.
	 */
	//[2,1,5,6,2,3,1,2,1,2,5] should return 11
	public static void main(String[] args) {
		LargestRectangleinHistogram l=new LargestRectangleinHistogram();
		System.out.println(l.largestRectangleArea(new int[]{1}));
		System.out.println(l.largestRectangleArea(new int[]{1,1}));
		System.out.println(l.largestRectangleArea(new int[]{2,1,5,6,2,3}));
		System.out.println(l.largestRectangleArea(new int[]{3,1,5,6,2,3,1,2,1,2,5}));
		System.out.println(l.largestRectangleArea(new int[]{1,2,3,8}));
	}

	/**
	 * 这两题看起来有点像，但是实际上是完全不一样的，区别在于：
	 * 
	 * The "Container With Most Water" solution will allow the water to rise
	 * above intermediate positions. With the "largest rectangle" problem, the
	 * rectangle cannot rise above intermediate bars.
	 * 
	 * Container With Most Water只考虑左右边界，[i,j]范围内的Area = min(height[i],height[j])
	 * * (j-i);而Largest Rectangle in Histogram，高度最小值为[i,j]范围内所有高度的最小值。后者比前者要难很多
	 * 1.Container With Most Water 对于这题，考虑左右边界[i,j]
	 * ,当height[i]<height[j]时，因为i是其中的短板，则无论j取[i+1,j]中的任何值,
	 * Area都只会比当前已求出的[i,j]的Area小
	 * （横坐标范围减小，再遇见比height[i]更小的右边界），因此以i为左边界的情况不再考虑，i++；反之，j--，同样的思考方式。
	 * 
	 * 
	 * compare every time the next height is lower than peek in the stack. if
	 * true , then caculate all the height * (cur -i). else push into stack.
	 */
	
	public int largestRectangleArea(int[] height) {
		if(height.length==0) return 0;
		Stack<Integer> s = new Stack<Integer>();
		int result = height[0];
		for (int i = 0; i <= height.length;) {
			if (s.isEmpty() || (i!=height.length && height[i] > height[s.peek()])) {
				s.push(i++);
			} else {
				result = Math.max(result,
						height[s.pop()] * (s.empty() ? i: i - s.peek() - 1));
			}
		}
		return result;
	}

}
