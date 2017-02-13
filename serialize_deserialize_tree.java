package leetcode3;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class serialize_deserialize_tree {
	public static void main(String[] args){
		serialize_deserialize_tree st = new serialize_deserialize_tree();
		//TreeNode root = new TreeNode(1);
		//root.left = new TreeNode(2);
		//root.right = new TreeNode(3);
		//root.left.left = new TreeNode(4);
		//root.left.right = new TreeNode(5);
		//String s = st.serialize(root);
		//System.out.println(s);
		TreeNode res = st.deserialize("1,2,3,4,5,null,null,7,null,6,9,10,11,null,null,null,null,15,null,null,null");
		System.out.println(st.serialize(res));
	}
	
	 public String serializePre(TreeNode root) {
	    	StringBuilder builder = new StringBuilder();
	        serializeHelper(root, builder);
	        builder.setLength(builder.length() - 1);
	        return builder.toString();
	    }
	    
	    public void serializeHelper(TreeNode root, StringBuilder builder){
	    	if(root == null) {
	    		builder.append("#,");
	    		return;
	    	}
	    	builder.append(root.val + ",");
	    	serializeHelper(root.left, builder);
	    	serializeHelper(root.right, builder);
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserializePre(String data) {
	    	Deque<String> queue = new LinkedList<String>(Arrays.asList(data.split(",")));
	    	return deserializeHelper(queue);
	    }
	    
	    public TreeNode deserializeHelper(Deque<String> queue){
	    	if(queue.size() == 0) return null;
	    	String node = queue.pop();
	    	if(node.equals("#")) return null;
	    	TreeNode root = new TreeNode(Integer.parseInt(node));
	    	root.left = deserializeHelper(queue);
	    	root.right = deserializeHelper(queue);
	    	return root;
	    }
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root == null) return "";
        return bfs(root);
    }

    public String bfs(TreeNode root){
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	StringBuilder builder = new StringBuilder();
    	
    	while(!queue.isEmpty()){
    		TreeNode node = queue.poll();
    		if(node == null){
    			builder.append("null");
    		}else{
    			builder.append(node.val);
    			queue.offer(node.left);
        		queue.offer(node.right);
    		}
    		builder.append(",");
    	}
    	builder.setLength(builder.length() - 1);
    	return builder.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data == null || data.length() < 1) return null;
    	String[] vals = data.split(",");
    	TreeNode[] nodes = new TreeNode[vals.length]; 
    	int[] nums = new int[vals.length]; // 节点i之前null节点的个数  
    	for (int i = 0; i < vals.length; i++) {  
            if (i > 0) {  
                nums[i] = nums[i - 1];  // get the previous value
            }  
            if (vals[i].equals("null")) {  //create the node array
                nodes[i] = null;  
                nums[i]++;  //if we find one more null, add one
            } else {  
                nodes[i] = new TreeNode(Integer.parseInt(vals[i]));  
            }  
        }  
    	
    	for(int j = 0; j < vals.length; j ++){
    		if(nodes[j] == null) continue; //do nothing
    		nodes[j].left = nodes[2 * (j - nums[j]) + 1];  
            nodes[j].right = nodes[2 * (j - nums[j]) + 2];
    	}
    	
    	return nodes[0];
    }
}
