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
		if(head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;
        while(even != null && even.next != null){
        		odd.next = even.next;
        		even.next = even.next.next;
        		odd = odd.next;
        		even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
