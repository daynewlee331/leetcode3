package leetcode3;

import java.util.HashMap;

public class sparse_matrix_multiplication {
	
	/*
	 *       | a b c |   | l o |   | al+bm+cn  ao+bp+cq |
	 *  AB = | x y z | x | m p | = | xl+ym+zn  xo+yp+zq |
     *                   | n q |
	 * */
	public int[][] multiply(int[][] A, int[][] B) {
		if (A == null || A[0] == null || B == null || B[0] == null)
			return null;
		if (A[0].length != B.length)
			return null;

		HashMap<Integer, HashMap<Integer, Integer>> mapB = new HashMap<Integer, HashMap<Integer, Integer>>();
		int[][] res = new int[A.length][B[0].length];

		for (int p = 0; p < B.length; p++) {
			for (int q = 0; q < B[0].length; q++) {
				if (B[p][q] != 0) {
					if(mapB.containsKey(p)){
						mapB.get(p).put(q, B[p][q]);
					}else{
						HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
						tmp.put(q, B[p][q]);
						mapB.put(p, tmp);
					}
				}
			}
		}

		for (int i = 0; i < A.length; i++) {
			for (int m = 0; m < A[0].length; m++) {
				if (mapB.containsKey(m) && A[i][m] != 0) {
					for (Integer j : mapB.get(m).keySet()) {
						res[i][j] += A[i][m] * mapB.get(m).get(j);
					}
				}
			}
		}
		
		return res;
	}

}
