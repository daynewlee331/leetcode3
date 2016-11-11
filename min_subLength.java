package leetcode3;

public class min_subLength {
	public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        int total = 0;
        int i = 0;int j = 0;int min = Integer.MAX_VALUE;int sum = 0;
        while(i < nums.length){
            sum += nums[i ++];
            while(sum >= s){
                sum -= nums[j ++];
                min = Math.min(min, i - j);
            }
        }
        
        return min == Integer.MAX_VALUE? 0 : min;
    }
}
