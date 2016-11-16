package leetcode3;

import java.util.HashMap;

public class two_sum_index {
	public static void main(String[] args){
		two_sum_index t = new two_sum_index();
		int[] test = {0,4,3,0};
		t.twoSum(test, 0);
	}
	public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i ++){
            int num = target- nums[i];
            if(map.containsKey(num)){
                if(i != map.get(num)){
                    int[] res = {i, map.get(num)};
                    return res;
                }
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
	
