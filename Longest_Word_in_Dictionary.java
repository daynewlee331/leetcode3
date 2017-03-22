package leetcode3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Longest_Word_in_Dictionary {
	public String findLongestWord(String s, List<String> d) {
        if(s == null || d == null) return "";
        Collections.sort(d, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o1.length() != o2.length()? o2.length() - o1.length() : o1.compareTo(o2);
			}
        });
        for(String word: d){
        		int i = 0;
        		for(char c: s.toCharArray()){
        			if(i < word.length() && c == word.charAt(i)) i ++;
        		}
        		if(i == word.length()) return word;
        }
        return "";
    }
}
