package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class friends_network {
	public static void main(String[] args){
		friends_network sol = new friends_network();
		List<List<Integer>> adjList = new ArrayList<List<Integer>>();
		adjList.add(Arrays.asList(1, 2));
		adjList.add(Arrays.asList(2));
		adjList.add(Arrays.asList(3));
		adjList.add(Arrays.asList(1));
		String path = sol.shortestPath(adjList, 0, 3);
		System.out.println(path);
	}
	
	class Node{
		int label;
		int distance;
		Node(int l, int d){
			this.label = l;
			this.distance = d;
		}
	}
	
	public String shortestPath(List<List<Integer>> adjList, int start, int end){
		TreeSet<Node> pq = new TreeSet<Node>(new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) { return o1.distance - o2.distance; }
		});
		
		int[] prev = new int[adjList.size()];
		int[] dist = new int[adjList.size()];
		
		for(int i = 0; i < adjList.size(); i ++){
			prev[i] = adjList.size() + 1;
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;
		
		for(int i = 0; i < adjList.size(); i ++) {
			if(i == start){
				pq.add(new Node(i, 0));
			}else{
				pq.add(new Node(i, Integer.MAX_VALUE));
			}
		}
		
		while(!pq.isEmpty()){
			Node u = pq.first();
			pq.remove(u);
			for(int neighbor: adjList.get(u.label)){
				int weight = (neighbor - u.label) * (neighbor - u.label);
				if(dist[neighbor] > dist[u.label] + weight){
					dist[neighbor] = dist[u.label] + weight;
					prev[neighbor] = u.label;
					pq.add(new Node(neighbor, dist[neighbor]));
				}
			}
		}
		
		String path = end + "-";
		while(prev[end] != adjList.size() + 1){
			path +=  prev[end] + "-";
			end = prev[end];
		}
		return path;
	}
}
