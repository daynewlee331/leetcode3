package leetcode3;

import java.util.ArrayList;
import java.util.Stack;

public class BSTIterator {
	public static void main(String[] args){
		TreeNode r = new TreeNode(2);
		r.left = new TreeNode(1);
		r.right = new TreeNode(3);
		BSTIterator ite = new BSTIterator(r);
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
	}
	
	Stack<TreeNode> stack = null;
	
	public BSTIterator(TreeNode root) {
		TreeNode cur = root;
		stack = new Stack<TreeNode>();
		while(cur != null){
			stack.push(cur);
			cur = cur.left;
		}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode node = this.stack.pop();
    	TreeNode cur = node;
    	cur = cur.right;
    	while(cur != null){
    		stack.push(cur);
    		cur = cur.left;
    	}
    	return node.val;
    }
}
