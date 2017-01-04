package leetcode3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/* *** *** */
public class Valid_Parentheses {
	public static void main(String[] args){
		Valid_Parentheses vp = new Valid_Parentheses();
		List<String> res = vp.generateParenthesis(4);
		for(String s: res){
			System.out.print(s + " ");
		}
	}
	
	//leetcode 22. Generate Parentheses
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generateParenthesisHelper(n, n, new StringBuilder(), res);
        return res;
    }
	
	public void generateParenthesisHelper(int left, int right
			, StringBuilder cur, List<String> res){
		if(left > right) return;
		if(left == 0 && right == 0){
			String s = cur.toString();
			res.add(s);
			return;
		}
		
		if(left - 1 >= 0){
			cur.append('(');
			generateParenthesisHelper(left - 1, right, cur, res);
			cur.setLength(cur.length() - 1);
		}
		if(right - 1 >= 0){
			cur.append(')');
			generateParenthesisHelper(left, right - 1, cur, res);
			cur.setLength(cur.length() - 1);
		}
	}
	
	//leetcode 20. Valid Parentheses
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
