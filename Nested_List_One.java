package leetcode3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Nested_List_One {
	public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) return 0;
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        for(NestedInteger n: nestedList) queue.add(n);
        int level = 1, total = 0;
        while(!queue.isEmpty()){
        	int size = queue.size();
        	for(int i = 0; i < size; i ++){
        		NestedInteger cur = queue.poll();
        		if(cur.isInteger()){
        			total += level * cur.getInteger();
        		}else {
        			for(NestedInteger e: cur.getList()) queue.offer(e);
        		}
        	}
        	level ++;
        }
        return total;
    }
}	
