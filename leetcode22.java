/**
 * ��Ŀ������һ������n��������n�������ź���������ɵ�������ϡ�
 * 
 *  ˼·����̬�滮���Ҿ�����Щ�ⶼ���ַ���������������չ��
 *  ��left��right�ֱ��¼��ʣ���������ź�������Ҫ���뵽�ַ����У���left==0. ��ʣ�µ�������ȫ���ӽ�ȥ��
 *  
 *  ���left��Ϊ0����Ϊ��������������������Ż��Ǽ������ţ����Ǽ��������������ƣ����뵱left<rightʱ����ܼӡ�
 *  ����������˼·��д�����µĴ��롣
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
