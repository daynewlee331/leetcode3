package leetcode3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class increasing_subsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		if(nums == null || nums.length < 1) return new ArrayList<List<Integer>>();
		searchSequence(nums, set, new ArrayList<Integer>(), 0);
		List<List<Integer>> res = new ArrayList<List<Integer>>(set);
		return res;
    }
	
	public void searchSequence(int[] nums, Set<List<Integer>> res, List<Integer> cur, int start){
		if(cur.size() >= 2) {
			res.add(new ArrayList<>(cur));
		}
		for(int i = start; i < nums.length; i ++){
			if(cur.size() == 0 || cur.get(cur.size() - 1) <= nums[i]){
				cur.add(nums[i]);
				searchSequence(nums, res, cur, i + 1);
				cur.remove(cur.size() - 1);
			}
		}
	}
}
