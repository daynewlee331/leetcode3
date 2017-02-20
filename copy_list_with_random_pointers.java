package leetcode3;

import java.util.HashMap;

public class copy_list_with_random_pointers {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) return null;
		RandomListNode cur = head;
		while(cur != null){
			RandomListNode tmp = cur.next;
			RandomListNode copy = new RandomListNode(cur.label);
			cur.next = copy;
			copy.next = tmp;
			cur = tmp;
		}
		
		cur = head;
		while(cur != null){
			RandomListNode copy = cur.next;
			if(cur.random != null) copy.random = cur.random.next;
			else copy.random = null;
			cur = cur.next.next;
		}
		
		RandomListNode res = head.next;
		cur = head;
		RandomListNode copy = head.next;
		while(cur != null && copy != null){
			cur.next = cur.next.next;
			if(copy.next == null) break;
			copy.next = copy.next.next;
			cur = cur.next;
			copy = copy.next;
		}
		return res;
	}
	
	public RandomListNode copyRandomListIntuitive(RandomListNode head) {
        if(head == null) return null;
        HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        RandomListNode cur = head;
        while(cur != null){
        	map.put(cur.label, new RandomListNode(cur.label));
        	cur = cur.next;
        }
        cur = head;
        while(cur != null){
        	RandomListNode copy = map.get(cur.label);
        	if(cur.next == null) copy.next = null;
        	else copy.next = map.get(cur.next.label);
        	if(cur.random == null) copy.random = null;
        	else copy.random = map.get(cur.random.label);
        	cur = cur.next;
        }
        return map.get(head.label);
    }
}
