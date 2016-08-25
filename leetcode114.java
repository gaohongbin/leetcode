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
    public void flatten(TreeNode root) {
         if(root==null) //如果树为空
		    	return ;  
		    
	        Stack<TreeNode> stack = new Stack<TreeNode>(); //栈
	        LinkedList<TreeNode> que = new LinkedList<TreeNode>(); //队列
	        
	        TreeNode p = root;
	        while(p!=null || !stack.empty()){
	        	while(p==null && !stack.empty()){
	        		p=stack.pop();
	        		p=p.right;
	        	}
	        	if(p!=null){
		        	stack.push(p);
		        	que.add(p);
		        	p=p.left;
	        	}
	        }
	        
	        TreeNode head=que.removeFirst();
	        head.left=null;
	        p=head;
	        while(que.size()>0){
	        	p.right=que.removeFirst();
	        	p=p.right;
	        	p.left=null;
	        }
	        p.right=null;
    }
}

/**
*  下面是第二种解决方案，这是我在网上看到别人的解决方法，但是这种递归方法我可能自己很难想出来，就先贴出来。 
*
*/
public class Solution {
    public void flatten(TreeNode root) {
        while(root!=null){  
            if(root.left!=null){  
                TreeNode pre = root.left;  
                while(pre.right!=null)  
                    pre = pre.right;  
                pre.right = root.right;  
                root.right = root.left;  
                root.left = null;  
            }  
            root = root.right;  
        }  
    }
}
