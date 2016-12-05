package leetcode3;

public class remove_duplicates_in_sorted_array {
	public static void main(String[] args){
		int[] test = {1,2,2,3,4,4,4,4,5,5,5,6,7,7,7,7,7,8};
		int[] test2 = {1,1};
		remove_duplicates_in_sorted_array rd = new remove_duplicates_in_sorted_array();
		//rd.removeDuplicates(test);
		rd.removeDuplicates2(test);
	}
	
	//80. Remove Duplicates from Sorted Array II
	public int removeDuplicates2(int[] nums) {
		//define at most k times of duplicate numbers
		final int k = 2;
		//check if it is an empty array
		if(nums.length == 0) return 0;
		//start pointer of new array
		int m = 1;
		// count the time of duplicate numbers occurence
		int count = 1;
		for(int i = 1; i < nums.length; i ++){
			if(nums[i - 1] == nums[i]){
				if(count < k){
					nums[m] = nums[i];
					m ++;
				}
				count ++;
			}else{
				count = 1;
				nums[m] = nums[i];
				m ++;
			}
		}
		return m;
	}
	
	public int myRemoveDuplicates(int[] nums){
		int i = 0;
		for(int n: nums){
			if(n != nums[i]){
				i ++;
				nums[i] = n;
			}
		}
		return i + 1;
	}
	
	//newer version
	public int removeDuplicates(int[] nums) {
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
	
	public int standardRemoveDuplicates(int[] nums) {
		int i = 1; //iterator thru array
        int j = 0; //current index
        for (; i<nums.length; i++) { 
            if (nums[i] != nums[j]) { //new number
                j++; //move current index
                nums[j] = nums[i]; //fill current index with new number
            } 
        }
    return j+1;
	}
}
