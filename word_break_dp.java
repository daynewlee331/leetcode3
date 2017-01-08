package leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
	
	//leetcode 140 wordbreak 2
	public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = wordBreakHelper(s, wordDict, new HashMap<String, LinkedList<String>>());
        return res;
    }
	
	public List<String> wordBreakHelper(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map){
		if(map.containsKey(s)) return map.get(s);
		LinkedList<String> res = new LinkedList<String>();
		if(s.length() == 0){
			res.add("");
		}
		for(String st: wordDict){
			if(s.startsWith(st)){
				List<String> subList = wordBreakHelper(s.substring(st.length()), wordDict, map);
				for(String sub: subList){
					res.add(st + (sub.isEmpty()? "" : " ") + sub);
				}
			}
		}
		map.put(s, res);
		return res;
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
