package leetcode3;

import java.util.Random;

import leetcode3.random_linkedlist.ListNode;

//蓄水池算法
public class random_linkedlist_2 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }}
	
	Random rand = null;
    ListNode head = null;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public random_linkedlist_2(ListNode head) {
        this.rand = new Random();
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode current = this.head;
        ListNode res = current;
        for(int i = 1; current != null; i ++){
            if(this.rand.nextInt(i) == 0){
                res = current;
            }
            current = current.next;
        }
        return res.val;
    }
}
