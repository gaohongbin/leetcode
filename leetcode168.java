public class Solution {
    public String convertToTitle(int n) {
        int remainder=0;
	        StringBuffer str = new StringBuffer(100);
	        char[] strABC={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	        
	        if(n<27)
	        	return strABC[n-1]+"";
	        
	        while(n>0){
	        	    remainder=n%26;
	        	    str.append(strABC[(remainder+25)%26]);
	        	    n=n/26;
	        	    if(remainder==0)
	        	    	n=n-1;
	        }
	        str.reverse();
	        return str.toString();
    }
}
