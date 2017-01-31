package leetcode3;

public class search_index_equals_element {
	
	//input array doesn't contain duplicate
	//input array might be null
	//length of input array might be less than 1
	//naive solution to traverse the array, which is O(n)
	//we can use binary search
	public int searchIndex(int[] a){
		if(a == null || a.length < 1) return -1;
		int left = 0;
		int right = a.length - 1;
		while(left <= right){
			int mid = (right - left) / 2 + left; //avoid overflow
			if(a[mid] == mid) return mid;
			else if(a[mid] < mid) left = mid + 1;
			else right = mid - 1;
		}
		return -1;
	}
	
	//value: -3 1 1 1 1 6
	//index:  0 1 2 3 4 5
}
