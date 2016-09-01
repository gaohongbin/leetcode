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
    public int rob(TreeNode root) {
         if(root == null)
			 return 0;
		 
		 return helper(root,true);
    }
    
    public int helper(TreeNode root,boolean flag){ //flag为true表示可以取root的值，flag为false表示不能取root的值
		 if(root == null)
			 return 0;
		 
		 if(flag == false){ //不能取root的值
			 int left = helper(root.left,true);
			 int right = helper(root.right,true);
			 
			 return left+right;
		 }
		 else{  //root可以取
			 int hasRoot = root.val + helper(root.left,false)+helper(root.right,false); //取root的值
			 int noRoot = helper(root.left,true)+helper(root.right,true);//不取root的值
			 if(hasRoot>noRoot)
				 return hasRoot;
			 return noRoot;
		 }
	 }
}
