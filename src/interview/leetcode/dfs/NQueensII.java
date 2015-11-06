package interview.leetcode.dfs;

public class NQueensII {

	/**
	 * Follow up for N-Queens problem.
		Now, instead outputting board configurations, return the total number of distinct solutions.
	 */
	public static void main(String[] args) {
		NQueensII q=new NQueensII();
		
		System.out.println(q.totalNQueens(4));
	}
	
	/**
	 *
	 * Solution 3
	 * 
	 * 
	 */

	public int totalNQueens3(int n) {
        
        int[] pos = new int[n];
        for(int i=0; i<n; i++)
            pos[i]=-1;
        totalNQueens3(pos, 0, n);
        return total3;
    }
    
    int total3=0;
    
    private void totalNQueens3(int[] pos, int r, int n){
        
        if(r == n){
            total3++;
            return;
        }
        
        for(int j=0; j<n; j++){
            
            if(pos[r] == -1){
                pos[r] = j;
                if(isValid(pos, r, n))
                    totalNQueens3(pos, r+1, n);
                pos[r] = -1;    
            }
        }
        
    }
    
    boolean isValid(int[] pos, int r, int n){
        
        for (int i=0; i<n; i++){
            if(i!=r && pos[i]!=-1){
                if(pos[r] == pos[i])
                    return false;
                if(Math.abs(pos[r]-pos[i]) == Math.abs(r-i))
                    return false;
                
            }
        }
        return true;
    }   
    
	
	/**
	 * Solution 2
	 */
	public int totalNQueens(int n) {

		int[] maindiag = new int[2 * n];
		int[] antidiag = new int[2 * n];
		int[] col = new int[n];

		dfs(maindiag, antidiag, col, 0);
		return total;
	}

	int total = 0;

	public void dfs(int[] maindiag, int[] antidiag, int[] columns, int r) {

		int size = columns.length;
		if (r == size) {
			total++;
			return;
		}
		for (int c = 0; c < size; ++c) {
			boolean ok = (columns[c] == 0 && maindiag[r + c] == 0 && antidiag[r - c + size] == 0);
			if (!ok)
				continue;
			columns[c] = maindiag[r + c] = antidiag[r - c + size] = 1;
			dfs(maindiag, antidiag, columns, r + 1);
			columns[c] = maindiag[r + c] = antidiag[r - c + size] = 0;

		}
	}
	
	
	/**
	 * Follow up questions
	 * what if the board size is always 8, well the queens may be less than 8?
	 */
	public int totalNQueens2(int n) {
        
        int[] pos = new int[8];
        for(int i=0; i<8; i++)
            pos[i]=-1;
        totalNQueens(pos, 0, 0, n);
        return total2;
    }
    
    int total2=0;
    
    public void totalNQueens(int[] pos, int r, int k, int n){
        
        if(k == n){
            total2++;
            return;
        }
        
        
        for (int i=r; i<8; i++){
            for(int j=0; j<8; j++){
                
                if(pos[i] == -1){
                    pos[i] = j;
                    if(isValid(pos, i))
                        totalNQueens(pos, i+1, k+1, n);
                    pos[i] = -1;    
                }
            }
        }
        
    }
    
    boolean isValid(int[] pos, int r){
        
        for (int i=0; i<8; i++){
            if(i!=r && pos[i]!=-1){
                if(pos[r] == pos[i])
                    return false;
                if(Math.abs(pos[r]-pos[i]) == Math.abs(r-i))
                    return false;
                
            }
        }
        return true;
    }

}
