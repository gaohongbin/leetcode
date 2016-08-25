/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

   private static Stack<TreeNode> stack = new Stack<TreeNode>(); //用来保存
	 public BSTIterator(TreeNode root) {
		 int height = heightOfTree(root);  //得到二叉树的高度
		 
		 TreeNode p=root;
		 while(p!=null){
			 stack.add(p);
			 p=p.left;
		 }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	    	if(stack.empty())
	    		return false;
	    	return true;
	        
	    }

	    /** @return the next smallest number */
	    public int next() {
	    	TreeNode q=stack.pop();
	    	int result =q.val;
	    	q=q.right;
	    	while(q!=null){
	    		stack.push(q);
	    		q=q.left;
	    	}
	    	return result;
	    }
	    
	    /**
	     * 得到二叉树的高度
	     * @param root
	     * @return
	     */
	    public int heightOfTree(TreeNode root){
	    	int height=0;
	    	if(root==null)
	    		return height;
	    	
	    	int left = heightOfTree(root.left);
	    	int right = heightOfTree(root.right);
	    	
	    	return left>right?left+1:right+1;
	    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
