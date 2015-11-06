package interview.leetcode.dfs;

import java.util.ArrayList;

public class NQueens {

	
	/**
	 * The n-queens puzzle is the problem of placing n queens on an n×n
	 * chess board such that no two queens attack each other.
	 * 
	 * Given an integer n, return all distinct solutions to the n-queens puzzle.
	 * 
	 * Each solution contains a distinct board configuration of the n-queens'
	 * placement, where 'Q' and '.' both indicate a queen and an empty space
	 * respectively.
	 * 
	 * For example, There exist two distinct solutions to the 4-queens puzzle:
	 * 
	 * [
		 [".Q..",  // Solution 1
		  "...Q",
		  "Q...",
		  "..Q."],
		
		 ["..Q.",  // Solution 2
		  "Q...",
		  "...Q",
		  ".Q.."]
		]
	 */
	public static void main(String[] args) {
		NQueens n=new NQueens();
		n.solveNQueens(4);
		
	}
	
	//solution 1
	public ArrayList<String[]> solveNQueens(int n) {

		ArrayList<String[]> result = new ArrayList<String[]>();

		// which column i and row num : which locate the queens
		int[] C = new int[n];
		for (int i = 0; i < C.length; i++)
			C[i] = -1;
		dfs(C, result, 0);
		return result;
	}

	private void dfs(int[] C, ArrayList<String[]> result, int r) {

		int N = C.length;
		if (r == N) {
			addSolution(C, result, N);
			return;
		}

		// try columns
		for (int c = 0; c < N; ++c) {
			if (isValid(C, r, c)) {
				C[r] = c;
				dfs(C, result, r + 1);
			}
		}

		if (r > 0)
			C[r - 1] = -1;
	}

	private boolean isValid(int[] tmpCol, int currow, int currcol) {

		for (int i = 0; i < currow; i++) {
			// in the same column
			if (tmpCol[i] == currcol 
				// in the same diag
				|| Math.abs(currcol - tmpCol[i]) == (currow - i)) 
				
				return false;
		}
		return true;
	}

	
	
	
	// solution 2
	int[] columns;
	int[] maindiag;
	int[] antidiag;

	public ArrayList<String[]> solveNQueens2(int n) {

		this.columns = new int[n];
		this.maindiag = new int[2 * n];
		this.antidiag = new int[2 * n];
		ArrayList<String[]> result = new ArrayList<String[]>();
		int[] C = new int[n];
		dfs2(C, result, 0);
		return result;
	}

	void dfs2(int[] C, ArrayList<String[]> result, int r) {

		int N = C.length;
		if (r == N) {
			addSolution(C, result, N);
			return;
		}

		for (int c = 0; c < N; ++c) {
			boolean ok = columns[c] == 0 && maindiag[r + c] == 0 && antidiag[r - c + N] == 0;
			if (!ok)
				continue;

			C[r] = c;
			columns[c] = maindiag[r + c] = antidiag[r - c + N] = 1;
			dfs2(C, result, r + 1);
			// C[row] = 0;
			columns[c] = maindiag[r + c] = antidiag[r - c + N] = 0;
		}
    }
	
	private void addSolution(int[] C, ArrayList<String[]> result, int N) {

		String[] solution = new String[N];
		for (int i = 0; i < N; ++i) {
			char[] s = new char[N];
			for (int j = 0; j < N; ++j) {
				if (j == C[i])
					s[j] = 'Q';
				else
					s[j] = '.';
			}
			solution[i] = new String(s);
		}
		result.add(solution);
	}
}
