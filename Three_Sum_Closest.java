package leetcode3;

import java.util.Arrays;

public class Three_Sum_Closest {
	public int threeSumClosest(int[] nums, int target) {
		Integer res = null;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i ++){
        	if(i - 1 >= 0 && nums[i - 1] == nums[i]) continue;
        	int p = i + 1, q = nums.length - 1;
        	while(p < q){
        	    int sum = nums[i] + nums[p] + nums[q];
        	    if(res == null) res = sum;
        		if(sum == target) return target;
        		if(Math.abs(res - target) > Math.abs(sum - target)) res = sum;
        		else if(sum < target){
        			p ++;
        		}else{
        			q --;
        		}
        	}
        }
        return res;
    }
}
