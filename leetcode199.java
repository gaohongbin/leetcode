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
  public static List<Integer> rightSideView(TreeNode root) {
	List<Integer> list = new ArrayList<Integer>();
		if(root==null)
			return list;
		
		List<TreeNode> vector = new ArrayList<TreeNode>();
		TreeNode p=root;
		int tempNode = 0; //用来保存没一层最右边的节点的值。
		int number=0; //用来计数上一层多少个非空节点。
		int temp=1;  //通过number计算下一层多少节点。包括null。
		int i=0;
		vector.add(root); //辅助数组中加入root
		while(p!=null || i<vector.size()){
			p=vector.get(i);
			if(temp>=0){
				if(p!=null){
					vector.add(p.left);
					vector.add(p.right);
					tempNode=p.val;
					number++;
				}
				temp--;
				if(temp==0 && number!=0){ //某一层遍历完了
					list.add(tempNode);
					temp=number*2;
					number=0;
				}
			}
			i++;
		}
		return list;
	}
}

