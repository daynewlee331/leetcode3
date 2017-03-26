package leetcode3;

public class Odd_Even_LinkedList {
	public static void main(String[] args){
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		Odd_Even_LinkedList sol = new Odd_Even_LinkedList();
		sol.oddEvenList(head);
	}
	
	public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode p1 = head, p2 = head.next;
        ListNode cur1 = p1, cur2 = p2;
        while((cur1 != null && cur1.next != null) 
        		|| (cur2 != null && cur2.next != null)){
        		if(cur1 != null && cur1.next != null){
        			ListNode tmp = cur1.next.next;
        			cur1.next = tmp;
        			cur1 = tmp;
        		}
        		if(cur2 != null && cur2.next != null){
        			ListNode tmp = cur2.next.next;
        			cur2.next = tmp;
        			cur2 = tmp;
        		}
        }
        cur1 = p1;
        while(cur1.next != null) {
        		cur1 = cur1.next;
        }
        cur1.next = p2;
        return p1;
    }
}
