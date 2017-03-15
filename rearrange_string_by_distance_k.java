package leetcode3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class rearrange_string_by_distance_k {
	class Element{
	    int fre;
	    char ch;
	    public Element(char c, int x){
		    this.fre = x;
		    this.ch = c;
	    }
    }
    
public String rearrangeString(String s, int k) {
    if(s == null || s.length() < 1 || k < 0) return "";
    if(k == 0) return s;
    PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>(){
		@Override
		public int compare(Element o1, Element o2) {
			// TODO Auto-generated method stub
			if(o2.fre != o1.fre) return o2.fre - o1.fre;
			else return o1.ch - o2.ch;
		}
    });
    HashMap<Character, Element> map = new HashMap<Character, Element>();
    for(int i = 0; i < s.length(); i ++){
    		char c = s.charAt(i);
    		if(!map.containsKey(c)) map.put(c, new Element(c, 0));
    		map.get(c).fre ++;
    }
    pq.addAll(map.values());
    List<Element> buff = null;
    StringBuilder builder = new StringBuilder();
    while(!pq.isEmpty()){
    		buff = new ArrayList<Element>();
    		for(int i = 0; i < k; i ++){
    			if(builder.length() == s.length()) return builder.toString();
    			if(pq.isEmpty()) return "";
    			Element e = pq.poll();
    			builder.append(e.ch);
    			e.fre --;
    			if(e.fre > 0) buff.add(e);
    		}
    		pq.addAll(buff);
    }
    return builder.toString();
}
}
