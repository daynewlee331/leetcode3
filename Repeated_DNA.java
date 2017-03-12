package leetcode3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Repeated_DNA {
	public static void main(String[] args){
		Repeated_DNA sol = new Repeated_DNA();
		sol.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
	}
	
	public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() < 1) return new ArrayList<String>();
        HashSet<String> seen = new HashSet<String>(), set = new HashSet<String>() ;
        for(int i = 0; i + 9 < s.length(); i ++){
        	String DNA = s.substring(i, i + 10);
        	if(!seen.add(DNA)) set.add(DNA);
        }
        return new ArrayList<>(set);
    }
}
