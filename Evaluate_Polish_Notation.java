package leetcode3;

import java.util.Stack;

public class Evaluate_Polish_Notation {
	public static void main(String[] args){
		//System.out.println(Integer.parseInt("13"));
		Evaluate_Polish_Notation sol = new Evaluate_Polish_Notation();
		String[] s = {"4", "13", "5", "/", "+"};
		int a = sol.evalRPN(s);
		System.out.println(a);
	}
	
	//assume tokens could only be +, -, *, / and numeric
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i ++){
        		String s = tokens[i];
        		if(s.equals("+")){
        			int num = stack.pop() + stack.pop();
        			stack.push(num);
        		}else if(s.equals("-")){
        			int num1 = stack.pop(), num2 = stack.pop();
        			int res = num2 - num1;
        			stack.push(res);
        		}else if(s.equals("*")){
        			int num = stack.pop() * stack.pop();
        			stack.push(num);
        		}else if(s.equals("/")){
        			int num1 = stack.pop(), num2 = stack.pop();
        			int res = num2 / num1;
        			stack.push(res);
        		}else{//numeric
        			stack.push(Integer.parseInt(s));
        		}
        }
        return stack.pop();
    }
}
