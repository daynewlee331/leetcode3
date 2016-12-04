package leetcode3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class tree_level_order_traverse {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		List<Integer> buffer = null;
		while(!queue.isEmpty()){
			int size = queue.size();
			buffer = new ArrayList<Integer>();
			for(int i = 0; i < size; i ++){
				TreeNode tmp = queue.poll();
				buffer.add(tmp.val);
				if(tmp.left != null)
					queue.add(tmp.left);
				if(tmp.right != null)
					queue.add(tmp.right);
			}
			res.add(buffer);
		}
		return res;
    }
}
