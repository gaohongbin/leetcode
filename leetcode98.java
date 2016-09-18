/**
 * 题目:判断一个二叉树是否为二叉搜索树，思路很简单，就是用一个min和一个max来限制二叉树中节点的值。
 * 但是Integer.MIN_VALUE和Integer.MAX_VALUE是要特殊考虑的边界。其他没什么。
 * @author ghb
 *
 */
public class Leetcode98 {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		
		root.left = left;
		left.left = left.right = null;
		
		root.right = right;
		right.left = right.right = null;
		
		System.out.println(isValidBST(root));
	}
	 public static boolean isValidBST(TreeNode root) {
		 if(root == null || (root.left == null && root.right == null))
			 return true;
		 
		 if(root.val == Integer.MIN_VALUE && root.left != null)
			 return false;
		 if(root.val == Integer.MAX_VALUE && root.right != null)
			 return false;
			 
		 boolean left = helper(root.left,Integer.MIN_VALUE,root.val-1);
		 boolean right = helper(root.right,root.val+1,Integer.MAX_VALUE);
		 
		 return (left && right);
	 }
	 
	 /**
	  * 
	  * 
	  * @param root
	  * @param min
	  * @param max
	  * @return
	  */
	 public static boolean helper(TreeNode root, int min, int max){
		 if(root == null)
			 return true;
		 
		 boolean left = false;
		 boolean right = false;
		 if(root.val>=min && root.val<=max){
			if(root.val ==Integer.MIN_VALUE && root.left != null)
				return false;
			if(root.val == Integer.MAX_VALUE && root.right != null)
				return false;
			left = helper(root.left,min,root.val-1);   //如果是往左边走，则用root.val替换max，max变小了。 
			right = helper(root.right,root.val+1,max);  //如果往右边走，用root.val替换min，min变大了。
			
			return (left && right);
		 }
		 
		 return false;
	 }

}

