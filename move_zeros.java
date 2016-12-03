package leetcode3;

public class move_zeros {
	public static void main(String[] args){
		int[] test = {1,2,0,0,0,8,7,6,0,0,32,15,44};
		move_zeros mz = new move_zeros();
		mz.moveZeroes(test);
	}
	
	public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 1) return;
        int i = 0, j = 1;
        while(j < nums.length){
        	if(nums[i] == 0 && nums[j] != 0){//if i is zero and j is not, switch then move on
        		nums[i] = nums[j];
        		nums[j] = 0;
        		i ++;
        	}
        	if(nums[i] != 0) i ++; //if nums[i] is not zero, ignore it
        	j ++;
        }
    }
}
