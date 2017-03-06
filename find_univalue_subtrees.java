package leetcode3;

public class find_univalue_subtrees {
	public int countUnivalSubtrees(TreeNode root) {
		int[]count = new int[1];
		count[0] = 0;
		search(root, count);
		return count[0];
    }
	
	public boolean search(TreeNode root, int[] count){
		if(root == null) return true;
		boolean left = search(root.left, count);
		boolean right = search(root.right, count);
		if(left && right){
			if(root.left != null && root.val != root.left.val) return false;
			if(root.right != null && root.val != root.right.val) return false;
			count[0] ++;
			return true;
		}
		return false;
	}
}
