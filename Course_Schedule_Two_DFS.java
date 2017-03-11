package leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Course_Schedule_Two_DFS {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || numCourses < 1) return new int[0];
        HashMap<Integer, Set<Integer>> adjList = new HashMap<Integer, Set<Integer>>();
        for(int[] dep: prerequisites){
        	if(!adjList.containsKey(dep[1])) adjList.put(dep[1], new HashSet<Integer>());
        	adjList.get(dep[1]).add(dep[0]);
        }
        int[] status = new int[numCourses]; //0 is unvisited, 1 is visiting, 2 is visited
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < numCourses; i ++){
        	if(!search(adjList, stack, status, i)) return new int[0];
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i ++) res[i] = stack.pop();
        return res;
    }
	
	public boolean search(HashMap<Integer, Set<Integer>> adjList, Stack<Integer> stack, int[] status, int cur){
		if(status[cur] == 2) return true;
		if(status[cur] == 1) return false;
		status[cur] = 1;
		if(adjList.containsKey(cur)){
			for(int neighbor: adjList.get(cur)){
				if(!search(adjList, stack, status, neighbor)) return false;
			}	
		}		
		status[cur] = 2;
		stack.push(cur);
		return true;
	}
}
