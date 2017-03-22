package leetcode3;

import java.util.Stack;

public class Next_Greater_Element_Two {
	public static void main(String[] args){
		Next_Greater_Element_Two sol = new Next_Greater_Element_Two();
		sol.nextGreaterElements(new int[]{1,2,5,4});
	}
	
	public int[] nextGreaterElements(int[] nums) {
		if(nums == null || nums.length < 1) return new int[0];
		Stack<Integer> stack = new Stack<>();
		int m = nums.length;
		for(int i = m - 1; i >= 0; i --){
			stack.push(nums[i]);
		}
		int[] res = new int[m];
		for(int i = m - 1; i >= 0; i --){
			res[m] = -1;
			if(stack.peek() <= nums[i]) stack.pop();
			if(stack.size() > 0) res[m] = stack.peek();
			stack.push(nums[i]);
		}
		return res;
    }
}
