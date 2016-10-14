/**
 * 题目：计算所有左子树的值的和。
 * 思路：用两个列表，一个列表表示上一层，一个列表表示下一层。针对每一层找出左子叶子。计算之和。
 * @author ghb
 *
 */

public class Leetcode404 {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(3);
		TreeNode p3 = new TreeNode(4);
		TreeNode p4 = new TreeNode(5);
		
		root.left = p1;
		root.right = p2;
		p1.left = p3;
		p1.right = p4;
		p3.left = p3.right = null;
		p4.left = p4.right = null;
		p2.left = p2.right = null;
		
		int result = sumOfLeftLeaves(root);
		System.out.println(result);
	}
	
	public static int sumOfLeftLeaves(TreeNode root) {
		if(root == null)
			return 0;
		List<TreeNode> upperLayer = new ArrayList<TreeNode>();
		List<TreeNode> downLayer = new ArrayList<TreeNode>();
		upperLayer.add(root);
		
		int i=0;
		int result =0;
		while(upperLayer.size()>0){
			i=0;
			while(i<upperLayer.size()){
				TreeNode node = upperLayer.get(i);
				if(node != null && node.left != null && node.left.left == null && node.left.right == null)
					result += node.left.val;
				if(node != null){
					downLayer.add(node.left);
					downLayer.add(node.right);
				}
				i++;
			}
			upperLayer.clear();
			for(int j=0;j<downLayer.size();j++)
				upperLayer.add(downLayer.get(j));
			downLayer.clear();
	}
	return result;
	}
}

