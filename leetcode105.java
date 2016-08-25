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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       int lengthOfPre=preorder.length;
	        int lengthOfIn=inorder.length;
	        
	        if(lengthOfPre==0){
	        	return null;
	        }
	        
	        
	        if(lengthOfPre==1){
	        	TreeNode root=new TreeNode(preorder[0]);
	        	root.left=root.right=null;
	        	return root;
	        }
	        
	        
	        TreeNode root=buildBinaryTree(preorder,0,lengthOfPre-1,inorder,0,lengthOfIn-1);
	        return root;
    }
    
    public  TreeNode buildBinaryTree(int[] preorder,int startOfPre,int endOfPre,int[] inorder,int startOfIn,int endOfIn){
		 
		 if(startOfPre==endOfPre){
			 TreeNode root=new TreeNode(preorder[startOfPre]);
			 //root.val=preorder[startOfPre];
			 root.left=null;
			 root.right=null;
			 return root;
		 }
		 
		 int i=0;
		 for(i=startOfIn;i<=endOfIn;i++){
			 if(inorder[i]==preorder[startOfPre]){
				 break;
			 }
		 }
		 
		 TreeNode root=new TreeNode(preorder[startOfPre]);
		 if(i-1>=startOfIn){
			 root.left=buildBinaryTree(preorder,startOfPre+1,startOfPre+i-startOfIn,inorder,startOfIn,i-1);
			 //buildBinaryTree(preorder,startOfPre+1,startOfPre+i-startOfIn-1,inorder,startOfIn,i-1);
		 }
		 else
			 root.left=null;
		 if(i!=endOfIn){
			 root.right=buildBinaryTree(preorder,startOfPre+i-startOfIn+1,endOfPre,inorder,i+1,endOfIn);
			 //buildBinaryTree(preorder,startOfPre+i-startOfIn,endOfPre,inorder,i+1,endOfIn);
		 }
		 else 
			 root.right=null;
		 return root;
	 }
}
