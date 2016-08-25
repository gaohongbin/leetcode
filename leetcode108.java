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
    public TreeNode sortedArrayToBST(int[] nums) {
        int length=nums.length;
	        if(length<1)
	        	return null;
	        
	        return arrayToBST(nums,0,length-1);
    }
    
    public TreeNode arrayToBST(int[] nums,int start,int end){
		if(start>end)
			return null;
		
		if(start==end){
			TreeNode root=new TreeNode(nums[start]);
			root.left=null;
			root.right=null;
			return root;
		}
		
		int mid=(start+end)/2;
		TreeNode root=new TreeNode(nums[mid]);
		root.left=arrayToBST(nums,start,mid-1);
		root.right=arrayToBST(nums,mid+1,end);
		
		return root;
			
	}
}
