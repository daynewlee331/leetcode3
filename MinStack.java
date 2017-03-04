package leetcode3;

public class MinStack {
	class Node{
		int val;
		int min;
		Node next;
		public Node(int x){
			this.val = x;
		}
	}
	
	Node top = null;
	/** initialize your data structure here. */
    public MinStack() {
        this.top = null;
    }
    
    public void push(int x) {
        if(top == null){
        	top = new Node(x);
        	top.min = x;
        }else{
        	Node tmp = new Node(x);
        	tmp.min = Math.min(x, top.min);
        	tmp.next = top;
        	top = tmp; //top now pointing to the new node (new top)
        }
    }
    
    public void pop() {
        top = top.next;
        return;
    }
    
    public int top() {
        return top == null? 0 : top.val;
    }
    
    public int getMin() {
        return top == null? 0 : top.min;
    }
}
