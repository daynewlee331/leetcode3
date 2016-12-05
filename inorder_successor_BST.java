package leetcode3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorder_successor_BST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode res = null;
		while(root != null){
			if(p.val < root.val){
				res = root;
				root = root.left;
			}else{
				root = root.right;
			}
		}
		return res;
	}
	
	public TreeNode myInorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        List<TreeNode> list = new ArrayList<TreeNode>();
        Stack<TreeNode> stack  = new Stack<TreeNode>();
        int index = 0;
        boolean found = false;
        while(root != null || !stack.isEmpty()){
        	while(root != null){
        		stack.push(root);
        		root = root.left;
        	}
        	root = stack.pop();
        	list.add(root);
        	if(found){
        		return list.get(index + 1);
        	}
        	if(root.equals(p)){ 
        		index = list.size() - 1;
        		found = true;
        	}
        	root = root.right;
        }
        return null;
    }
}
