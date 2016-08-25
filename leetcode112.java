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
    public boolean hasPathSum(TreeNode root, int sum) {
              if(root==null)
	        	return false;
	        else if(root.left==null && root.right==null && sum-root.val==0)
	        	return true;
	        else{
	        	boolean left=hasPathSum(root.left, sum-root.val);
	        	if(left==true)
	        		return true;
	        	
	        	boolean right=hasPathSum(root.right, sum-root.val);
	        	if(right==true)
	        		return true;
	        	
	        	return false;
	        }
	 }
}
