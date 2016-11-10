package leetcode3;

import java.util.ArrayList;
import java.util.HashSet;

public class perm_seq {
	public static void main(String[] args){
		perm_seq p = new perm_seq();
		String s = p.getPermutation(5, 5);
		System.out.println(s);
	}
	
	public String getPermutation(int n, int k) {
		if(n < 1 || k < 1) return "";
        int[] fact = new int[n + 1];
        fact[0] = 1;
        //e.g n = 5
        //5 choices * 4 choices * 3 * 2 * ...
        for(int i = 1; i < n; i ++){
        	fact[i] = fact[i - 1] * i;
        }
        ArrayList<Integer> numbersChoices = new ArrayList<>(); // all the digits we can choose
        for(int i = 1; i <= n; i++) {
        	numbersChoices.add(i);
        }
        StringBuilder builder = new StringBuilder();
        for(int j = n - 1; j >= 0; j --){
        	int num = (k - 1) / fact[j];
        	builder.append(numbersChoices.get(num));
        	k -= num * fact[j];
        	numbersChoices.remove(num);
        }
        return builder.toString();
    }
}
