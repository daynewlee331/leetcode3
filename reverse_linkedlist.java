package leetcode3;

public class reverse_linkedlist {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }}
	
	public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode p2 = null;
        ListNode p1 = head;
        ListNode p3 = head.next;
        while(p1 != null){
            p1.next = p2;
            p2 = p1;
            p1 = p3;
            if(p3 == null) break;
            p3 = p3.next;
        }
        return p2;
    }
}
