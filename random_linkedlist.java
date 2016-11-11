package leetcode3;

import java.util.HashMap;
import java.util.Random;

public class random_linkedlist {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }}
	
	HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
	int length = 0;

	public random_linkedlist(ListNode head) {
		int count = 0;
		ListNode current = head;
		while (current != null) {
			map.put(count, current);
			count++;
			current = current.next;
		}
		length = count + 1;
	}

	/** Returns a random node's value. */
	public int getRandom() {
		Random rand = new Random();
		int n = rand.nextInt(length - 1);
		return map.get(n).val;
	}
}
