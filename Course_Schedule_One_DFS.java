package leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Course_Schedule_One_DFS {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses < 1 || prerequisites == null) return false;
        HashMap<Integer, Set<Integer>> adjList = new HashMap<Integer, Set<Integer>>();
        for(int[] dep: prerequisites){
        		if(!adjList.containsKey(dep[1])) adjList.put(dep[1], new HashSet<Integer>());
        		adjList.get(dep[1]).add(dep[0]);
        }
        int[] status = new int[numCourses];//0 is unvisited, 1 is visiting, 2 is visited
        for(int i = 0; i < numCourses; i ++){
        		if(!search(adjList, i, status)) return false;
        }
        return true;
    }
	
	public boolean search(HashMap<Integer, Set<Integer>> adjList, int cur, int[] status){
		if(status[cur] == 2) return true;
		if(status[cur] == 1) return false;
		status[cur] = 1;
		if(adjList.containsKey(cur)){
			for(int neighbor: adjList.get(cur)){
				if(!search(adjList, neighbor,status)) return false;
			}
		}
		status[cur] = 2;
		return true;
	}
}
