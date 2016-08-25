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
    public int kthSmallest(TreeNode root, int k) {
        
       Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p=root;
		while(p!=null){
			stack.push(p);
			p=p.left;
		}
		while(p!=null || !stack.empty()){
			p=stack.pop();
			k--;
			if(k==0)
				return p.val;
			
			if(p.right!=null){
				p=p.right;
				while(p!=null){
					stack.push(p);
					p=p.left;
				}
			}
		}
		return 0;
    }
}
