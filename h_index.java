package leetcode3;

import java.util.Arrays;

public class h_index {
	public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for(int i = 0; i < citations.length; i ++){
        	int tmp = Math.min(citations[i], citations.length - i);
        	if(tmp > h) h = tmp;
        }
        return h;
    }
}
