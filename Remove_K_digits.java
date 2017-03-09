package leetcode3;

import java.util.Stack;

public class Remove_K_digits {
	public static void main(String[] args){
		Remove_K_digits sol = new Remove_K_digits();
		String res = sol.removeKdigits("1234567890", 9);
		System.out.println(res);
	}
	
	public String removeKdigits(String num, int k) {
        if(num == null || num.length() < 1) return "";
        if(num.length() == k) return "0";
        Stack<Character> stack = new Stack<>();
        stack.push(num.charAt(0));
        for(int i = 1; i < num.length(); i ++){
        	while(k > 0 && stack.size() > 0 && stack.peek() > num.charAt(i)){
        		stack.pop();
        		k --;
        	}
        	stack.push(num.charAt(i));
        }
        while(k > 0){stack.pop(); k --;}
        StringBuilder s = new StringBuilder();
        while(!stack.isEmpty()) s.append(stack.pop());
        s = s.reverse();
        while(s.length() > 0 && s.charAt(0) == '0') s.deleteCharAt(0);
        return s.length() == 0? "0": s.toString();
    }
}
