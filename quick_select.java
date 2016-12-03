package leetcode3;

import java.util.ArrayList;

public class quick_select {
	public static void main(String[] args){
		int[] test = {7,3,8,2,5,1,4};
		quick_select qs = new quick_select();
		qs.myPartition(test, 0, test.length - 1);
		for(Integer i : test){
			System.out.print(i);
			System.out.print(" ");
		}
		//int num = qs.quickSelect(test, 0, test.length - 1, 3);
		//System.out.println(num);
	}
	
	public int findKthSmallest(int[] nums, int k) {
        if(k < 1 || k > nums.length) return -1;
        return quickSelect(nums, 0, nums.length - 1, k);
        
    }
	
	//TODO to be working on
	public int quickSelect(int[] nums, int lo, int hi, int k) {
        return 0;
    }
	
	// Utility method to swap arr[i] and arr[j]
    private void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    // Standard partition process of QuickSort().  It considers
    // the last element as pivot and moves all smaller element 
    // to left of it and greater elements to right. This function
    // is used by randomPartition()
    public int partition(int arr[], int l, int r){
        int pivot = arr[r], i = l;
        for (int j = l; j <= r - 1; j++){
            if (arr[j] <= pivot){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }
    
    //a native soluion of partition
    public int myPartition(int[] arr, int lo, int hi){
    	int pivot = arr[lo];//arr[lo] is empty right now
    	ArrayList<Integer> left = new ArrayList<Integer>();
    	ArrayList<Integer> right = new ArrayList<Integer>();
    	for(int i = lo; i <= hi; i ++){
    		if(arr[i] < pivot) left.add(arr[i]);
    		if(arr[i] > pivot) right.add(arr[i]);
    	}
    	int p = lo;
    	int q = hi;
    	for(Integer a: left){
    		arr[p] = a;
    		p ++;
    	}
    	for(Integer b: right){
    		arr[q] = b;
    		q --;
    	}
    	arr[p] = pivot;
    	return p;
    }
}
