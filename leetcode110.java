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
    public boolean isBalanced(TreeNode root) {
         if(root==null)
	        	return true;
	        boolean balanceOfLeft=isBalanced(root.left);
	        if(balanceOfLeft==false)
	        	return false;
	        
	        boolean balanceOfRight=isBalanced(root.right);
	        if(balanceOfRight==false)
	        	return false;
	        
	        int depthOfLeft=depthOfTree(root.left);
	        int depthOfRight=depthOfTree(root.right);
	        
	        if(Math.abs(depthOfLeft-depthOfRight)>1)
	        	return false;
	        return true;
	        
    }
    
    public int depthOfTree(TreeNode root){
		 if(root==null)
			 return 0;
		 int left=depthOfTree(root.left);
		 int right=depthOfTree(root.right);
		 
		 return 1+(left>right?left:right);
	 }
}
