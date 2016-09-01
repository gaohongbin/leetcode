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
    public int sumNumbers(TreeNode root) {
        int result = helper(root,0);
    	return result;
    }
    
     public int helper(TreeNode root, int num){
    	if(root == null)
    		return num;
    	if(root.left == null && root.right == null)
    		return (num*10+root.val);
    	if(root.left!=null && root.right ==null){
    		return helper(root.left,num*10+root.val);
    	}
    	if(root.right!=null && root.left==null){
    		return helper(root.right,num*10+root.val);
    	}
    	if(root.left!=null && root.right!=null){
	    	int result1 = helper(root.left, num*10+root.val);
	    	int result2 = helper(root.right, num*10+root.val);
	    	return result1+result2;
    	}
    	return 0;
    }
}
