package leetcode3;

import java.util.HashSet;

public class Longest_Substring_Without_Repeating {
	public static void main(String[] args){
		Longest_Substring_Without_Repeating sol = new Longest_Substring_Without_Repeating();
		int a = sol.lengthOfLongestSubstring("bbbbb");
		System.out.println(a);
	}
	
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1) return 0;
        HashSet<Character> set = new HashSet<Character>();
        int i = 0, j = 0, max = 0;
        while(j < s.length()){
        	char c = s.charAt(j);
        	if(!set.contains(c)){
        		max = Math.max(max, set.size());
        		j ++;
        	}else{
        		set.remove(s.charAt(i ++));
        	}
        }
        return max;
    }
}
