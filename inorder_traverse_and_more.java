package leetcode3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorder_traverse_and_more {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		while(current != null || !stack.isEmpty()){
			while(current != null){
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			res.add(current.val);
			current = current.right;
		}
		return res;
	}
}
