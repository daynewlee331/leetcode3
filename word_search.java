package leetcode3;

public class word_search {
	public static void main(String[] args) {
		word_search ws = new word_search();
		char[][] board = { { 'A', 'B', 'C' }, { 'S', 'F', 'C' }, { 'A', 'D', 'E' } };
		ws.exist(board, "ABC");
	}

	public boolean exist(char[][] board, String word) {
		if(word == null || word.length() < 1 || board.length < 1) return false;
		for(int i = 0; i < board.length; i ++){
			for(int j = 0; j < board[0].length; j ++){
				if(findWord(word, i, j, 0, board)) return true;
			}
		}
		return false;
	}
	
	public boolean findWord(String word, int row, int col, int index, char[][] board){
		if(word.length() == index) return true;
		if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
		if(word.charAt(index) != board[row][col]) return false;
		char c = board[row][col];
		board[row][col] = '*';
		boolean res = findWord(word, row + 1, col, index + 1, board) ||
						findWord(word, row - 1, col, index + 1, board) ||
						findWord(word, row, col + 1, index + 1, board) ||
						findWord(word, row, col - 1, index + 1, board);
		board[row][col] = c;
		return res;
	}

}
