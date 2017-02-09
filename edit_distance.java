package leetcode3;

public class edit_distance {
	//http://web.stanford.edu/class/cs124/lec/med.pdf
	public int minDistance(String s, String t) {
        if(s == null || t == null) return -1;
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		for(int i = 1; i <= s.length(); i ++) dp[i][0] = i;
		for(int j = 1; j <= t.length(); j ++) dp[0][j] = j;
		for(int i = 1; i <= s.length(); i ++){
			for(int j = 1; j <= t.length(); j ++){
				if(s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
				else{
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
				}
			}
		}
		return dp[s.length()][t.length()];
    }
	
	/*
	 * a) Insert a character
	 * b) Delete a character
	 * c) Replace a character
	 * */
	public boolean isOneEditDistance(String s, String t) {
		if(s == null || t == null) return false;
		if(Math.abs(s.length() - t.length()) > 1) return false;
		if(s.length() == t.length()) return isOneDiff(s, t);
		else{
			return s.length() < t.length()? isOneDel(s, t): isOneDel(t, s);
		}
	}
	
	public boolean isOneDiff(String s, String t){
		int cnt = 0;
		for(int i = 0; i < s.length(); i ++){
			if(s.charAt(i) != t.charAt(i)) cnt ++;
			if(cnt > 1) return false;
		}
		return cnt == 1;
	}
	
	public boolean isOneDel(String s, String t){
		int cnt = 0;
		int j = 0;
		int i = 0;
		while(i < s.length()){
			if(s.charAt(i) == t.charAt(j)){
				i ++;
				j ++;
			}
			else{
				cnt ++;
				j ++;
			}
			if(cnt > 1) return false;
		}
		return true;
	}
}
