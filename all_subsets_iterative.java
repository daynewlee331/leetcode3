package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class all_subsets_iterative {
	public static void main(String[] args){
		int[] test = {1,2,3}; 
		all_subsets_iterative as = new all_subsets_iterative();
		as.subsets(test);
	}

	// leetcode 90 Subsets II
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 1) return null;
		Arrays.sort(nums);
		subsetsWithDup_helper(0, nums, res, new ArrayList<Integer>());
		return res;
	}
	
	public void subsetsWithDup_helper(int start, int[] nums, List<List<Integer>> res, List<Integer> cur){
		res.add(new ArrayList<>(cur));
		if(cur.size() > nums.length) return;
		for(int i = start; i < nums.length; i ++){
			if(i > start && nums[i] == nums[i - 1]) continue;
			cur.add(nums[i]);
			subsetsWithDup_helper(i + 1, nums, res, cur);
			cur.remove(cur.size() - 1);
		}
	}
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for(int num : nums){
        	int size = res.size();
        	for(int i = 0; i < size; i ++){
        		List<Integer> newList = new ArrayList<Integer>();
        		newList.addAll(res.get(i));
        		newList.add(num);
        		res.add(newList);
        	}
        }
        return res;
	}
	
	//solution 2
	public List<List<Integer>> subsets_recursion(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        List<Integer> arr = new ArrayList<Integer>();
        for(int i = 1; i <= nums.length; i ++){
            backtracing(0, arr, res, i, nums);
        }
        return res;
    }
    
    public void backtracing(int index, List<Integer> current
        , List<List<Integer>> res, int num, int[] nums){
        if(num == 0){
            List<Integer> copy = new ArrayList<Integer>(current);
            res.add(copy);
            return;
        }
        for(int i = index; i < nums.length; i ++){
            current.add(nums[i]);
            backtracing(i + 1, current, res, num - 1, nums);
            current.remove(current.size() - 1);
        }
    }
}
