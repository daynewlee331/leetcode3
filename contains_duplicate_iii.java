package leetcode3;

import java.util.TreeSet;


public class contains_duplicate_iii {
	
	public static void main(String[] args){
		int[] test = {1,3,1};
		contains_duplicate_iii a = new contains_duplicate_iii();
		a.containsNearbyAlmostDuplicate(test, 2, 1);
	}
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums == null || nums.length < 1 || k < 1) return false;
        TreeSet<Integer> tree = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i ++){
        	Integer ceiling = tree.ceiling(nums[i] - t);
        	Integer floor = tree.floor(nums[i] + t);
        	if((ceiling != null && ceiling <= nums[i]) || (floor != null && floor >= nums[i])){
        		return true;
        	}
        	tree.add(nums[i]);
        	if(i >= k){
        		tree.remove(nums[i - k]);
        	}
        }
        return false;
    }
}
