public class Solution {
    public boolean isPalindrome(int x) {
       // if(x<0)
	   //	  x=-x;
	        StringBuffer strBufOfX=new StringBuffer(String.valueOf(x));
	        int length=strBufOfX.length();
	        boolean flag=true;
	        for(int i=0;i<length/2;i++){
	        	if(strBufOfX.charAt(i)!=strBufOfX.charAt(length-1-i))
	        		flag=false;
	        }
	        return flag;
    }
}
