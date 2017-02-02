package leetcode3;

import java.util.HashMap;
import java.util.HashSet;

public class contains_duplicate {
	//LC217 contains duplicate 1
	//input arrays might have duplicates
	//assume if nums == null || nums.length < 1 return false
	//create a hash set
	//traverse the array, and add the element if not existing in the hash set
	//if already existing, return true
	public boolean containsDuplicate(int[] nums) {
		if(nums == null) return false;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int num: nums){
			if(set.contains(num)) return true;
			set.add(num);
		}
		return false;
    }
	
	//k cannot be zero
	//k cannot be less than nums.length
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums == null || k == 0) return false;
        HashMap<Integer, Integer> map =  new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i ++){
        		if(map.containsKey(nums[i])){
        			if(Math.abs(i - map.get(nums[i])) <= k ) return true;
        		}
        		map.put(nums[i], i);
        }
        return false;
    }
}
