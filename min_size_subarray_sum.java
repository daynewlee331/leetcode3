package leetcode3;

public class min_size_subarray_sum {
	public static void main(String[] args){
		min_size_subarray_sum ms = new min_size_subarray_sum();
		int[] test = {1,2,3,4,5};
		//ms.minSubArrayLen(7, test);
		//ms.minSubArrayLen(11, test);
		ms.minSubArrayLen(15, test);
		//ms.minSubArrayLen(1, test);
	}
	
	public int minSubArrayLen(int s, int[] nums) {
		if(nums == null || nums.length < 1) return 0;
        int min = nums.length;
        int sum = nums[0];
        int i = 0;
        int j = 1;
        while(j < nums.length){
        	while(sum < s && j < nums.length){
        		sum += nums[j];
        		j ++;
        	}
        	while(sum >= s){
        		if((j - i) < min) {
        			min = j - i;
        			if(min == 1) return 1;
        		}
        		sum -= nums[i];
        		i ++;
        	}
        }
        if(i == 0 && j == nums.length && sum < s) return 0;
        return min;
    }
}
