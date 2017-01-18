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
		if(nums == null || nums.length < 3) return res;
		Arrays.sort(nums);
		for(int i = 0; i <= nums.length - 3; i ++){
			if(i - 1 >= 0 && nums[i] == nums[i - 1]) continue; //avoid duplicates
			if(nums[i] > 0) break;
			int p = i + 1;
			int q = nums.length - 1;
			while(p < q){
				int sum = nums[i] + nums[p] + nums[q];
				if(sum == 0){
					res.add(Arrays.asList(nums[i], nums[p], nums[q]));
					p ++;
					q --;
					while(p < q && nums[p] == nums[p - 1]) p ++; //avoid duplicates
					while(p < q && nums[q] == nums[q + 1]) q --; //avoid duplicates
				}else if(sum < 0){
					p ++;
				}else{
					q --;
				}
			}
		}
		
		return res;
	}
}
