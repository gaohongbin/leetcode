public class Solution {
    public String reverseString(String s) {
        StringBuffer strBuf=new StringBuffer(s);
	    	int len=s.length();
	    	char temp;
	    	for(int i=0;i<len/2;i++){
	    		temp=strBuf.charAt(i);
	    		strBuf.setCharAt(i, strBuf.charAt(len-i-1));
	    		strBuf.setCharAt(len-i-1, temp);
	    	}
	    	return strBuf.toString();
    }
}
