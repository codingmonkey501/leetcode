package interview.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	
	/**
	 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

		For example, given the following triangle
		[
		     [2],
		    [3,4],
		   [6,5,7],
		  [4,1,8,3]
		]
		The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
		
		Note:
		Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
	 */
	public static void main(String[] args) {
		Triangle t=new Triangle();
		ArrayList<Integer> arr1=new ArrayList<Integer>();
		arr1.add(2);
		ArrayList<Integer> arr2=new ArrayList<Integer>();
		arr2.add(3);
		arr2.add(4);
		ArrayList<Integer> arr3=new ArrayList<Integer>();
		arr3.add(6);
		arr3.add(5);
		arr3.add(7);
		ArrayList<Integer> arr4=new ArrayList<Integer>();
		arr4.add(4);
		arr4.add(1);
		arr4.add(8);
		arr4.add(3);
		ArrayList<ArrayList<Integer>> test=new ArrayList<ArrayList<Integer>>();
		test.add(arr1);
		test.add(arr2);
		test.add(arr3);
		test.add(arr4);
		System.out.println(t.minimumTotal(test));
	}
	
	//Bottom-up O(logn) sapce
    public int minimumTotal4(List<List<Integer>> triangle) {
        
        int size = triangle.size();
        if(size == 1) return triangle.get(0).get(0);
        
        int[] sum = new int[size];
        
        for (int j=0; j<size; j++)
            sum[j] = triangle.get(size-1).get(j);
        
        for(int i=size-1; i>0; i--){
            List<Integer> level = triangle.get(i);
            for(int j=1; j<level.size(); j++){
                int v = triangle.get(i-1).get(j-1);
                sum[j-1] = Math.min(v + sum[j-1], v + sum[j]);
            }
        }
        
        return sum[0];
    }
	
	//Top-down O(logn) space
	public int minimumTotal(List<List<Integer>> triangle) {
        
        int minsum = Integer.MAX_VALUE;
        int size = triangle.size();
        int[] sum = new int[size];
        for(int i=0; i<size; i++) 
            sum[i]=Integer.MAX_VALUE;
        sum[0] = triangle.get(0).get(0);
        
        for(int i=1; i<size; i++){
            List<Integer> level = triangle.get(i);
            for(int j=level.size()-1; j>=0; j--){ //j increase way will have a override issue with sum
                if(j==0) 
                    sum[0] += level.get(0);
                else if(sum[j-1] <= sum[j])
                    sum[j] = level.get(j) + sum[j-1];
                else
                    sum[j] = level.get(j) + sum[j];
            }
        }
        
        for(int j=0; j<size; j++){
            minsum = Math.min(minsum, sum[j]);
        }
        
        return minsum;
    }

	
	// with O(n^2) time and O(1) space
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	    
        for (int i=triangle.size()-2; i>=0; i--){
            for (int j=0; j<i+1; ++j){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
            
        return triangle.get(0).get(0);
    }
	
	
	public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle==null || triangle.size()==0 || triangle.get(0).size()==0) return 0;
        if(triangle.size()==1) return triangle.get(0).get(0);
        int sum=recusive(0, 0, triangle);
        return sum;
    }
    
    public int recusive(int row, int c, ArrayList<ArrayList<Integer>> triangle){
        if(row==triangle.size()) return 0;
        int curr=triangle.get(row).get(c);
        return Math.min(recusive(row+1, c, triangle)+curr, recusive(row+1, c+1, triangle)+curr);
    }
    
    

}
