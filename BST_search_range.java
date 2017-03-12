package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class BST_search_range {
	public static void main(String[] args){
		TreeNode root = new TreeNode(21);
		root.left = new TreeNode(13); root.right = new TreeNode(32);
		root.left.left = new TreeNode(9); root.left.right = new TreeNode(17);
		root.right.left = new TreeNode(27); root.right.right = new TreeNode(41);
		root.left.left.left = new TreeNode(6); root.left.left.right = new TreeNode(10);
		root.left.right.left = new TreeNode(15);
		root.right.left.left = new TreeNode(23); root.right.left.right = new TreeNode(30);
		root.right.right.right = new TreeNode(42);
		
		BST_search_range sol = new BST_search_range();
		List<Integer> list = new ArrayList<Integer>();
		sol.search(root, 27, 40, list);
		for(int e: list) System.out.print(e + " ");
		System.out.println();
	}
	
	public void search(TreeNode root, int low, int high, List<Integer> list){
		if(root == null) return;
		if(root.val < low) search(root.right, low, high, list);
		else if(root.val > high) search(root.left, low, high, list);
		else{
			list.add(root.val);
			search(root.right, low, high, list);
			search(root.left, low, high, list);
		}
	}
}
