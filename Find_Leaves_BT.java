package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class Find_Leaves_BT {
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = null;
		while(root != null){
			cur = new ArrayList<Integer>();
			if(isLeave(root, cur)) root = null;
			if(!cur.isEmpty()) res.add(cur);
		}
		return res;
    }
	
	public boolean isLeave(TreeNode root, List<Integer> cur){
		if(root.left == null && root.right == null){
			cur.add(root.val);
			return true;
		}
		if(root.left != null){
			if(isLeave(root.left, cur)) root.left = null;
		}
		if(root.right != null){
			if(isLeave(root.right, cur)) root.right = null;
		}
		return false;
	}
}


