public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
	        if((len&1)!=0)
	        	return false;
	        
	        char str[] = new char[len]; //定义一个char[]和s等长
	        int lenOfTrack =0; //类似于栈的指针，lenOfTrack是char[]的实际长度
	        for(int i=0;i<len;i++){
	        	if(lenOfTrack==0)
	        		str[lenOfTrack++]=s.charAt(i);
	        	else{
	        		if(s.charAt(i)==')' && str[lenOfTrack-1]=='(')
	        			lenOfTrack--;
	        		else if(s.charAt(i)==']' && str[lenOfTrack-1]=='[')
	        			lenOfTrack--;
	        		else if(s.charAt(i)=='}' && str[lenOfTrack-1]=='{')
	        			lenOfTrack--;
	        		else
	        			str[lenOfTrack++]=s.charAt(i);
	        	}
	        }
	        if(lenOfTrack==0)
	        	return true;
	        else return false;
    }
}
