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
		int i = 2;
		StringBuilder builder = new StringBuilder();
		while(i <= n){
			builder.setLength(0);
			int count = 1;
			int j = 1;
			for(; j < prev.length(); j ++){
				if(prev.charAt(j) == prev.charAt(j - 1)) count ++;
				else{
					builder.append(count);
					builder.append(prev.charAt(j - 1));
					count = 1;
				}
			}
			if(j == prev.length()){
				builder.append(count);
				builder.append(prev.charAt(j - 1));
			}
			prev = builder.toString();
			i ++;
		}
		return prev;
    }
}
