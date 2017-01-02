package leetcode3;

import java.util.Arrays;

public class h_index {
	//leecode: 274. H-Index
	//A scientist has index h if h of his/her N papers have at least h citations each, 
	//and the other N − h papers have no more than h citations each.
	public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for(int i = 0; i < citations.length; i ++){
        	int tmp = Math.min(citations[i], citations.length - i);
        	if(tmp > h) h = tmp;
        }
        return h;
    }
	
	//leetcode 275. H-Index II
	public int hIndexSorted(int[] citations) {
		int len = citations.length;
        int left = 0; int right = len - 1; 
        while(left <= right){
        	int mid = (left - right) / 2 + right;
        	if(citations[mid] == len - mid) return citations[mid];
        	else if(citations[mid] > (len - mid)) right = mid - 1;
        	else left = mid + 1;
        }
        return len - right - 1;
    }
}
