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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
           if(root==null || q==null || p==null)
	        	return null;
	        
	        if(Math.min(p.val, q.val)>root.val)
	        	return lowestCommonAncestor(root.right, p, q);
	        else if(Math.max(p.val, q.val)<root.val)
	        	return lowestCommonAncestor(root.left,p,q);
	        else
	        	return root;
    }
}
