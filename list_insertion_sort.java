package leetcode3;

public class list_insertion_sort {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }}
	
	public static void main(String[] args){
		list_insertion_sort l = new list_insertion_sort();
		ListNode head = new ListNode(4);
		head.next = new ListNode(3);
		head.next.next = new ListNode(2); 
		head.next.next.next = new ListNode(1); 
		l.insertionSortList(head);
	}
	
	//note: use dummy head
	public ListNode insertionSortList(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return head;
		ListNode current = head;
		ListNode next = null;
		
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		
		while(current != null){
			next = current.next;
			
			while(pre.next != null && pre.next.val < current.val){
				pre = pre.next;
			}
			//insert
			current.next = pre.next;
			pre.next = current;
			pre = fakeHead;
			current = next;
		}
		return fakeHead.next;
	}
}
