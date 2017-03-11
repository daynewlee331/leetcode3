package leetcode3;

import java.util.LinkedList;
import java.util.Queue;

public class Course_Schdeule_One_BFS {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses < 0 || prerequisites == null) return false;
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] inDegree = new int[numCourses];
        for(int[] sub: prerequisites){ inDegree[sub[0]] ++;}
        int count = 0;
        for(int i = 0; i < inDegree.length; i ++){
        	if(inDegree[i] == 0) { queue.add(i); count ++; }
        }
        while(!queue.isEmpty()){
        	int cur = queue.poll();
        	for(int[] pre: prerequisites){
        		if(pre[1] == cur){
        			inDegree[pre[0]] --;
        			if(inDegree[pre[0]] == 0){
        				count ++;
        				queue.offer(pre[0]);
        			}
        		}
        	}
        }
        return count == numCourses;
    }
}
