package leetcode3;

public class search_for_a_range {
	public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = binarySearchLeft(nums, target);
        res[1] = binarySearchRight(nums, target);
        return res;
    }
	
	public int binarySearchLeft(int[] nums, int target){
		int left = 0, right = nums.length - 1;
		int index = -1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(nums[mid] < target){
				left = mid + 1;
			}else if(nums[mid] >= target){
				right = mid - 1;
			}
			if(nums[mid] == target) index = mid;
		}
		return index;
	}
	
	public int binarySearchRight(int[] nums, int target){
		int left = 0, right = nums.length - 1;
		int index = -1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(nums[mid] <= target){
				left = mid + 1;
			}else if(nums[mid] > target){
				right = mid - 1;
			}
			if(nums[mid] == target) index = mid;
		}
		return index;
	}
}
