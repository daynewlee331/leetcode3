package leetcode3;

public class Number_of_Segments_in_String {
	public int countSegments(String s) {
        if(s == null || s.length() < 1) return 0;
        String[] a = s.split(" ");
        int count = 0;
        for(String st: a){
        		if(!st.equals(" ") && !st.equals("")) count ++;
        }
        return count;
    }
}
