package leetcode3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Nested_List_Two {
	public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() < 1) return 0;
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        for(NestedInteger n : nestedList) queue.offer(n);
        Queue<Integer> sumQ = new LinkedList<Integer>();
        while(!queue.isEmpty()){
        		int size = queue.size();
        		int levelSum = 0;
			for (int i = 0; i < size; i++) {
				NestedInteger cur = queue.poll();
				if (cur.isInteger()) {
					levelSum += cur.getInteger();
				} else {
					for (NestedInteger e : cur.getList()) queue.offer(e);
				}
			}
			sumQ.add(levelSum);
		}
        int total = 0;
        while(!sumQ.isEmpty()){
        		int size = sumQ.size();
        		total += sumQ.poll() * size;
        }
        return total;
    }
}
