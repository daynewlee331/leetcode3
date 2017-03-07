package leetcode3;

import java.util.LinkedList;
import java.util.Queue;

public class botton_left_tree_value {
	public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int res = root.val;
        while(!queue.isEmpty()){
        		int size = queue.size();
        		Integer tmp = null;
        		for(int i = 0; i < size; i ++){
        			TreeNode node = queue.poll();
        			if(node.left != null){
        				if(tmp == null) {
        				    res = node.left.val;
        				    tmp = res;
        				}
        				queue.offer(node.left);
        			}
        			if(node.right != null) {
        			    if(tmp == null) {
        				    res = node.right.val;
        				    tmp = res;
        				}
        			    queue.offer(node.right);
        			}
        		}
        }
        return res;
    }
}
