package leetcode3;

public class set_matrix_zeros {
	public void setZeroes(int[][] matrix) {
        if(matrix == null) return;
        boolean fc = false, fr = false;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i ++){
        		if(matrix[i][0] == 0) fc = true;
        }
        
        for(int j = 0; j < n; j ++){
        		if(matrix[0][j] == 0) fr = true;
        }
        
        for(int i = 1; i < m; i ++){
        		for(int j = 1; j < n; j ++){
        			if(matrix[i][j] == 0) {
        				matrix[i][0] = 0;
        				matrix[i][j] = 0;
        			}
        		}
        }
        
        for(int i = 1; i < m; i ++){
        		if(matrix[i][0] == 0){
        			for(int j = 1; j < n; j ++) matrix[i][j] = 0;
        		}
        }
        
        for(int j = 1; j < n; j ++){
        		if(matrix[0][j] == 0){
        			for(int i = 1; i < m; i ++) matrix[i][j] = 0;
        		}
        }
        
        if(fc){
        		for(int i = 0; i < m; i ++) matrix[i][0] = 0;
        }
        
        if(fr){
        		for(int j = 0; j < n; j ++) matrix[0][j] = 0;
        }
    }
}
