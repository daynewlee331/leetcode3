package leetcode3;

public class num_of_islands {
	public int numIslands(char[][] grid) {
        if(grid == null || grid.length < 1) return 0;
        int count = 0;
        for(int i = 0; i < grid.length; i ++){
        	for(int j = 0; j < grid[0].length; j ++){
        		if(grid[i][j] == '1'){
        			count ++;
        			search(grid, i, j);
        		}
        	}
        }
        return count;
    }
	
	public void search(char[][] grid, int row, int col){
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
		if(grid[row][col] != '1') return;
		grid[row][col] = '*';
		search(grid, row + 1, col);
		search(grid, row - 1, col);
		search(grid, row, col + 1);
		search(grid, row, col - 1);
	}
}
