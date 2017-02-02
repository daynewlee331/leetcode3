package leetcode3;

public class merge_two_sorted_lists {

	// if l1 or l2 is null, return the other one
	// assume there's no duplicates
	// p1 pointing to the smaller head, p2 pointing to the other node
	// p1 -> 1 -> 2 -> 4 -> 8
	// p2 -> 1 -> 6 -> 7 -> 9

	public static void main(String[] args) {
		merge_two_sorted_lists sol = new merge_two_sorted_lists();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(8);
		l1.next.next.next = new ListNode(8);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(7);
		l2.next.next = new ListNode(7);
		l2.next.next.next = new ListNode(9);

		ListNode test = sol.mergeTwoLists(l1, l2);
		while (test != null) {
			System.out.print(test.val + " ");
			test = test.next;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) return null;
		else if (l1 == null) return l2;
		else if (l2 == null) return l1;

		ListNode p1 = l1;
		ListNode p2 = l2;
		if (l2.val < l1.val) {
			p1 = l2;
			p2 = l1;
		}
		ListNode head = p1;
		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val && p1.next != null && p1.next.val > p2.val) {
				ListNode p1After = p1.next;
				ListNode p2Next = p2.next;
				p1.next = p2;
				p2.next = p1After;
				p2 = p2Next;
			} else if (p1.val <= p2.val && p1.next == null) {
				p1.next = p2;
				break;
			}
			p1 = p1.next;
		}

		return head;
	}
}
