package leetcode3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class first_bad_version {
	
	public int firstBadVersion(int n) {
        int i = 1;
        int j = n;
        while(i < j){
            int mid = i + (j-i) / 2;
            if(isBadVersion(mid)) j = mid;
            else i = mid + 1;
        }
        return i;
    }
	public boolean isBadVersion(int n ){
		return false;
	}
}
