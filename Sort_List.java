package leetcode3;

public class Sort_List {
	public static void main(String[] args){
		Sort_List sol = new Sort_List();
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next = new ListNode(2);
		sol.sortList(head);
	}
	
	public ListNode sortList(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode fast = head;
		ListNode slow = head;
		ListNode tmp = slow;
		while(fast != null && fast.next != null){
			tmp = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		tmp.next = null;//cut the linkedlist to two parts
		ListNode node1 = sortList(head);
		ListNode node2 = sortList(slow);
		ListNode res = merge(node1, node2);
		return res;
	}
	
	public ListNode merge(ListNode head1, ListNode head2){
		if(head1 == null) return head2;
		if(head2 == null) return head1;
		ListNode p1 = head1;
		ListNode p2 = head2;
		if(head1.val > head2.val){
			p1 = head2;
			p2 = head1;
		}
		ListNode head = p1;
		while(p1 != null && p1.next != null && p2 != null){
			if(p1.val <= p2.val && p2.val < p1.next.val){
				ListNode next = p1.next; ListNode tmp = p2.next;
				p1.next = p2;
				p2.next = next;
				p2 = tmp;
			}
			p1 = p1.next;
		}
		if(p1.next == null && p2 != null) p1.next = p2;
		return head;
	}
}
