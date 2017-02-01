package leetcode3;

public class NumMatrix {
	//assume the matrix doesn't change
	//matrix is m * n and m > 0 and n > 0
	//+---------------+
	//|   | |         |
	//|---+-+         |
	//|---+-+         |
	//|               |
	//+---------------+
	int[][] sums = null;
	public NumMatrix(int[][] matrix) {
		if(matrix == null || matrix.length < 1) return;
        this.sums = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 1; i < sums.length; i ++){
        		for(int j = 1; j < sums[0].length; j ++){
        			sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
        		}
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return this.sums[row1 + 1][col1 + 1] - this.sums[row2 + 1][col1] - this.sums[row1][col2 + 1] + this.sums[row1][col1];
    }
}
