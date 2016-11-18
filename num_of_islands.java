package leetcode3;

public class num_of_islands {
	public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == '1'){
                    count ++;
                    numIslandsHelper(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public void numIslandsHelper(char[][] grid, int i, int j){
        grid[i][j] = '0';
        if(i - 1 >= 0 && grid[i - 1][j] == '1'){
            numIslandsHelper(grid, i - 1, j);
        }
        if(i + 1 < grid.length && grid[i + 1][j] == '1'){
            numIslandsHelper(grid, i + 1, j);
        }
        if(j - 1 >= 0 && grid[i][j - 1] == '1'){
            numIslandsHelper(grid, i, j - 1);
        }
        if(j + 1 < grid[0].length && grid[i][j + 1] == '1'){
            numIslandsHelper(grid, i, j + 1);
        }
    }
}
