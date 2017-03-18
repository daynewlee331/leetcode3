package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class Majority_Element_Two {
	public static void main(String[] args){
		Majority_Element_Two sol = new Majority_Element_Two();
		sol.majorityElement(new int[]{7,7,8,8,8});
	}
	
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length < 1) return res;
        Integer can1 = null, can2 = null;
        int count1 = 0, count2 = 0, len = nums.length;
        for(int e: nums){
        	if(can1 != null && e == can1){
        		count1 ++;
        	}else if(can2 != null && e == can2){
        		count2 ++;
        	}else if(count1 == 0){
        		can1 = e;
        		count1 = 1;
        	}else if(count2 == 0){
        		can2 = e;
        		count2 = 1;
        	}else{
        		count1 --;
        		count2 --;
        	}
        }
        count1 = 0; count2 = 0;
        for(int e: nums){
        	if(e == can1){
        		count1 ++;
        	}else if(e == can2){
        		count2 ++;
        	}
        }
        if(count1 > (len / 3.0)) res.add(can1);
        if(count2 > (len / 3.0)) res.add(can2);
        return res;
    }
}
