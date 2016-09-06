import java.util.ArrayList;
import java.util.List;

/**
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  6   7
 *
 * @author hongbin.gao
 * 
 * 思路：这个题目可以用递归解决，但是这里为了事件复杂度更低，我没有采用递归来解决，用了一个while循环。
 *
 */
public class Leetcode113 {
	public static void main(String[] args){
		TreeNode head = new TreeNode(5);
		TreeNode p1 = new TreeNode(4);
		TreeNode p2 = new TreeNode(8);
		TreeNode p3 = new TreeNode(11);
		TreeNode p4 = new TreeNode(6);
		TreeNode p5 = new TreeNode(7);
		
		head.left = p1; head.right = p2;
		p1.left =p3; p1.right = null;
		p2.left = p4; p2.right = p5;
		p3.left = p3.right = null;
		p4.left = p4.right = null;
		p5.left = p5.right = null;
		
		int sum = 20;
		List<List<Integer>> list = pathSum(head, sum);
		System.out.println(list);
	}
	
	 public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		 
	        List<List<Integer>> list = new ArrayList<List<Integer>>();  //最终返回的结果
	        List<Integer> subList;
	        if(root == null)
	        	return list;
	         
	        List<TreeNode> nodeList = new ArrayList<TreeNode>();  //栈用来保存节点
	        List<Integer> flagList = new ArrayList<Integer>();   //占用来保存标识，0表示该节点只遍历了左子树，1表示已经遍历了右子树。
	        TreeNode p = root;
	        
	        while(!nodeList.isEmpty() || p!=null){
	        	if(p==null){  //p为null
	        		int flag = flagList.get(flagList.size()-1);
	        		
        			while(flag==1 && nodeList.size()>=1){
        				sum += nodeList.remove(nodeList.size()-1).val;  //弹出树节点。并修改sum
        				flagList.remove(flagList.size()-1);
        				if(flagList.isEmpty())
        					return list;
        				flag = flagList.get(flagList.size()-1);  //取最上面的标识，看是不是要继续弹出
        			}
        			
        			p = nodeList.get(nodeList.size()-1).right;  //当flag为0时，取其右节点
        			flagList.set(flagList.size()-1,1);  //将要访问右节点，所以换标示
	        	}
	        	else if(p.left == null && p.right ==null){ //p为叶节点
	        		nodeList.add(p);  //加入叶子节点
 	        		flagList.add(1); //因为是叶子节点，所以直接标识为1
	        		sum -= p.val;  //修改sum
	        		p = null;   //p==null,会从nodeList弹出节点
	        		
	        		if(sum == 0){
	        			subList = new ArrayList<Integer>();
		        		for(int i=0;i<nodeList.size();i++){
		        			subList.add(i, nodeList.get(i).val);  //完成subList
		        		}
		        		list.add(subList);     //将subList加入list
	        		}
	        		
	        	}
	        	else{  //p为普通节点
	        		sum -= p.val;
	        		nodeList.add(p);
	        		flagList.add(0);
	        		
	        		p = p.left;
	        	}
	        }
	        
	        return list;
	 }

}

