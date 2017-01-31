package leetcode3;

public class convert_sorted_list_to_BST {
	
	//leetcode 109
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return toBST(head, null);
    }

	public TreeNode toBST(ListNode begin, ListNode end){
		if (begin == end) return null;
		ListNode slow = begin;
		ListNode fast = begin;
		while (fast != end && fast.next != end) {
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode node = new TreeNode(slow.val);
		node.left = toBST(begin, slow);
		node.right = toBST(slow.next, end);
		return node;
	}
}
