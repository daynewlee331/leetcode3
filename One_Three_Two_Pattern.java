package leetcode3;

import java.util.Stack;

public class One_Three_Two_Pattern {
	public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        Integer Two = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = nums.length - 1; i >= 0; i --){
        	int One = nums[i];
        	if(One < Two) return true;
        	else{
        		while(!stack.isEmpty() && One > stack.peek()){
        			Two = stack.peek(); //we have Two now
        			stack.pop();
        		}
        	}
        	//We have Two now, and current One is bigger than Two
        	//so current one becomes Three and gets pushed in the stack
        	stack.push(One);
        	//we will look for One which is smaller than current Two in next loop
        }
        return false;
    }
}
