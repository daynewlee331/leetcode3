package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class print_tree_path {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }}
	
	/*
	public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        List<String> res = new ArrayList<String>();
        if(root == null) return res;
        binaryTreePathFinder(root, arr, res);
        return res;
    }
    
    public void binaryTreePathFinder(TreeNode root, ArrayList<Integer> arr, List<String> res){
        if(root == null) return;
        arr.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < arr.size(); i ++){
                sb.append(arr.get(i));
                sb.append("->");
            }
            sb.setLength(sb.length() - 2);
            res.add(sb.toString());
            arr.remove(arr.size() - 1);
            return;
        }
        binaryTreePathFinder(root.left, arr, res);
        binaryTreePathFinder(root.right, arr, res);
        arr.remove(arr.size() - 1);
    }*/
	
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
