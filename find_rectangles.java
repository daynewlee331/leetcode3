package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class find_rectangles {
	public static void main(String[] args){
		int[][] matrix = new int[][]{
			{1,1,1,1,1,1,1,1},
			{1,1,0,0,1,1,1,1},
			{1,1,0,0,1,1,1,1},
			{1,1,0,0,1,0,0,1},
			{1,1,1,1,1,0,0,1},
			{1,1,1,1,1,1,1,1}
		};
		find_rectangles sol = new find_rectangles();
		List<List<Integer>> res = sol.findAllRectangles(matrix);
		for(List<Integer> sub: res){
			System.out.println(sub.get(0) + " " + sub.get(1) + " " + sub.get(2) + " " + sub.get(3));
		}
	}
	
	public List<List<Integer>> findAllRectangles(int[][] matrix){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(matrix == null || matrix.length < 1) return res;
		HashSet<List<Integer>> visited = new HashSet<List<Integer>>();
		
		for(int i = 0; i < matrix.length; i ++){
			for(int j = 0; j < matrix[0].length; j ++){
				List<Integer> loc = new ArrayList<>(Arrays.asList(i, j));
				if(matrix[i][j] == 0 && !visited.contains(loc)){
					res.add(loc);
					search(matrix, i, j, loc, visited);
				}
			}
		}
		return res;
	}
	
	public void search(int[][] matrix, int row, int col, List<Integer> cur, HashSet<List<Integer>> set){
		if(row >= matrix.length || col >= matrix[0].length || matrix[row][col] == 1
				|| set.contains(new ArrayList<>(Arrays.asList(row, col)))) return;
		set.add(new ArrayList<>(Arrays.asList(row, col)));
		
		if(row + 1 >= matrix.length && (col + 1 < matrix[0].length && matrix[row][col + 1] == 1)){
			cur.add(row); cur.add(col);
			return;
		}
		if(col + 1 == matrix[0].length && (row + 1 < matrix.length && matrix[row + 1][col] == 1)){
			cur.add(row); cur.add(col);
			return;
		}
		if(row + 1 >= matrix.length && col + 1 >= matrix[0].length){
			cur.add(row); cur.add(col);
			return;
		}
		if((row + 1 < matrix.length && col + 1 < matrix[0].length )
				&& (matrix[row + 1][col] == 1 && matrix[row][col + 1] == 1)) {
			cur.add(row); cur.add(col);
			return;
		}
		search(matrix, row + 1, col, cur, set);
		search(matrix, row, col + 1, cur, set);
	}
}
