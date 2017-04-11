package leetcode3;

import java.util.Arrays;

public class Missing_Number {
	public static void main(String[] args){
		Missing_Number sol = new Missing_Number();
		System.out.println(sol.missingNumber(new int[]{2,4,6,10}, 2, 2));
		System.out.println(sol.missingNumber(new int[]{2,4,6,8}, 2, 2));
		System.out.println(sol.missingNumber(new int[]{5,8,11,17}, 5, 3));
		System.out.println(sol.missingNumber(new int[]{0,3,6,9,15}, 0, 3));
	}
	
	//Leetcode 268
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
        //if(nums == null || nums.length < 1) return res;
        int i = 0, j = nums.length - 1;
        while(i < j){
        		int mid = (j - i) / 2 + i;
        		if(mid == nums[mid]){
        			i = mid + 1;
        		}else{
        			j = mid - 1;
        		}
        }
        return i == nums[i]? i + 1: i;
    }
	
	//Turbonomic interview question
	public int missingNumber(int[] nums, int start, int diff) {
        int i = 0, j = nums.length - 1;
        while(i < j){
        		int mid = (j - i) / 2 + i;
        		int num = (mid - 0) * diff + start;
        		if(num == nums[mid]){
        			i = mid + 1;
        		}else{
        			j = mid - 1;
        		}
        }
        int num = (i - 0) * diff + start;
        return num == nums[i]? num + diff: num;
    }
}
