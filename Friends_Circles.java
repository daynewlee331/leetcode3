package leetcode3;

public class Friends_Circles {
	public int findCircleNum(int[][] M) {
        if(M == null || M.length < 1) return 0;
        int[] status = new int[M.length];
        int count = 0;
        for(int i = 0; i < M.length; i ++){
        	if(status[i] == 0) {
        		search(M, status, i);
        		count ++;
        	}
        }
        return count;
    }
	public void search(int[][] M, int[] status, int cur) {
		for(int j = 0; j < M.length; j ++){
			if(status[j] == 0 && M[cur][j] == 1) {
				status[j] = 1;
				search(M, status, j);
			}
		}
	}
	
}
