package leetcode3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorder_traverse_and_more {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null || !stack.isEmpty()){
			while(root != null){
				stack.push(root);
				if(root.left != null) root = root.left;
				else break;
			}
			TreeNode node = stack.pop();
			res.add(node.val);
			root = node.right;
		}
		return res;
	}
	
	public boolean isValidBST(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (list.size() != 0 && list.get(list.size() - 1) >= root.val) {
				return false;
			}
			list.add(root.val);
			root = root.right;
		}
		return true;
    }
	
	public int kthSmallest(TreeNode root, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null || !stack.isEmpty()){
			while(root != null){
				stack.add(root);
				root = root.left;
			}
			root = stack.pop();
			list.add(root.val);
			if(list.size() == k){
				return list.get(list.size() - 1);
			}
			root = root.right;
		}
        return 0;
    }
}
