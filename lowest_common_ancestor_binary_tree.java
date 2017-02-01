package leetcode3;

public class lowest_common_ancestor_binary_tree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.equals(p) || root.equals(q)) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return left != null? left : right;
        //else if(left != null && right == null) return left;
        //else return right;
    }
	
	//input: might be nulls
	//if p and q are both bigger than root, the LCA is in the right subtree
	//if p and q are both smaller than root, the LCA is in the left subtree
	//else root the LCA
	public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == null || q == null) return null;
		return helper(root, p, q);
	}
	
	public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
		if(root.val < p.val && root.val < q.val) return helper(root.right, p, q);
		else if(root.val > p.val && root.val > q.val) return helper(root.left, p, q);
		else return root;
	}
}
