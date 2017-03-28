package leetcode3;

import java.util.Random;

public class Solution {
	private Random rand = null;
	private int[] a = null;
	
	public Solution(int[] nums) {
        this.rand = new Random();
        this.a = nums;
    }
    
    public int pick(int target) {
    	Integer res = null;
    	int count = 0;
    	for(int i = 0; i < a.length; i ++){
    		if(a[i] != target) continue;
    		else{
    			count ++;
    			int num = this.rand.nextInt(count);
    			if(num == 0) res = i;
    		}
    	}
    	return res;
    }
}
