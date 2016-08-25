public class Solution {
    public static String longestPalindrome(String s) {
	        
		/*
		 * 我的思路是从中间向两边拓展，向两边拓展一共两种情况，一种是回文为奇数，另一种为偶数。
		 * 这两种情况应该分开讨论
		 */
		boolean flag=true;
		int len=s.length();
		if(len==0)
			return null;
		if(len==1)
			return s;
		StringBuffer str = new StringBuffer(s); //将s转为StringBuffer处理
		int i=0;
		
		for(i=0;i<len-1;i++){
			if(str.charAt(i)!=str.charAt(i+1)){
				flag=false;
				break;
			}
		}
		if(flag==true)
			return s;
		
		StringBuffer strBufOdd = new StringBuffer(1000);//最长的奇数回文字符串
		StringBuffer strBufEven = new StringBuffer(1000); //最长的偶数回文字符串

		//回文为奇数
		
		int low=0,high=0;
		for(i=1;i<len-1;i++){
			low=i-1;
			high=i+1;
			while(low>=0 && high<=len-1){
				if(str.charAt(low)==str.charAt(high)){ //找到更长的奇数回文就替换strBufOdd
					low--;
					high++;				
				}
				else if(str.charAt(low)!=str.charAt(high))
                   break;
			}
			if(high-low-1>strBufOdd.length())
				strBufOdd.replace(0, high-low-1, str.substring(low+1, high));
		}
		
		for(i=0;i<len-1;i++){
			low=i;
			high=i+1;
			while(low>=0 && high<=len-1){
				if(str.charAt(low)==str.charAt(high)){
					low--;
					high++;
				}
				else if(str.charAt(low)!=str.charAt(high))
					break;
			}
			if(high-low-1>strBufEven.length())
				strBufEven.replace(0, high-low-1, str.substring(low+1, high));
		}
		if(strBufOdd.length()>strBufEven.length())
			return strBufOdd.toString();
		return strBufEven.toString();
	    }
}
