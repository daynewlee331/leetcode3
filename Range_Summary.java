package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class Range_Summary {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if(nums == null || nums.length < 1) return res;
		Integer[] tmp = new Integer[2];
		Integer prev = nums[0];
		tmp[0] = nums[0];
		for(int i = 1; i < nums.length; i ++){
			if(nums[i] == prev + 1){
				prev = nums[i];
				tmp[1] = nums[i];
			}else{
				if(tmp[0] != null && tmp[1] == null) res.add(tmp[0] + "");
				if(tmp[0] != null && tmp[1] != null) res.add(tmp[0] + "->" + tmp[1]);
				prev = nums[i];
				tmp[0] = nums[i];
				tmp[1] = null;
			}
		}
		if(tmp[0] != null && tmp[1] == null) res.add(tmp[0] + "");
		if(tmp[0] != null && tmp[1] != null) res.add(tmp[0] + "->" + tmp[1]);
		return res;
    }
}
