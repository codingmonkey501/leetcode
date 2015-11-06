package interview.leetcode.bfs;

import interview.leetcode.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SurroundedRegions {

	
	/**
	 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

		A region is captured by flipping all 'O's into 'X's in that surrounded region.
		
		For example,
		X X X X
		X O O X
		X X O X
		X O X X
		After running your function, the board should be:
		
		X X X X
		X X X X
		X X X X
		X O X X
	 */

	public void solve(char[][] board) {

		if (board.length == 0)
			return;
		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < n; i++) {
			bfs(board, 0, i);
			bfs(board, m - 1, i);
		}
		for (int j = 1; j < m - 1; j++) {
			bfs(board, j, 0);
			bfs(board, j, n - 1);
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == '+')
					board[i][j] = 'O';
			}
		}

	}

	private void bfs(char[][] board, int i, int j) {

		Queue<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
		Pair<Integer, Integer> start = new Pair<Integer, Integer>(i, j);

		if (isValid(start, board)) {
			board[i][j] = '+';
			queue.add(start);
		}
		while (!queue.isEmpty()) {
			Pair<Integer, Integer> cur = queue.poll();
			List<Pair<Integer, Integer>> newStates = stateExtend(cur, board);
			for (Pair<Integer, Integer> s : newStates)
				queue.add(s);
		}
	}

	private List<Pair<Integer, Integer>> stateExtend(Pair<Integer, Integer> state, char[][] board) {

		List<Pair<Integer, Integer>> newStatesList = new LinkedList<Pair<Integer, Integer>>();
		int x = state.getLeft();
		int y = state.getRight();
		Pair<Integer, Integer>[] newStates = new Pair[] { new Pair<Integer, Integer>(x - 1, y), new Pair<Integer, Integer>(x + 1, y), new Pair<Integer, Integer>(x, y - 1), new Pair<Integer, Integer>(x, y + 1) };

		for (int k = 0; k < 4; ++k) {
			if (isValid(newStates[k], board)) {
				board[newStates[k].getLeft()][newStates[k].getRight()] = '+';
				newStatesList.add(newStates[k]);
			}
		}
		return newStatesList;
	}

	// is x, y occupied by 'O'?
	private boolean isValid(Pair<Integer, Integer> state, char[][] board) {

		int m = board.length;
		int n = board[0].length;
		int x = state.getLeft();
		int y = state.getRight();
		if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O')
			return false;
		return true;
	}

	

}

