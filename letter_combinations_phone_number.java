package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class letter_combinations_phone_number {
	public static void main(String[] args){
		letter_combinations_phone_number lc = new letter_combinations_phone_number();
		List<String> res = lc.letterCombinations("34");
		System.out.println();
	}
	
	public List<String> letterCombinations(String digits) {
		//HashMap<Integer, String> map = new HashMap<Integer, String>();
		List<String> res = new ArrayList<String>();
        String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits == null || digits.length() < 1) return res;
        StringBuilder builder = new StringBuilder();
        letterCombinations(digits, res, 0, letters, builder);
        return res;
	}
	
	
	public void letterCombinations(String digits, List<String> res, int index, String[] letters, StringBuilder builder){
		if(index == digits.length()){
			res.add(builder.toString());
			return;
		}
		String cur = letters[digits.charAt(index) - '0'];
		for(int i = 0; i < cur.length(); i ++){
			builder.append(cur.charAt(i));
			letterCombinations(digits, res, index + 1, letters, builder);
			builder.setLength(builder.length() - 1);
		}
	}
	
}
