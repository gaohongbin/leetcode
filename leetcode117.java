/**
 *  题目：       1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7 
 *     
 *     变为：     1 -> NULL
 *          /  \
 *         2 -> 3 -> NULL
 *        / \    \
 *       4-> 5 -> 7 -> NULL
 * 其中二叉树可以为任意二叉树。
 * @author: hongbin.gao
 * 
 * 思路：和leetcode116类似，只是在que中插入null的判断条件稍微变化，以前是完全二叉树，现在是任意二叉树，只有当temp1为null时，才插入在que中插入null，
 * 所以当插入temp1的左右子节点时，要进行判断，只有当不为null时，才进行插入。
 * 
 *
 */
public class Leetcode117 {
	public static void main(String[] args){
		
	}
	
	public void connect(TreeLinkNode root) {
		if(root == null)
			return ;
		
		LinkedList<TreeLinkNode> que = new LinkedList<TreeLinkNode>();
		que.add(null);
		TreeLinkNode temp1 = root;
		TreeLinkNode temp2 = null;
		
		while(!que.isEmpty()){
			temp2 = que.removeFirst();
			if(temp1 != null){
				if(temp1.left != null)
					que.add(temp1.left);
				if(temp1.right != null)
					que.add(temp1.right);
				temp1.next = temp2;
				temp1 = temp2;
			}
			else if(temp1 == null){
				if(temp2 == null)
					return;
				que.add(null);
				temp1 = temp2;
			}
		}
        return ;
    }
}
