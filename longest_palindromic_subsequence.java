package leetcode3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class longest_palindromic_subsequence {
	public static void main(String[] args){
		longest_palindromic_subsequence sol = new longest_palindromic_subsequence();
		int a = sol.longestPalindromeSubseq("bbbab");
		System.out.println(a);
	}
	
	public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() < 1) return 0;
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.offer(s);
        while(!queue.isEmpty()){
        	int size = queue.size();
        	for(int i = 0; i < size; i ++){
        		String word = queue.poll();
        		if(isPalindrome(word)) return word.length();
        		for(int j = 0; j < word.length(); j ++){
        			StringBuilder builder = new StringBuilder(word);
        			String tmp = builder.deleteCharAt(j).toString();
        			if(isPalindrome(tmp)) return tmp.length();
        			if(!visited.contains(tmp)){
        				queue.offer(tmp);
        				visited.add(tmp);
        			}
        		}
        	}
        }
        return 0;
        
    }
	
	public boolean isPalindrome(String s){
		int i = 0, j = s.length() - 1;
		while(i < j){
			if(s.charAt(i) != s.charAt(j)) return false;
			i ++;
			j --;
		}
		return true;
	}
}
