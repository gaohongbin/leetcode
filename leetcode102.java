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
    public List<List<Integer>> levelOrder(TreeNode root) {
                List<List<Integer>> list=new ArrayList<List<Integer>>();
	        
	        if(root==null)
	        	return list;
	        
	        Queue<TreeNode> que=new LinkedList<TreeNode>();
	        que.offer(root);
	        que.offer(null);
	        
	        List<Integer> listOfTreeNode = new ArrayList<Integer>();
	        while(que.size()!=1){
	        	TreeNode p=que.poll();
	        	
	        	if(p==null){
	        		que.offer(null);
	        		list.add(listOfTreeNode);
	        		listOfTreeNode = new ArrayList<Integer>();
	        	}
	        	else{
	        		listOfTreeNode.add(p.val);
	        		if(p.left!=null){
	        			que.offer(p.left);
	        		}
	        		if(p.right!=null){
	        			que.offer(p.right);
	        		}
	        	}
	        }
	        
	        if(listOfTreeNode.size()!=0)
	        	list.add(listOfTreeNode);
	        return list;
    }
}
