package leetcode3;

public class merge_two_sorted_array {
	/*You may assume that nums1 has enough space 
	 * (size that is greater or equal to m + n) 
	 * to hold additional elements from nums2. 
	 * The number of elements initialized in nums1 and nums2 are m and n respectively.*/
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(j >= 0 && i >= 0){
            if(nums2[j] > nums1[i]){
                nums1[k --] = nums2[j --];
            }else{
                nums1[k --] = nums1[i --];
            }
        }
        while(j >= 0){
            nums1[k --] = nums2[j --];
        }
        //while(i >= 0){
        //    nums1[k --] = nums1[i --];
        //}
    }
}
