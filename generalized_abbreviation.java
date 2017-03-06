package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class generalized_abbreviation {
	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<String>();
		if(word == null || word.length() < 1) return res;
		searchAbbreviations("", res, 0, 0, word);
		return res;
    }
	
	public void searchAbbreviations(String cur, List<String> res, int pos, int count, String word){
		if(pos == word.length()){
			if(count > 0) cur += count;
			res.add(cur);
			return;
		}
		searchAbbreviations(cur, res, pos + 1, count + 1, word);
		searchAbbreviations(cur + (count > 0? count : "") + word.charAt(pos), res, pos + 1, 0,word);
	}
}
