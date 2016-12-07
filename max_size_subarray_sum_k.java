package leetcode3;

import java.util.HashMap;

public class max_size_subarray_sum_k {
	public static void main(String[] args){
		int[] test = {1, -1, 5, -2, 3};
		max_size_subarray_sum_k ms = new max_size_subarray_sum_k();
		ms.maxSubArrayLen(test, 3);
	}
	
	//可以用hash表来保存前n个数的和
	//然后每次查找是否当前和与目标值之差已经存在
	//, 是的话说明找到了一个序列,然后更新最大长度大小. 
	//还有如果有相同的和, 那就不管了, 因为我们要的最长的子串, 肯定是留着前面的一个值更优.
	
	public int maxSubArrayLen(int[] nums, int k) {
		int sum = 0, max = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
			if(!map.containsKey(sum)) map.put(sum, i);
		}
		return max;
    }
}
