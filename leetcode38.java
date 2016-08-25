public class Solution {
    public String countAndSay(int n) {
         if(n==1)
	        	return "1";
	        
	        String str=countAndSay(n-1);
	        StringBuffer result=new StringBuffer();
	        int temp=0;
	        int len = str.length();
	        if(len==1)
	        	return "11";
	        for(int i=0;i<len;i++){
	        	if(i==0)
	        		temp++;
	        	else if(str.charAt(i)!=str.charAt(i-1) && i!=len-1){
	        		result.append(temp);
	        		result.append(str.charAt(i-1));
	        		temp=1;
	        	}
	        	else if(i==len-1 && str.charAt(i)!=str.charAt(i-1)){
	        		result.append(temp);
	        		result.append(str.charAt(i-1));
	        		temp=1;
	        		result.append(temp);
	        		result.append(str.charAt(i));
	        	}
	        	else if(i==len-1){
	        		temp++;
	        		result.append(temp);
	        		result.append(str.charAt(i));
	        	}
	        	else
	        	   temp++;
	        }
	        return result.toString();
    }
}
