package leetcode3;

import java.util.Arrays;
import java.util.Comparator;

public class Largest_Number {
	public String largestNumber(int[] nums) {
        if(nums == null || nums.length < 1) return "";
        String[] a = new String[nums.length];
        for(int i = 0; i < nums.length; i ++) a[i] = String.valueOf(nums[i]);
        Arrays.sort(a, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String st1 = o1 + o2;
				String st2 = o2 + o1;
				return st2.compareTo(st1);
			}
        });
        if(a[0].equals("0")) return "0";
        StringBuilder builder = new StringBuilder();
        for(String s: a) builder.append(s);
        return builder.toString();
    }
}
