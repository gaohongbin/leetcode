/**
 * 题目：对二叉树进行序列化和反序列化。
 * 
 * 将二叉树         1
 *         / \
 *        2   3
 *       / \
 *      4   5
 *  序列化为 "[1,2,3,null,null,4,5]"
 *  
 *  反序列化相反。
 *
 * @author: hongbin.gao
 *
 */
public class Leetcode297 {
	public static void main(String[] args){
		/*TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = null;
		root.left.left = root.left.right = null;
		
		System.out.println(serialize(root));*/
		String s = "[1]";
		System.out.println(deserialize(s).val);
		System.out.println(deserialize(s).left);
		System.out.println(deserialize(s).right);
	}

	// Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
    	if(root == null)
    		return "[]";
    	LinkedList<TreeNode> que = new LinkedList<TreeNode>();
    	TreeNode temp = root;
    	StringBuffer strBuf = new StringBuffer();
    	strBuf.append('[');
    	
    	while(!que.isEmpty() || temp != null ){
    		if(temp != null){
    			strBuf.append(temp.val+",");
    			que.add(temp.left);
    			que.add(temp.right);
    		}
    		else if(temp == null){
    			strBuf.append("null,");
    		}
    		temp = que.removeFirst();
    	}
    	
    	int length = strBuf.length();
    	while(length>0){
    		if(strBuf.charAt(length-1)>'9' || strBuf.charAt(length-1)<'0'){
    			strBuf.setLength(length-1);
    			length = strBuf.length();
    		}
    		else
    			break;
    	}
    	strBuf.append(']');
    	return strBuf.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	if(data.equals("[]"))  //如果为null的二叉树
    		return null;
    	
    	TreeNode root = null;
    	
    	LinkedList<TreeNode> que = new LinkedList<TreeNode>();  //用来保存二叉树的节点，以便可以将对应的左右子节点和父节点连接起来
    	TreeNode parent = null;   //
    	TreeNode child = null;
    	int lengthOfData = data.length();  //data的长度
    	int pos = 1; //遍历data时的指针
    	int val = 0;  //每个节点的val值
    	StringBuffer strBuf = new StringBuffer();  //储存每个节点的val时用来缓冲
    	int count = 0;  //count==0表示该child为parent的左子节点， count==1表示child为parent的右子节点
    	
    	char c ;
    	while(pos < lengthOfData){
    		c = data.charAt(pos);  //取字符
    		if(c == ',' ||  c==']'){
    			
				while(parent == null && !que.isEmpty()){
					parent = que.removeFirst();
				}
    			
				if(root == null && parent != null)
					root = parent;
				
    			if(strBuf.toString().equals("null")){
    				child = null;
    			}
    			else{
    				val = Integer.valueOf(strBuf.toString());
    				child = new TreeNode(val);
    				child.left = null;
    				child.right = null;
    			}
    			que.add(child);
    			
    			if(parent != null){
	    			if(count == 0){
	    				  parent.left = child;
	    				  count = 1;
	    			}
	    			else if(count == 1){
	    				parent.right = child;
	    				count = 0;   //将count设置为0
	    				parent = null;
	    			}
    			}
    			strBuf.setLength(0);
    		}
    		else{
    			strBuf.append(c);
    		}
    		
    		pos++;
    	}
    	
    	while(root == null && !que.isEmpty())
    		root = que.removeFirst();
        return root;
    }
}
