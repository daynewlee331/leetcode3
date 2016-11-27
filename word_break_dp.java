package leetcode3;

import java.util.HashSet;
import java.util.Set;

public class word_break_dp {
	public static void main(String[] args){
		word_break_dp wb  = new word_break_dp();
		String st = "a";
		Set<String> dict = new HashSet<String>();
		//dict.add("leet");
		dict.add("a");
		//dict.add("code");
		wb.wordBreak(st, dict);
	}
	
	public boolean wordBreak(String s, Set<String> wordDict) {
		// Create the DP table to store results of subroblems. The value wb[i]
	    // will be true if str[0..i-1] can be segmented into dictionary words,
	    // otherwise false.
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = false;
        for(int i = 1; i < s.length() + 1; i ++){
        	//substring(0 -> i) is in the dict, set it to true
        	if(dp[i] == false && wordDict.contains(s.substring(0, i))){
        		dp[i] = true;
        	}
        	//if substring(0 -> i) is true, check the rest
        	if(dp[i]){
        		if(i == s.length()) return true;
        		for(int j = i + 1; j <= s.length(); j ++){
        			if(dp[j] == false && wordDict.contains(s.substring(i, j))){
        				dp[j] = true;
        			}
        			if(j == s.length() && dp[j] == true) return true;
        		}
        	}
        }
        
        return false;
    }
}
