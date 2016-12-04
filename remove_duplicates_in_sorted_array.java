package leetcode3;

public class remove_duplicates_in_sorted_array {
	public static void main(String[] args){
		int[] test = {1,2,2,3,4,4,4,4,5,5,5,6,7,7,7,7,7,8};
		remove_duplicates_in_sorted_array rd = new remove_duplicates_in_sorted_array();
		rd.removeDuplicates2(test);
	}
	
	public int removeDuplicates2(int[] nums) {
		
	}
	
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length < 1) return 0;
		if(nums.length == 1) return 1;
		int count = 0;
        int i = 0;
        int j = 1;
        boolean buff = false;
        while(j < nums.length){
        	if(nums[j] > nums[i]){
        		count ++;
        		if(buff){
        			i ++;
        			nums[i] = nums[j];
        			j = i + 1;
        			buff = false;
        			continue;
        		}
        		i ++;
            	j ++;
        	}else if(nums[j] <= nums[i]){
        		buff = true;
        		j ++;
        	}
        }
        return count + 1;
    }
}
