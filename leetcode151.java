public class Solution {
    public String reverseWords(String s) {
            //s.trim();
            s=s.trim();
	        int length=0;
	        length=s.length();
	        if(length==0)
	        	return s;
	        StringBuffer strBuffer=new StringBuffer();
	        int lengthOfWord=0;
	        for(int i=length-1;i>=0;i--){
	        	if(s.charAt(i)==' ' && lengthOfWord!=0){
	        		strBuffer.append(s.substring(i+1, length));
	        		strBuffer.append(" ");
	        		lengthOfWord=0;
	        		length=i;
	        	}
	        	else if(s.charAt(i)==' ' && lengthOfWord==0){
	        		length--;
	        	}
	        	else if(s.charAt(i)!=' ')
	        		lengthOfWord++;
	        	if(i==0){
	        		strBuffer.append(s.substring(i, length));
	        	}
	        }
	        return strBuffer.toString();
    }
}
