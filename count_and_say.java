package leetcode3;

public class count_and_say {
	public static void main(String[] args){
		count_and_say cs = new count_and_say();
		String s = cs.countAndSay(-1);
		System.out.println(s);
	}
	
	public String countAndSay(int n) {
        String prev = "1";
        if(n <= 1) return prev;
        StringBuilder builder = new StringBuilder();
        for(int i = 2; i <= n; i ++){
        	int j = 1;
        	char buff = prev.charAt(0);
        	int count = 1;
        	while(j < prev.length()){
        		char tmp = prev.charAt(j);
        		if(tmp == buff){
        			count ++;
        		}else{
        			builder.append(count);
        			builder.append(buff);
        			count = 1;
        		}
        		j ++;
        		buff = tmp;
        	}
        	if(j == prev.length()){
        		builder.append(count);
        		builder.append(buff);
        	}
        	prev = builder.toString();
        	builder.setLength(0);
        }
        return prev.toString();
    }
}
