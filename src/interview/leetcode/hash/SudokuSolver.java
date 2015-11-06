package interview.leetcode.hash;


public class SudokuSolver {
	/**
	 * Write a program to solve a Sudoku puzzle by filling the empty cells.
		Empty cells are indicated by the character '.'.
		You may assume that there will be only one unique solution.
		A sudoku puzzle...
	 */
	
	public boolean solveSudoku(char[][] board) {

		for (int i = 0; i < 9; ++i){
			for (int j = 0; j < 9; ++j) {
				if (board[i][j] == '.') {
					for (int k = 0; k < 9; ++k) {
						board[i][j] = (char) ('1' + k);
						if (isValid(board, i, j) && solveSudoku(board))
							return true;
					}
					board[i][j] = '.';
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int r, int c) {

		char num = board[r][c];
		// check column
		for (int i = 0; i < 9; i++)
			if (i != r && board[i][c] == num)
				return false;
		// check row
		for (int j = 0; j < 9; j++)
			if (j != c && board[r][j] == num)
				return false;

		// check block
//		for (int i = 3 * (x / 3); i < 3 * (x / 3 + 1); i++)
//			for (int j = 3 * (y / 3); j < 3 * (y / 3 + 1); j++)
//				if ((i != x || j != y) && board[i][j] == num)
//					return false;
		
		//better
		int x = c / 3 * 3;
		int y = r / 3 * 3;
		
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (i + y != r && j + x != c && board[i + y][j + x] == num)
					return false;

		return true;
	}
	
}
