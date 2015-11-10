package interview.leetcode.detail;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	
	/**
	 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

		For example,
		Given the following matrix:
		
		[
		 [ 1, 2, 3 ],
		 [ 4, 5, 6 ],
		 [ 7, 8, 9 ]
		]
		You should return [1,2,3,6,9,8,7,4,5].
	 */
	
    public List<Integer> spiralOrder2(int[][] matrix) {
        
        List<Integer> list = new ArrayList<Integer>();
        int down=matrix.length;
        if (down == 0) return list;
        int right=matrix[0].length;
        int left=0;
        int up=0;
        
        while(true){
            
            for(int i=up, j=left; j<right; j++){
                list.add(matrix[i][j]);
            }
            
            up++;
            
            if(up==down) break;
            
            for(int i=up, j=right-1; i<down; i++){
                list.add(matrix[i][j]);
            }
            
            right--;
            
            if(right==left) break;
            
            for(int j=right-1, i=down-1; j>=left; j--){
                list.add(matrix[i][j]);
            }
            
            down--;
            
            if(down==up) break;
            
            for(int i=down-1, j=left; i>=up; i--){
                list.add(matrix[i][j]);
            }
            
            left++;
            
            if(left==right) break;
        }
        
        
        return list;
        
    }
	
	public List<Integer> spiralOrder(int[][] matrix) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		if (matrix.length == 0)
			return result;
		int beginX = 0, endX = matrix[0].length - 1;
		int beginY = 0, endY = matrix.length - 1;

		while (true) {
			// From left to right
			for (int j = beginX; j <= endX; ++j)
				result.add(matrix[beginY][j]);
			if (++beginY > endY)
				break;
			// From top to bottom
			for (int i = beginY; i <= endY; ++i)
				result.add(matrix[i][endX]);
			if (beginX > --endX)
				break;
			// From right to left
			for (int j = endX; j >= beginX; --j)
				result.add(matrix[endY][j]);
			if (beginY > --endY)
				break;
			// From bottom to top
			for (int i = endY; i >= beginY; --i)
				result.add(matrix[i][beginX]);
			if (++beginX > endX)
				break;

		}

		return result;
	}
}