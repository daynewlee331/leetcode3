package leetcode3;

public class parse_string {
	public static void main(String[] args){
		String test = "          abc      ";
		test = test.replace(" ", "");
		System.out.println(test);
	}
	//leading spaces
	//trailing spaces
	//+, - sign
	//max integer: 2147483647
	//min integer: -2147483647
	//step 1: remove leading spaces
	//step 2: set up the sign
	//step 3: get the number until first invalid char
	//step 4: check if the number is in the boundary
	public int myAtoi(String str) {
		if(str == null) return 0;
		//check if it is an empty string now
        if(str.length() < 1) return 0;
        
		int index = 0;
		//remove leading white spaces
		while(str.charAt(index) == ' ' && index < str.length()) index ++;
        int sign = 1; long total = 0;
        
        if(str.charAt(index) == '+') {
        	sign = 1;
        	index ++;
        }else if(str.charAt(index) == '-') { 
        	sign = -1;
        	index ++;
        }
        
        StringBuilder builder = new StringBuilder();
        for(int i = index; i < str.length(); i ++){
        	char c = str.charAt(i);
        	if(c >= '0' && c <= '9') builder.append(c);
        	else break;
        }
        String digits = builder.toString();
        for(int j = 0; j < digits.length(); j ++){
        	int digit = digits.charAt(j) - '0';
        	total = total * 10 + digit;
        	if(total * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        	else if(total * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        total = total * sign;
        return (int)total;
    }
}
