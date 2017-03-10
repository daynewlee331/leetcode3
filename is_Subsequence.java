package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class is_Subsequence {
	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(1,3,5,6));
		int a = Collections.binarySearch(list, 7);
		int b = Collections.binarySearch(list, 5);
		System.out.println(a + " " + b);
	}
	
	public boolean isSubsequence(String s, String t) {
        List<Integer>[] list = new List[26];
        for(int i = 0; i < t.length(); i ++){
        	char c = t.charAt(i);
        	if(list[c - 'a'] == null) list[c - 'a'] = new ArrayList<Integer>();
        	list[c - 'a'].add(i);
        }
        
        int prev = 0;
        for(int j = 0; j < s.length(); j ++){
        	char ch = s.charAt(j);
        	if(list[ch - 'a'] == null) return false;
        	int index = Collections.binarySearch(list[ch - 'a'], prev);
        	if(index < 0) index = -index - 1;
        	if(index == list[ch - 'a'].size()) return false;//not existing
        	prev = list[ch - 'a'].get(index) + 1;
        }
        return true;
    }
}
