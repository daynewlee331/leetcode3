package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class palindrome_pairs {
	public static void main(String[] args){
		palindrome_pairs sol = new palindrome_pairs();
		sol.palindromePairs(new String[]{"lls", "s", "sssll"});
	}
	
	/**
	 * 
	 * Case1: If s1 is a blank string, then for any string that is palindrome s2, s1+s2 and s2+s1 are palindrome.
	 * Case2: If s2 is the reversing string of s1, then s1+s2 and s2+s1 are palindrome.
	 * Case3: If s1[0:cut] is palindrome and there exists s2 is the reversing string of s1[cut+1:] , then s2+s1 is palindrome.
	 * Case4: Similiar to case3. If s1[cut+1: ] is palindrome and there exists s2 is the reversing string of s1[0:cut] , then s1+s2 is palindrome.
	 */
	
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(words == null || words.length < 1) return res;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		//build the map save the key-val pairs: String - idx
		for(int i = 0; i < words.length; i ++){
			map.put(words[i], i);
		}
		
		//special cases: "" can be combine with any palindrome string
		if(map.containsKey("")){
			int blank = map.get("");
			for(int i = 0; i < words.length; i ++){
				if(i == blank) continue;
				if(isPalindrome(words[i])){
					res.add(Arrays.asList(i, blank));
					res.add(Arrays.asList(blank, i));
				}
			}
		}
		
		//find all string and available reverse string in map
		//insert pairs
		for(int i = 0; i < words.length; i ++){
			if(words[i].equals("")) continue;
			String rev = reverse(words[i]);
			if(map.containsKey(rev)){
				int j = map.get(rev);
				if(i == j) continue;
				res.add(Arrays.asList(i, j));
			}
		}
		
		for(int i = 0; i < words.length; i ++){
			String curWord = words[i];
			for(int cut = 1; cut < curWord.length(); cut ++){
				if(isPalindrome(curWord.substring(0, cut))){
					String rev = reverse(curWord.substring(cut));
					if(map.containsKey(rev)){
						int found = map.get(rev);
						if(found == i) continue;
						res.add(Arrays.asList(found, i));
					}
				}
				if(isPalindrome(curWord.substring(cut))){
					String rev = reverse(curWord.substring(0, cut));
					if(map.containsKey(rev)){
						int found = map.get(rev);
						if(found == i) continue;
						res.add(Arrays.asList(i, found));
					}
				}
			}
		}
		
		return res;
    }
	
	public String reverse(String s){
		return new StringBuilder().append(s).reverse().toString();
	}
	
	public boolean isPalindrome(String s){
		int i = 0;
		int j = s.length() - 1;
		while(i < j){
			if(s.charAt(i) != s.charAt(j)) return false;
			i ++;
			j --;
		}
		return true;
	}
}
