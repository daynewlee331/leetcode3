package leetcode3;

public class NumArray {
	//assume nums length is bigger than zero
	//create a int array sum
	//sum[0] = nums[0], sum[1] = nums[0] + nums[1], ...
	//Sum range = sum[j + 1] - sum[i]
	//arr = [-2, 0, 3]
	//sums = [0, -2, -2 ,1]
	//sumRange(0, 2) => sums[3] - sums[0] = 1
	int[] sums = null;
	public NumArray(int[] nums) {
       	this.sums = new int[nums.length + 1];
        this.sums[0] = 0;
        for(int i = 1; i < sums.length; i ++){
        		this.sums[i] = nums[i - 1] + this.sums[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        return this.sums[j + 1] - this.sums[i];
    }
}
