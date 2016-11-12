package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class array_intersection {
	public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        while(i < nums1.length && j < nums2.length){
        	if(nums1[i] == nums2[j]){
        		set.add(nums1[i]);
        		i ++;
        		j ++;
        	}
        	else if(nums1[i] < nums2[j]){
        		i ++;
        	}else{
        		j ++;
        	}
        }
        int[] res = new int[set.size()];
        int count = 0;
        for(int element: set){
        	res[count] = element;
        	count ++;
        }
        return res;
    }
	
public int[] intersection2(int[] nums1, int[] nums2) {
		if(nums1 == null) return nums2;
		if(nums2 == null) return nums1;
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> res = new HashSet<Integer>();
        for(int i : nums1){
        	set.add(i);
        }
        for(int j : nums2){
        	if(set.contains(j)){
        		res.add(j);
        	}
        }
        int[] resArr = new int[res.size()];
        int count = 0;
        for(int element: res){
        	resArr[count] = element;
        	count ++;
        }
        return resArr;
    }
}
