package leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class contains_duplicate {
	public static void main(String[] args){
		contains_duplicate sol = new contains_duplicate();
		sol.containsNearbyAlmostDuplicate(new int[]{-1, -1}, 1, 0);
	}
	
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
	//LC219
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums == null || k <= 0) return false;
        HashMap<Integer, Integer> map =  new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i ++){
        		if(map.containsKey(nums[i])){
        			if(Math.abs(i - map.get(nums[i])) <= k ) return true;
        		}
        		map.put(nums[i], i);
        }
        return false;
    }
	
	//LC220
	//t cannot be less than 0
	//k cannot be less than or equal 0
	//nums cannot be null or empty
	//treeMap stores value -> index
	//for each number num, if there exists num + t or num - t in the map
	//check if the abs index diff is <= k
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 1 || t < 0 || k <= 0) return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i ++){
        		if(i > k){
        			set.remove(nums[i - k - 1]);
        		}
        		Integer ceiling = set.ceiling(nums[i] - t);
        		Integer floor = set.floor(nums[i] + t);
        		
        		if((ceiling != null && ceiling <= nums[i]) 
            		    || (floor != null && floor >= nums[i])) return true;
        		set.add(nums[i]);
        }
        return false;
	}
}
