package leetcode3;

import java.util.Stack;

public class Valid_Parentheses {
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
