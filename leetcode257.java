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
    public static int height(TreeNode root){  //计算树的高度
		if(root==null)
			return 0;
		int left=height(root.left);
		int right=height(root.right);
		return 1+((left>right)?left:right); 
	}
	 public static List<String> binaryTreePaths(TreeNode root) {
		 List<String> list =new ArrayList<String>();
		 int height=height(root);
		 if(height==0)
			 return list;
		 
		 Set<TreeNode> set = new HashSet<TreeNode>();//保存访问过的节点
		 
		 TreeNode[] arrayTreeNode =new TreeNode[height]; //用数组来存放树的节点
		 int lenTreeNode =0; //用来保存数组的长度
		 
		 
//		 StringBuffer str=new StringBuffer(); //用StringBuffer来运算，最后转为String。 
//		 str.append(pHead.val);
//		 arrayTreeNode[0]=root;
//		 while(pHead.left!=null || pHead.right!=null){ //将最左边的分支放在数组里
//			 str.append("->");
//			 if(pHead.left!=null){
//				 str.append(pHead.left.val);
//				 arrayTreeNode[lenTreeNode++]=pHead.left;
//				 pHead=pHead.left;
//			 }
//			 else{
//				 str.append(pHead.right.val);
//				 arrayTreeNode[lenTreeNode++]=pHead.right;
//				 pHead=pHead.right;
//			 }
//		 }
//		 list.add(str.toString());
//		 
//		 lenTreeNode--;
		 TreeNode pHead=root;
		 StringBuffer str=new StringBuffer(); //用StringBuffer来运算，最后转为String。
		 
		 arrayTreeNode[lenTreeNode++]=root;
		 int i=0;
		 while(lenTreeNode>0){
			 if(arrayTreeNode[lenTreeNode-1].left==null && arrayTreeNode[lenTreeNode-1].right==null){ //当遇到叶子节点
				 str=new StringBuffer(); //如果每搜过，就重新生成一个StringBuffer
				 while(i<lenTreeNode){
					 str.append(arrayTreeNode[i].val);
					 if(i!=lenTreeNode-1)
						 str.append("->");
					 if(i==lenTreeNode-1)
						 list.add(str.toString());
					 i++;
				 }
				 i=0;
				 lenTreeNode--;
			 }
			 else if(arrayTreeNode[lenTreeNode-1].left==null || arrayTreeNode[lenTreeNode-1].right==null){ //遇到只有一个子树的节点
				 if(set.contains(arrayTreeNode[lenTreeNode-1]))
				   lenTreeNode--;
				 else{
					 if(arrayTreeNode[lenTreeNode-1].left!=null){
					   set.add(arrayTreeNode[lenTreeNode-1]);
					   arrayTreeNode[lenTreeNode]=arrayTreeNode[lenTreeNode-1].left;
					 }
					 if(arrayTreeNode[lenTreeNode-1].right!=null){
						 set.add(arrayTreeNode[lenTreeNode-1]);
						 arrayTreeNode[lenTreeNode]=arrayTreeNode[lenTreeNode-1].right;
					 }
					 lenTreeNode++;
				 }
			 }
			 else {  //既有左子树又有右子树
				 if(set.contains(arrayTreeNode[lenTreeNode-1])){
					 arrayTreeNode[lenTreeNode-1].left=null;
					 arrayTreeNode[lenTreeNode]=arrayTreeNode[lenTreeNode-1].right;
				 }
				 else{
					 arrayTreeNode[lenTreeNode]=arrayTreeNode[lenTreeNode-1].left;
					 set.add(arrayTreeNode[lenTreeNode-1]);
				 }
				 lenTreeNode++;
			 }
		 }
		 return list;
	    }
}
