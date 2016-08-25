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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       List<List<Integer>> list1 = new ArrayList<List<Integer>>();
		    
	        if(root==null)  //传进来的树为空
	        	return list1;
	        
	        //先把树转成队列
	        LinkedList<TreeNode> que =new LinkedList<TreeNode>();
	        TreeNode treeNode ;
	        List<Integer> elementOfList = new ArrayList<Integer>();
	        que.addLast(root);
	        que.addLast(null);
	        while(que.size()!=0){
	        	treeNode = que.poll();
	        	if(treeNode!=null){ //在队列里用null来分开每一层
	        		elementOfList.add(treeNode.val);
	        		if(treeNode.left!=null)
	        		   que.add(treeNode.left);
	        		if(treeNode.right!=null)
	        			que.add(treeNode.right);
	        	}
	        	else{
	        		que.add(null);
	        		if(elementOfList.size()==0)
	        			break;
	        		list1.add(0,elementOfList);
	        		elementOfList = new ArrayList<Integer>();
	        	}
	        }
	        return list1;
    }
}
