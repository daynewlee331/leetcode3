package leetcode3;

public class sort_color {
	public static void main(String[] args){
		sort_color sc = new sort_color();
		int[] test = {1,0};
		sc.sortColors(test);
	}
	
	public void sortColors(int[] nums) {
		if(nums == null || nums.length < 1) return;
        int left = 0, right = nums.length - 1;
        while(left < nums.length && nums[left] == 0) left ++;
        while(right >= 0 && nums[right] == 2) right --;
        int i = left;
        while(i <= right){
        		if(nums[i] == 0){
        			swap(nums, i, left);
        			left ++;
        			i ++;
        		}else if(nums[i] == 2){
        			swap(nums, i, right);
        			right --;
        		}else{
        			i ++;
        		}
        }
	}
	
	public void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
