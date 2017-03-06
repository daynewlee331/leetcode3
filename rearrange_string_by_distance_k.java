package leetcode3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class rearrange_string_by_distance_k {
	public static void main(String[] args){
		rearrange_string_by_distance_k sol = new rearrange_string_by_distance_k();
		String test = "aaabc";
		String res = sol.rearrangeString(test, 2);
		System.out.println(res);
	}
	
	public String rearrangeString(String s, int k) {
        if(s == null || s.length() < 1 || k < 1) return "";
        HashMap<Character, Node> map = new HashMap<>();
        for(int i = 0; i < s.length(); i ++){
        		char c = s.charAt(i);
        		if(!map.containsKey(c)) map.put(c, new Node(c, 0));
        		map.get(c).count ++;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o2.count == o1.count) return o1.ch - o2.ch;
				else return o2.count - o1.count;
			}});
        
        pq.addAll(map.values());
        StringBuilder builder = new StringBuilder();
        List<Node> buffer = new ArrayList<Node>();
        while(!pq.isEmpty()){
        		buffer.clear();
        		for(int i = 0; i < k; i ++){
        			if(builder.length() == s.length()) return builder.toString();
        			if(pq.isEmpty()) return "";
        			Node e = pq.poll();
        			e.count --;
        			builder.append(e.ch);
        			if(e.count > 0)	buffer.add(e);
        		}
        		pq.addAll(buffer);
        }
        return builder.toString();
    }
	
	class Node{
		int count = 0;
		char ch = '*';
		public Node(char c, int x){
			this.ch = c;
			this.count = x;
		}
	}
}
