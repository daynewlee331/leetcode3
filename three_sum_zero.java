package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class three_sum_zero {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3)
			return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while(j < k && j + 1 < k && nums[j] == nums[j + 1]) j ++;
		    while(j < k && k - 1 > j && nums[k] == nums[k - 1]) k --;
			while(j < k){
			    if(nums[i] > 0) break;
			    int sum = nums[i] + nums[j] + nums[k];
			    
				if(sum == 0){
					res.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j ++;
					k --;
				}else if(sum < 0){
					j ++;
				}else if(sum > 0){
					k --;
				}
			}
			while(nums[i] == nums[i + 1] && i < nums.length - 2) i ++;
		}
		return res;
	}
}
