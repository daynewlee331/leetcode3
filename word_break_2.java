package leetcode3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class word_break_2 {
	public static void main(String[] args){
		word_break_2 sol = new word_break_2();
		sol.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"});
	}
	
	public List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie();
		HashSet<String> set = new HashSet<String>();
		if(board == null || board.length < 1 || words == null || words.length < 1) return new ArrayList<String>();
		for(String word: words) trie.insert(word);
		boolean[][] visited = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i ++){
			for(int j = 0; j < board[0].length; j ++){
				DFS(board, trie, i, j, "", set, visited);
			}
		}
		return new ArrayList<String>(set);
	}
	
	public void DFS(char[][] board, Trie trie, int row, int col, String cur, HashSet<String> set, boolean[][] visited){
		if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return;
		if(visited[row][col]) return;
		cur += board[row][col];
		if(!trie.startsWith(cur)) return;
		if(trie.search(cur)){
			set.add(cur);
		}
		visited[row][col] = true;
		DFS(board, trie, row - 1, col, cur, set, visited);
		DFS(board, trie, row + 1, col, cur, set, visited);
		DFS(board, trie, row, col - 1, cur, set, visited);
		DFS(board, trie, row, col + 1, cur, set, visited);
		visited[row][col] = false;
	}
}
