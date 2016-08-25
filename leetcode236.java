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
          if(root==null || p==null || q==null)
	        	return null;
	        
	        List<TreeNode> pathp = new ArrayList<TreeNode>();
	        List<TreeNode> pathq = new ArrayList<TreeNode>();
	        
	        pathp.add(root);
	        pathq.add(root);
	        
	        getPath(root,p,pathp);
	        getPath(root,q,pathq);
	        
	        int i=0;
	        TreeNode dec=null;
	        for(i=0;i<pathp.size() && i<pathq.size();i++){
	        	if(pathp.get(i)==pathq.get(i))
	        		dec=pathp.get(i);
	        	else 
	        		break;
	        }
	        
	        return dec;
    }
    
    public boolean getPath(TreeNode root,TreeNode p,List<TreeNode> path){
		if(root == p)
			return true;
		
		if(root.left!=null){
			path.add(root.left);
			if(getPath(root.left,p,path))
				return true;
			path.remove(path.size()-1);
		}
		
		if(root.right!=null){
			path.add(root.right);
			if(getPath(root.right,p,path))
				return true;
			path.remove(path.size()-1);
		}
		
		return false; //如果搜到尾，root==null则返回false
	}
}
