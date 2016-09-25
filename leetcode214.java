/**
*
* 题目：参数为字符串s，返回在s前面加最少的字符将s转换成回文字符串。
* 思路：找出s从0开始的最长的回文字符串。然后将s后面的字符加入到s前面，转换成回文字符串。
*
*
**/




public class Solution {
    public static String shortestPalindrome(String s) {
		if(s == null || s.length() ==0)
			return s;
		
		if(isPalindrome(s,0,s.length()-1))
			return s;
		
		int length = s.length(); 
		int index = 2;
		
		while(index<length){
			if(isPalindrome(s,0,length-index))
				break;
			index++;
		}
		
		int sub = 1;
		StringBuffer result = new StringBuffer();
		while(sub<index){
			result.append(s.charAt(length-sub));
			sub++;
		}
		result.append(s);
		return result.toString();
    }
	
	public static boolean isPalindrome(String s, int low, int high){
		if(high-low+1 == 1)
			return true;
		
		while(low<high){
			if(s.charAt(low) != s.charAt(high))
				return false;
			low++;
			high--;
		}
		return true;
	}
}
