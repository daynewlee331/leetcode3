package leetcode3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Diagonal_Traverse {
	
	public static void main(String[] args){
		Diagonal_Traverse sol = new Diagonal_Traverse();
		int[][] m = {{1,2,3},
					 {4,5,6},
					 {7,8,9}};
		sol.findDiagonalOrder(m);
	}
	
	/*
	 * If out of bottom border (row >= m) then row = m - 1; col += 2; change walk direction.
	 * if out of right border (col >= n) then col = n - 1; row += 2; change walk direction.
	 * if out of top border (row < 0) then row = 0; change walk direction.
	 * if out of left border (col < 0) then col = 0; change walk direction.
	 * */
	public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length < 1) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        int row = 0, col = 0, d1 = -1, d2 = 1;
        for(int i = 0; i < m * n; i ++){
        		res[i] = matrix[row][col];
        		row += d1; col += d2;
        		if(row >= m) {row = m - 1; col += 2; d1 = -1 * d1; d2 = -1 * d2;}
        		if(col >= n) {col = n - 1; row += 2; d1 = -1 * d1; d2 = -1 * d2;}
        		if(row < 0) {row = 0; d1 = -1 * d1; d2 = -1 * d2;}
        		if(col < 0) {col = 0; d1 = -1 * d1; d2 = -1 * d2;}
        }
        return res;
    }
}
