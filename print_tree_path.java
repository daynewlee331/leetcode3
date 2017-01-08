package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class print_tree_path {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }}
	
	//leetcode 110. Balanced Binary Tree
	public boolean isBalanced(TreeNode root) {
        int height = height(root);
        return height != -1;
    }
	
	public int height(TreeNode root){
		if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(left == -1 || right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
	}
	
	//leetcode: 104. Maximum Depth of Binary Tree
	public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
	
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root != null) binaryTreePathFinder(root, "", res);
        return res;
    }
    
    public void binaryTreePathFinder(TreeNode root, String path, List<String> res){
        if(root.left == null && root.right == null) res.add(path + root.val);
        if(root.left != null) binaryTreePathFinder(root.left, path + root.val + "->", res);
        if(root.right != null) binaryTreePathFinder(root.right, path + root.val + "->", res);
       
    }
}
