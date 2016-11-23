package leetcode3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class merge_k_lists {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; } }
	
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				if(o1 == null) return 1;
				if(o2 == null) return -1;
				return o1.val - o2.val;
			}
        });
        for(int i = 0; i < lists.length; i ++){
        	if(lists[i] != null)
        		queue.offer(lists[i]);
        }
        while(!queue.isEmpty()){
        	ListNode node = queue.poll();
        	current.next = node;
        	current = current.next;
        	if(node.next != null)
        		queue.offer(node.next);
        }
        return fakeHead.next;
    }
}
