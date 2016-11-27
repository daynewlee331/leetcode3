package leetcode3;

import java.util.HashSet;

public class word_search {
	public static void main(String[] args) {
		word_search ws = new word_search();
		char[][] board = { { 'A', 'B', 'C' }, { 'S', 'F', 'C' }, { 'A', 'D', 'E' } };
		ws.exist(board, "ABC");
	}

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length < 1 || board[0].length < 1)
			return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				boolean[][] visited = new boolean[board.length][board[0].length];
				if (search(board, word, i, j, 0, visited))
					return true;
			}
		}
		return false;
	}

	public boolean search(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
		if (index == word.length())
			return true;
		if (col >= board[0].length || row >= board.length || row < 0 || col < 0 || visited[row][col])
			return false;
		if (board[row][col] != word.charAt(index))
			return false;

		visited[row][col] = true;
		boolean res = search(board, word, row, col + 1, index + 1, visited)
				|| search(board, word, row + 1, col, index + 1, visited)
				|| search(board, word, row - 1, col, index + 1, visited)
				|| search(board, word, row, col - 1, index + 1, visited);
		visited[row][col] = false;

		return res;
	}

}
