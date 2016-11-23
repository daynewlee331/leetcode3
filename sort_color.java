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
		int i = 0;
		while(i <= right){
			if(nums[i] == 0){
				swap(i, left, nums);
				i ++;
				left ++;
			}else if(nums[i] == 1){
				i ++;
			}else if(nums[i] == 2){ //blue
				swap(i, right, nums);
				right --;
			}
		}
	}
	
	public void swap(int i, int j, int[] arr){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
