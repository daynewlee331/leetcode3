package leetcode3;

public class Jump_Game_Two {
	public int jump(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        int curMax = 0, jump = 0, i = 0;
        while(curMax < nums.length){
        	int lastMax = curMax;
        	while(i <= lastMax){
        		curMax = Math.max(curMax, i + nums[i ++]);
        	}
        	jump ++;
        }
        return jump;
    }
}
