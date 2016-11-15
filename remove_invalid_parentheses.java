package leetcode3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class remove_invalid_parentheses {
	public static void main(String[] args){
		String s = "a(b)((";
		//remove_invalid_parentheses r = new remove_invalid_parentheses();
		//HashSet<String> set = new HashSet<String>();
		//r.stringGenerator(s, 2, set);
		//System.out.println();
		//r.removeInvalidParentheses(s);
	}
	
	public List<String> removeInvalidParentheses(String s) {
		HashSet<String> set = new HashSet<String>();
		HashSet<String> wordList = null;
		for(int i = 0; i<= s.length(); i ++){//remove from 1 to s.length characters
			wordList = new HashSet<String>();
			stringGenerator(s, i, wordList);
			for(String element: wordList){
				
			}
			if(set.size() != 0){
				break;
			}
		}
		List<String> res = new ArrayList<String>(set);
		return res;
	}
	
	public void stringGenerator(String s, int num, HashSet<String> set){
		if(num == 0){
			String copy = new String(s);
			set.add(copy);
			return;
		}
		StringBuilder builder = null;
		for(int i = 0; i < s.length(); i ++){
			builder = new StringBuilder(s);
			builder.deleteCharAt(i);
			stringGenerator(builder.toString(), num - 1, set);
		}
	}
	
	
	public boolean isValid(String s) {
        if(s == null || s.length() < 1) return false;
        Stack<Character> stack = new Stack<Character>(); 
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '}'){
                if(stack.size() == 0) return false;
                char t = stack.pop();
                if(t != '{') return false;
            }else if(c == ']'){
                if(stack.size() == 0) return false;
                char t = stack.pop();
                if(t != '[') return false;
            }else if(c == ')'){
                if(stack.size() == 0) return false;
                char t = stack.pop();
                if(t != '(') return false;
            }else if(c == '('){
                stack.push(c);
            }else if(c == '['){
                stack.push(c);
            }else if(c == '{'){
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }
}
