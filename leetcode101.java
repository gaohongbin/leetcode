/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
	        if(root==null)
	        	return true;
	        root.left=invertTree(root.left);
	        return isSameTree(root.left, root.right);
	        
	    }
	
	
	public TreeNode invertTree(TreeNode root){
		if(root==null)
		  	  return root;
		    invertTree(root.left);
		    invertTree(root.right);
		    TreeNode temp=null;
		    temp=root.left;
		    root.left=root.right;
		    root.right=temp;
		    return root;
	}
	
	 public boolean isSameTree(TreeNode p, TreeNode q) {
         if(p==null && q==null)
	        	return true;
	        if(p!=null && q==null)
	        	return false;
	        if(p==null && q!=null)
	        	return false;
	        
	        if(p.val!=q.val)
	        	return false;
	        boolean left=isSameTree(p.left, q.left);
	        boolean right=isSameTree(p.right, q.right);
	        
	        if(left && right)
	        	return true;
	        return false;
    }
	
}
