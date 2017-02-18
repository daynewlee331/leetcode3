package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
        if(n < 1) return res;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i ++){
        	for(int j = 0; j < n; j ++){
        		board[i][j] = '.';
        	}
        }
        solve(board, 0, res, n);
        return res;
    }
	
	public void solve(char[][] board, int row, List<List<String>> res, int n){
		if(row == n){
			List<String> sub = new ArrayList<String>();
			for(int i = 0; i < n; i ++) sub.add(new String(board[i]));
			res.add(sub);
		}
		for(int col = 0; col < n; col ++){
			if(isValid(board, row, col, n)){
				board[row][col] = 'Q';
				solve(board, row + 1, res, n);
				board[row][col] = '.';
			}
		}
	}
	
	public boolean isValid(char[][] board, int row, int col, int n){
		for(int i = 0; i < n; i ++){
			if(board[i][col] == 'Q') return false;
		}
		for(int i = 0; i < n; i ++){
			if(board[row][i] == 'Q') return false;
		}
		
		int i = row, j = col;
		while(i < n && j < n){
			if(board[i][j] == 'Q') return false;
			i ++;
			j ++;
		}
		
		i = row;
		j = col;
		while(i >= 0 && j >= 0){
			if(board[i][j] == 'Q') return false;
			i --;
			j --;
		}
		
		i = row;
		j = col;
		while(i < n && j >= 0){
			if(board[i][j] == 'Q') return false;
			i ++;
			j --;
		}
		
		i = row;
		j = col;
		while(i >= 0 && j < n){
			if(board[i][j] == 'Q') return false;
			i --;
			j ++;
		}
		return true;
	}
}
