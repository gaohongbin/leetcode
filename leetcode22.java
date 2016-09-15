/**
 * 题目：输入一个参数n，给出有n个左括号和右括号组成的括号组合。
 * 
 *  思路：动态规划，我觉得这些题都是字符排列组合问题的拓展。
 *  用left和right分别记录还剩多少左括号和右括号要加入到字符串中，当left==0. 把剩下的右括号全部加进去。
 *  
 *  如果left不为0，分为两种情况，继续加左括号还是加右括号，但是加右括号又有限制，必须当left<right时候才能加。
 *  基于这样的思路，写出如下的代码。
 *
 * @author: hongbin.gao
 *
 */
public class Leetcode22 {
	public static void main(String[] args){
		int n = 5;
		List<String> list = generateParenthesis(n);
		System.out.println(list);
	}
	
    public static List<String> generateParenthesis(int n) {
    	List<String> list = new ArrayList<String>();
    	if(n == 0)
    		return list;
    	
    	StringBuffer strBuf = new StringBuffer();
    	helper(list,strBuf,n,n);
    	return list;
        
    }
    
    public static void helper(List<String> list, StringBuffer strBuf, int left, int right){
    	if(left == 0){
    		int temp = right;
    		while(right>0){
    			strBuf.append(')');
    			right--;
    		}
    		list.add(strBuf.toString());
    		while(right<temp){
    			strBuf.deleteCharAt(strBuf.length()-1);
    			right++;
    		}
    		return ;
    	}
    	
    	strBuf.append('(');
    	left --;
    	helper(list,  strBuf,left,right);
    	
    	strBuf.deleteCharAt(strBuf.length()-1);
    	left++;
    	
    	if(right>left){
    		strBuf.append(')');
    		right--;
    		helper(list,  strBuf,left,right);
    		
    		strBuf.deleteCharAt(strBuf.length()-1);
        	right++;
    	}
    	
    	return ;
    }
}
