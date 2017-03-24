package leetcode3;

import java.util.Arrays;

public class Min_Move_to_Equal_Two {
	public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2], count = 0;
        int i = 0, j = nums.length - 1;
        while(i < j){
        		count += median - nums[i];
        		count += nums[j] - median;
        		i ++;
        		j --;
        }
        return count;
    }
}
