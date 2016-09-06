import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * @author ghb
 *
 */

public class Leetcode103 {
	public static void main(String[] args){
		TreeNode head = new TreeNode(3);
		TreeNode p1 = new TreeNode(9);
		TreeNode p2 = new TreeNode(20);
		TreeNode p3 = new TreeNode(15);
		TreeNode p4 = new TreeNode(7);
		
		head.left = p1; head.right = p2;
		p1.left = p1.right = null;
		p2.left = p3; p2.right = p4;
		p3.left = p3.right = null;
		p4.left = p4.right = null;
		List<List<Integer>> list = zigzagLevelOrder(head);
		System.out.println(list);
		
	}
	/**
	 * 思路：用队列存储二叉树节点，用notNull来统计某一层一共多少各！null的节点，则下一层的加入到队列的节点个数为notNull*2,（因为即使子树为null，也会加入队列）
	 * 让length = notNull*2, 当从队列中取出length个节点后，表示该层遍历完成。在遍历某一层时，不仅要往队列中添加下一层的节点，还要在subList中添加非空节点的值。
	 * 初始时，设置length =1(第一层只有一个节点)。
	 * 
	 * 最后将list中的奇数位的列表内容进行翻转。
	 * 
	 * @param root
	 * @return
	 */
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> subList ;
		
		if(root == null)
			return list;
		
		LinkedList<TreeNode> que = new LinkedList<TreeNode>();  //队列用来存储二叉树的节点
		int length = 1; //length = notNull*2,用来计算下一层要从队列中取出多少个节点。
		que.add(root);  //把root加入队列
		TreeNode p = null;
		int i=0;  //用来遍历
		int notNull = 0;
		
		/*subList = new ArrayList<Integer>();  //先把头节点加进去
		subList.add(root.val);
		list.add(subList);*/
		
		while(length>0){
			subList = new ArrayList<Integer>();
			i=0;
			notNull=0;
			while(i<length){
			   p = que.pollFirst();  //p==null,再从队列里弹出队列头
			   i++;
			   
			   if(p!=null){
				   notNull++;
				   
				   que.addLast(p.left);  //即使p.left == null 或者p.right == null,也要加进去
				   que.addLast(p.right);
				   
				   subList.add(p.val);
			   }
			}
			if(subList.size()>0)
			  list.add(subList);
			length = notNull*2;
		}
		
		//下面开始将list中奇数位的subList颠倒一下。
		for(int j=0;j<list.size();j++){
			if((j&1) ==1)
				converseList(list.get(j));
		}
		
		return list;
	}
	
	public static <T> void converseList (List<T> list){
		if(list == null)
			return ;
		int length = list.size();
		T temp;
		int i=0;
		while(i<length/2){
			temp = list.get(i);
			list.set(i, list.get(length-i-1));
			list.set(length-i-1,temp);
			i++;
		}
		return ;
	}
}

