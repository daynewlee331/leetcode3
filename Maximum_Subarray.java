package leetcode3;

public class Maximum_Subarray {
	public int maxSubArray(int[] nums) {
        int min = 0, sum = 0, res = nums[0];
        for(int e: nums){
        	sum += e;
        	if(sum - min > res) res = sum - min;
        	if(sum < min) min = sum;
        }
        return res;
    }
	
	public int[] maximumSubArray(int[] nums){
		int min = 0, sum = 0, res = nums[0], left = 0, right = 0;
		for(int i = 0; i < nums.length; i ++){
			sum += nums[i];
			if(sum - min > res) { res = sum - min; right = i; }
			if(sum < min) { min = sum; left = i; }
		}
		return new int[]{left, right};
	}
}
