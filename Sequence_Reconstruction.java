package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Sequence_Reconstruction {
	public static void main(String[] args){
		Sequence_Reconstruction sol = new Sequence_Reconstruction();
		int[] org = new int[]{1,2,3};
		List<List<Integer>> seqs = new ArrayList<>();
		seqs.add(Arrays.asList(1,2)); seqs.add(Arrays.asList(1,3)); seqs.add(Arrays.asList(2,3)); 
		boolean a = sol.sequenceReconstruction(org, seqs);
		System.out.println(a);
	}
	
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if(org == null || seqs == null) return false;
        HashMap<Integer, Set<Integer>> adjList = new HashMap<Integer, Set<Integer>>();
        HashMap<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
        for(List<Integer> sub: seqs){
        	if(sub.size() == 1){
        		if(!inDegree.containsKey(sub.get(0))) inDegree.put(sub.get(0), 0);
        		if(!adjList.containsKey(sub.get(0))) adjList.put(sub.get(0), new HashSet<Integer>());
        	}else{
        		for(int i = 1; i < sub.size(); i ++){
            		int sink = sub.get(i); int src = sub.get(i - 1);
            		if(!inDegree.containsKey(src)) inDegree.put(src, 0);
            		if(!inDegree.containsKey(sink)) inDegree.put(sink, 0);
            		if(!adjList.containsKey(src)) adjList.put(src, new HashSet<Integer>());
            		if(!adjList.get(src).contains(sink)) inDegree.put(sink, inDegree.get(sink) + 1);
            		adjList.get(src).add(sink);
            	}
        	}
        }
        int index = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int e: inDegree.keySet()){
        	if(inDegree.get(e) == 0) queue.offer(e);
        }
        while(!queue.isEmpty()){
        	int size = queue.size();
        	if(size > 1) return false;
        	int node = queue.poll();
        	if(index == org.length || org[index] != node) return false;
        	index ++;
        	if(adjList.containsKey(node)){
        		for(int neighbor: adjList.get(node)){
            		inDegree.put(neighbor, inDegree.get(neighbor) - 1);
            		if(inDegree.get(neighbor) == 0) queue.offer(neighbor);
            	}
        	}
        }
        return index == org.length && index == inDegree.size();
    }
}
