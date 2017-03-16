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
}
