package leetcode3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BT_vertical_order_traverse {
	class TreeNodeInfo{
		int col = 0;
		TreeNode node = null;
		TreeNodeInfo(int col, TreeNode node){
			this.col = col;
			this.node = node;
		}
	}
	
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int min = 0;
		int max = 0;
		if(root == null) return res;
		Queue<TreeNodeInfo> q = new LinkedList<TreeNodeInfo>();
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		q.add(new TreeNodeInfo(0, root));
		while(!q.isEmpty()){
			TreeNodeInfo cur = q.poll();
			if(map.containsKey(cur.col)){
				map.get(cur.col).add(cur.node.val);
			}else{
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(cur.node.val);
				map.put(cur.col, tmp);
			}
			min = Math.min(min, cur.col - 1); //update min if necessary
			if(cur.node.left != null)
				q.add(new TreeNodeInfo(cur.col - 1, cur.node.left));
			max = Math.max(max, cur.col + 1);  //update max if necessary
			if(cur.node.right != null)
				q.add(new TreeNodeInfo(cur.col + 1, cur.node.right));
		}
		for(int j = min; j <= max; j ++){
			if(map.containsKey(j)){
				res.add(map.get(j));
			}
		}
		return res;
    }
}
