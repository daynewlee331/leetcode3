package leetcode3;

public class search_rotated_array {
	public static void main(String[] args){
		int[] test = {4,5,6,7,8,1,2,3};
		search_rotated_array sr = new search_rotated_array();
		sr.search(test, 8);
	}
	
	//leetcode 81. Search in Rotated Sorted Array II
	/*
	 * To explain why, consider this sorted array 1111115, which is rotated to 1151111.
	 * Assume left = 0 and mid = 3, and the target we want to search for is 5. 
	 * Therefore, the condition A[left] == A[mid] holds true, which leaves us with only two possibilities:
	 * All numbers between A[left] and A[right] are all 1's.
	 * Different numbers (including our target) may exist between A[left] and A[right].
	 * */
	public boolean search2(int[] nums, int target) {
		if(nums == null || nums.length < 1) return false;
        int i = 0;
        int j = nums.length - 1;
        while(i <= j){
            int mid = (i + j) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] < nums[i]){//mid is on the right
            	//only consider the most right part because that part is in order
            	if(target > nums[mid] && target <= nums[j]){
            		i = mid + 1;
            	}else{
            		j = mid - 1;
            	}
            }else if(nums[mid] > nums[i]){//mid is on the left
            	//only consider the most left part because it is in order
            	if(target >= nums[i] && target < nums[mid]){
            		j = mid - 1;
            	}else{
            		i = mid + 1;
            	}
            }else i ++;
        }
        
        return false;
    }
	
	//leetcode 153. Find Minimum in Rotated Sorted Array
	public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
        	int mid = (right + left) / 2;
        	if(mid > 0 && nums[mid - 1] > nums[mid]) 
        		return nums[mid];
        	if(nums[left]<= nums[mid] && nums[mid] > nums[right]){//mid is on the left
        		left = mid + 1;
        	}else{//mid is on the right
        		right = mid - 1;
        	}
        }
        return nums[left];
    }
	
	//leetcode 33. Search in Rotated Sorted Array
	public int search(int[] nums, int target) {
        if(nums == null || nums.length < 1) return -1;
        int res = -1;
        int i = 0;
        int j = nums.length - 1;
        while(i <= j){
            int mid = (i + j) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < nums[i]){//mid is on the right
            	//only consider the most right part because that part is in order
            	if(target > nums[mid] && target <= nums[j]){
            		i = mid + 1;
            	}else{
            		j = mid - 1;
            	}
            }else{//mid is on the left
            	//only consider the most left part because it is in order
            	if(target >= nums[i] && target < nums[mid]){
            		j = mid - 1;
            	}else{
            		i = mid + 1;
            	}
            }
        }
        
        return res;
    }
}
