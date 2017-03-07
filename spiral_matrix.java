package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class spiral_matrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if(matrix == null || matrix.length < 1) return res;
		int left = 0, right = matrix[0].length - 1;
		int upper = 0, lower = matrix.length - 1;
		while(left <= right && upper <= lower){
			for(int i = left; i <= right; i ++) res.add(matrix[upper][i]);
			upper ++;
			for(int j = upper; j <= lower; j ++) res.add(matrix[j][right]);
			right --;
			if(upper <= lower){
				for(int k = right; k >= left; k --) res.add(matrix[lower][k]);
			}
			lower --;
			if(left <= right){
				for(int l = lower; l >= upper; l --) res.add(matrix[l][left]);
			}
			left ++;
		}
		return res;
    }
}
