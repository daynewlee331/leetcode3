package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class missing_ranges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		int left = lower;
        List<String> res = new ArrayList<String>();
        if(nums == null) return res;
        if(nums.length == 0){
        	boolean i = (lower == upper) ? res.add(lower + "") : res.add(lower + "->" + upper);
        	return res;
        }
        if(nums[0] > left && nums[0] > 1 + left) res.add(left + "->" + (nums[0] - 1));
        if(nums[0] - left == 1) res.add(left+"");
        left = nums[0];
        for(int i = 1; i < nums.length; i ++){
        	if(nums[i] != left && nums[i] > left + 1) {
        		boolean b = (left + 1 == nums[i] - 1)? res.add("" + (left + 1)) : res.add((left + 1) + "->" + (nums[i] - 1));
        	}
        	left = nums[i];
        }
        int n = nums.length - 1;
        if(upper > nums[n] && (upper > 1 + nums[n])) res.add(nums[n] + 1 + "->" + upper);
        if(upper - nums[n] == 1) res.add(upper + "");
        return res;
    }
}
