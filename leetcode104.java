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
    public int maxDepth(TreeNode root) {
         if(root==null)
	        	return 0;
	        int leftLength=maxDepth(root.left);
	        int rightLength=maxDepth(root.right);
	        return 1+(leftLength>rightLength?leftLength:rightLength);
    }
}
