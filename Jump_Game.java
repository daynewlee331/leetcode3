package leetcode3;

public class Jump_Game {
	public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for(int i = 0; i < nums.length; i ++){
        	if(i > maxIndex || maxIndex >= nums.length - 1) break;
        	maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return maxIndex >= nums.length - 1;
    }
}
