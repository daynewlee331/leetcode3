package leetcode3;

public class recover_BST {
	//LC 99
	//e.g: 1, 2, 3, 6, 5, 7, 4, 8
	//1.use inorder traverse to find two mistakenly-placed elements
    //2.Both of them must be equal to or smaller than the previous one 
    //3.After finding both of them, we then swap
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
    	traverse(root);
    	if(firstElement != null && secondElement != null){
    		int tmp = firstElement.val;
        	firstElement.val = secondElement.val;
        	secondElement.val = tmp;
    	}
    }
    
    public void traverse(TreeNode root){
    	if(root == null) return;
    	traverse(root.left);
    	if(firstElement == null && prev.val >= root.val){
    		firstElement = prev;
    	}
    	
    	if(firstElement != null && prev.val >= root.val){
    		secondElement = root;
    	}
    	prev = root;
    	traverse(root.right);
    }
}
