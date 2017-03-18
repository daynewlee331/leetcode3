package leetcode3;

public class Majority_Element {
	
	public int majorityElement(int[] nums) {
		Integer candidate = null;
        int count = 0;
        for(int e: nums){
        	if(count == 0){
        		candidate = e;
        		count = 1;
        	}else if(e == candidate){
        		count ++;
        	}else if(e != candidate){
        		count --;
        	}
        }
        return candidate;
    }
}
