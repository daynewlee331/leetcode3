package leetcode3;

public class remove_duplicates_in_sortedlist {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }}
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;
        int count = 0;
        while(next != null){
            if(next.val == current.val){ //if there's duplicate, keep next going and increment count
                next = next.next;
                count ++;
            }else{
                if(count != 0){//if there are duplicates
                    if(prev != null){
                        prev.next = next;
                        current = prev.next;
                    }else{
                        head = next;
                        current = head;
                    }
                    count = 0;//reset count
                    if(current == null) break;//if current is null, we are done
                    next = current.next;
                }else{//if not keep three pointers going
                    prev = current;
                    current = current.next;
                    next = current.next;
                }
            }
        }
        if(count != 0){
            if(prev == null){
                return null;
            }else{
                prev.next = null;
                count = 0;
            }
        }
        return head;
    }
}
