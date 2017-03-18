package leetcode3;

public class Trap_Rain_Water {
	public int trap(int[] A) {
		if(A == null || A.length < 1) return 0;
        int max = 0;
        int leftMax = A[0], rightMax = A[A.length - 1];
        int i = 0, j = A.length - 1;
        while(i <= j){
        	leftMax = Math.max(A[i], leftMax); rightMax = Math.max(A[j], rightMax);
        	if(leftMax <= rightMax){
        		max += (leftMax - A[i ++]);
        	}else{
        		max += (rightMax - A[j --]);
        	}
        }
        return max;
    }
}
