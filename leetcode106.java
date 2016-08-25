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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         int length=inorder.length;
	        if(length==0)
	        	return null;
	        
	        if(length==1){
	        	TreeNode root=new TreeNode(inorder[0]);
	        	root.left=null;
	        	root.right=null;
	        	return root;
	        }
	        
	        TreeNode root=buildBinaryTree(inorder,0,length-1,postorder,0,length-1);
	        return root;
    }
    
    public TreeNode buildBinaryTree(int[] inorder,int startOfIn,int endOfIn,int[] postorder,int startOfPost,int endOfPost){
		if(startOfIn==endOfIn){
			TreeNode root=new TreeNode(inorder[startOfIn]);
			root.left=null;
			root.right=null;
			return root;
		}
		
		int i=startOfIn;
		while(i<=endOfIn){
			if(inorder[i]==postorder[endOfPost])
				break;
			i++;
		}
		
		TreeNode root=new TreeNode(postorder[endOfPost]);
		if(i-1>=startOfIn){
			root.left=buildBinaryTree(inorder,startOfIn,i-1,postorder,startOfPost,startOfPost+i-startOfIn-1);
		}
		else
			root.left=null;
		
		if(i<endOfIn){
			root.right=buildBinaryTree(inorder,i+1,endOfIn,postorder,startOfPost+i-startOfIn,endOfPost-1);
		}
		else 
			root.right=null;
		
		return root;
	}
}
