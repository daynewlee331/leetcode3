package leetcode3;

import java.util.Stack;

//assume input only contains digits, +, -, ( and )
//and assume all the parenthesis are valid 
//main idea: 1 - (1 + 2) + (3 + 4) = 1 - 1 - 2 + 3 + 4
//using a stack to store the sign (+1 / -1), once we meet a '(' push the sign to the stack
//if it is a ')' we pop out the sign
//complexity: O(n)
public class basic_calculator {
	public static void main(String[] args){
		basic_calculator sol = new basic_calculator();
		sol.calculate("  30");
	}
	
	public int calculate(String s) {
		s = s.replace(" ", "");
        int res = 0;
        int i = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        while(i < s.length()){
        	char c = s.charAt(i);
        	if(c == '+'){
        		sign = 1;
        		i ++;
        	}else if(c == '-'){
        		sign = -1;
        		i ++;
        	}else if(c == '('){
        		stack.push(sign * stack.peek());
        		i ++;
        		sign = 1;
        	}else if(c == ')'){
        		stack.pop();
        		i ++;
        		sign = 1;
        	}else{
        		int num = 0;
        		while(i < s.length() && Character.isDigit(s.charAt(i))){
        			num = num * 10 + s.charAt(i) - '0';
        			i ++;
        		}
        		res += sign * num * stack.peek();
        	}
        }
        
        return res;
    }
}
