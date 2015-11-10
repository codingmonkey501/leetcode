package interview.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsII {

	
	/**
	 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

		Note:
		Elements in a subset must be in non-descending order.
		The solution set must not contain duplicate subsets.
		For example,
		If S = [1,2,2], a solution is:
		
		[
		  [2],
		  [1],
		  [1,2,2],
		  [2,2],
		  [1,2],
		  []
		]
	 */
	
	public static void main(String[] args) {

		new SubsetsII().subsetsWithDup3(new int[]{1, 2, 2});
		new SubsetsII().subsetsWithDup3(new int[]{5, 5, 5, 5});
	}
	
	public List<List<Integer>> subsetsWithDup3(int[] num) {
        
        Arrays.sort(num);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<Integer>();
        list.add(arr);
        
        int start=0;
        for(int i=0; i<num.length; i++){
            
            if (i!=0 && num[i]!=num[i-1]) 
            	start = 0;
            int size = list.size();
            
            for (int j=start; j<size; j++){
                List<Integer> a = list.get(j);
                List<Integer> n = new ArrayList<Integer>(a);
                n.add(num[i]);
                list.add(n);
            }
            start = size;
        }
        
        return list;
    }

	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		subsets(num, path, 0, result);
		return result;
	}

	public void subsets(int[] S, ArrayList<Integer> path, int start, ArrayList<ArrayList<Integer>> result) {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (Integer num : path) {
			arr.add(num);
		}
		Collections.sort(arr);
		result.add(arr);

		for (int i = start; i < S.length; i++) {
			if (i != start && S[i] == S[i-1])
				continue;
			path.add(S[i]);
			subsets(S, path, i + 1, result);
			path.remove(path.size() - 1);
		}

	}

}
