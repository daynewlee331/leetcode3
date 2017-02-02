package leetcode3;

import java.util.LinkedList;
import java.util.Queue;

public class Symmetric_Tree {
	
	//compare left == right?
	//then left.left == right.right?
	//then left.right == right.left?
	public boolean isSymmetricRec(TreeNode root) {
        if(root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }
	
	public boolean isSymmetricHelper(TreeNode left, TreeNode right){
		if(left == null || right == null) return left == right;
		if(left.val != right.val) return false;
		else return isSymmetricHelper(left.left, right.right) 
				&& isSymmetricHelper(left.right, right.left);
	}
	
	public boolean isSymmetricIte(TreeNode root){
		if(root == null) return true;
		if(root.left == null && root.right == null) return true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root.left);
		queue.offer(root.right);
		while(!queue.isEmpty()){
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			if(left == null && right == null) continue;
			if(left != null && right == null) return false;
			if(right != null && left == null) return false;
			if(left.val != right.val) return false;
			queue.offer(left.left);
			queue.offer(right.right);
			queue.offer(left.right);
			queue.offer(right.left);
		}
		return true;
	}
}
