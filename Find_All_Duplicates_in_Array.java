package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Duplicates_in_Array {
	public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length < 1) return res;
        for(int i = 0; i < nums.length; i ++){
        	int index = Math.abs(nums[i]) - 1;
        	if(nums[index] < 0) res.add(Math.abs(nums[i]));
        	else nums[index] = -nums[index];
        }
        for(int i = 0; i < nums.length; i ++){
        	nums[i] = Math.abs(nums[i]);
        }
        return res;
    }
}
