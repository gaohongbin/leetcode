
/**
 * 题目：        1
 *       /  \
 *      2    3
 *     / \  / \
 *    4  5  6  7
 *    
 *    变为：
 *        1 -> NULL
 *      /   \
 *     2 ->  3 -> NULL
 *    / \   / \
 *   4->5->6-> 7 -> NULL
 *
 * @author: hongbin.gao
 * 
 * 思路：用一个队列，将二叉树按层次遍历，初始值为null， TreeLinkNode temp1 = root; TreeLinkNode temp2 = null;
 * 如果队列不为空，则从队列里面取出一个节点赋值给temp2，如果temp1不为null，则将temp1的左右子节点放进队列，并且temp1.next = temp2.
 * 如果temp1为null，则在队列里放入一个null。
 * temp1 = temp2.
 */

class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	      }

public class Leetcode116 {
	public static void main(String[] args){
		
	}
	
	public void connect(TreeLinkNode root) {
		if(root == null)
			return ;
		
		LinkedList<TreeLinkNode> que = new LinkedList<TreeLinkNode>();
		TreeLinkNode temp1 = root;
		TreeLinkNode temp2 = null;
		
		que.add(null);
		while(!que.isEmpty()){
			temp2 = que.removeFirst();
			if(temp1 != null){   //temp1 != null，则将temp1的左右子树加入队列，并将temp1.next设为temp2.然后将temp1=temp2
				que.add(temp1.left);
				que.add(temp1.right);
				temp1.next = temp2;
				temp1 = temp2;
			}
			else if(temp1 == null){
				if(temp2 == null)
					return ;
				que.add(null);
				temp1 = temp2;
			}
		}
		return ;
    }

}
