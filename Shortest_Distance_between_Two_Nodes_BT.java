package leetcode3;


public class Shortest_Distance_between_Two_Nodes_BT {
	public int getDistance(TreeNode root, TreeNode p, TreeNode q){
		if(root == null || p == null || q == null) return 0;
		TreeNode ancestor = lowestCommonAncestor(root, p, q);
		int d1 = nodeDepth(root, ancestor);
		int d2 = nodeDepth(root, p);
		int d3 = nodeDepth(root, q);
		return d3 - d1 + d2 - d1;
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        else if(left != null) return left;
        else if(right != null) return right;
        else return null;
    }
	
	public int nodeDepth(TreeNode root, TreeNode p){
		if(root == null) return -1;
		if(root == p) return 0;
		int left = nodeDepth(root.left, p);
		int right = nodeDepth(root.right, p);
		if(left == -1 && right != -1) return right + 1;
		else if(right == -1 && left != -1) return left + 1;
		else return -1;
	}
}
