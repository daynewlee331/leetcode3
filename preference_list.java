package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

public class preference_list {
	public static void main(String[] args){
		preference_list sol = new preference_list();
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		lists.add(Arrays.asList(3,5,7,9));
		lists.add(null);
		lists.add(Arrays.asList(2,3,8));
		lists.add(Arrays.asList());
		lists.add(Arrays.asList(5,8));
		String res = sol.getPreference(lists);
		System.out.println(res);
	}
	
	/*
	HashSet<Integer> set = new HashSet<Integer>();
	
	public void test(){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(set.contains(o1) && !set.contains(o2)) return 1;
				else return 0;
			}});
	}*/
	
	public String getPreference(List<List<Integer>> lists){
		StringBuilder res = new StringBuilder();
		if(lists == null || lists.size() < 1) return res.toString();
		HashMap<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
		HashMap<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
		for(List<Integer> sub: lists){
			if(sub == null || sub.size() < 1) continue;
			else if(sub.size() == 1){
				if(!inDegree.containsKey(sub.get(0))) inDegree.put(sub.get(0), 0);
				if(!adjList.containsKey(sub.get(0))) adjList.put(sub.get(0),new ArrayList<Integer>());
			}else{
				for(int i = 0; i < sub.size() - 1; i ++){
					int cur = sub.get(i);
					int next = sub.get(i + 1);
					if(!adjList.containsKey(cur)) adjList.put(cur, new ArrayList<Integer>());
					adjList.get(cur).add(next);
					if(!inDegree.containsKey(cur)) inDegree.put(cur, 0);
					if(!inDegree.containsKey(next)) inDegree.put(next, 1);
					else inDegree.put(next, inDegree.get(next) + 1);
				}
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int node: inDegree.keySet()){
			if(inDegree.get(node) == 0) {
				res.append(node + " ");
				pq.offer(node);
			}
		}
		while(!pq.isEmpty()){
			int curNode = pq.poll();
			if(!adjList.containsKey(curNode)) continue;
			for(int neighbor: adjList.get(curNode)){
				inDegree.put(neighbor, inDegree.get(neighbor) - 1);
				if(inDegree.get(neighbor) == 0){
					res.append(neighbor + " ");
					pq.offer(neighbor);
				}
			}
		}
		return res.toString().trim();
	}
}
