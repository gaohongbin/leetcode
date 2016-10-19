/**
 * 题目：输入参数为一个字符串s，输出为int，表示至少要将s切多少次，才可以将其所有的字串均为回文。
 * 
 * 思路：用result[i] 表示s.subString(0,i+1) 是否为回文。
 * result[i] 最大为result[i-1]+1. 当s.charAt(i)可以和前面的字符串组成回文字串时，则遍历所有的包含以s.charAt(i)为末尾字符的字串的最少
 * 切割次数，则为result[i]的值。
 * 
 * 题目中我们可以不用函数去判断一个字符串是否为回文字符串，只需要使用boolean[][] mid做标记即可。
 * 当判断s.subString(i,j+1)是否为回文，我们只需要判断s.charAt(i) 和s.charAt(j), 剩下的使用mid[i+1][j-1]是否为回文即可判断s.subString(i,j+1)是否为回文。
 * 
 * @author: hongbin.gao
 *
 */
public class Leetcode132 {
	public static void main(String[] args){
		String s = "aaba";
		int result = minCut(s);
		System.out.println(result);
	}
	
	public static int minCut(String s) {
		if(null == s || s.length() == 0)
			return 0;
		if(isPalindrome(s)) //先整体进行判断
			return 0;
		
		int length = s.length();
        int pos = 1;
        int[] result = new int[length]; //result[i]表示s.subString(0,i+1)的最少切多少次
        result[0]= 0;
        
        boolean[][] mid = new boolean[length][length];  //mid[i][j]表示s.subString(i,j+1)是否为回文
        for(int i=0;i<length;i++)
        	mid[i][i] = true;
        
        helper(s,pos,result,mid);
        return result[length-1];
    }
	
	public static void helper(String s, int pos, int[] result,boolean[][] mid){

		int length = s.length();
		for(int i=pos;i<length;i++){
			result[i] = result[i-1]+1;
			for(int j=i-1;j>=0;j--){
				if(s.charAt(j) == s.charAt(i) && (i-j<=1 || mid[j+1][i-1])){  
					mid[j][i] = true;
					if(j==0)
						result[i] = 0;
					else if(result[j-1]+1<result[i])
						result[i] = result[j-1]+1;
				}
				else
					mid[j][i] = false;
			}
		}
		return ;
	}
	
	
	/**
	 * 判断字符串是否是回文字符串
	 * 
	 */
	public static boolean isPalindrome(String str){
		if(null == str || str.length() ==0)
			return true;
		
		int length = str.length();
		int i=0;
		while(i<length/2){
			if(str.charAt(i) != str.charAt(length-i-1))
				return false;
			i++;
		}
		return true;
	}

}
