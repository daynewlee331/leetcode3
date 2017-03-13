package leetcode3;

public class Range_Addition {
	public int[] getModifiedArray(int length, int[][] updates) {
		int[] res = new int[length];
        for(int[] sub: updates){
        	res[sub[0]] += sub[2];
        	if(sub[1] + 1 < length) res[sub[1] + 1] -= sub[2];
        }
        
        for(int i = 1; i < length; i ++){
        	res[i] += res[i - 1];
        }
        
        return res;
    }
}
