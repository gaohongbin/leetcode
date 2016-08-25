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
    public int minDepth(TreeNode root) {
        if(root==null)
			return 0;
		if(root.left==null && root.right!=null)
		return 1+minDepth(root.right);
		if(root.right==null && root.left!=null)
		return 1+minDepth(root.left);
		if(root.left==null && root.right==null)
		return 1;
		
		int left=minDepth(root.left);
		int right=minDepth(root.right);
		
		return 1+(left<right?left:right);
    }
}
