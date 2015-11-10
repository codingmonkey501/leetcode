package interview.leetcode.detail;

import java.util.ArrayList;
import java.util.Arrays;

public class PascalsTriangleII {

	
	/**
	 * Given an index k, return the kth row of the Pascal's triangle.

		For example, given k = 3,
		Return [1,3,3,1].
		
		Note:
		Could you optimize your algorithm to use only O(k) extra space?
	 */
	
	//concise way when using Arrays.asList to convert array to List
	public ArrayList<Integer> getRow(int rowIndex) {

		Integer[] current = new Integer[rowIndex + 1];
		current[0] = 1;
		if (rowIndex == 0)
			return new ArrayList<Integer>(Arrays.asList(current));
		for (int i = 1; i < rowIndex + 1; i++) {
			for (int j = i - 1; j > 0; j--) {
				current[j] = current[j] + current[j - 1];
			}
			current[i] = 1;
		}
		return new ArrayList<Integer>(Arrays.asList(current));
	}

	public ArrayList<Integer> getRow2(int rowIndex) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        if(rowIndex<1) return temp;
        temp.add(1);
        
        for(int k=1;k<rowIndex;k++){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(1);
            for(int i=1;i<temp.size();i++){
                result.add(temp.get(i) + temp.get(i-1));
            }
            result.add(1);
            temp=result;
        }
        return temp;
    }
	
	
	public ArrayList<Integer> getList(int[] nums) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			res.add(nums[i]);
		}
		return res;
	}
}
