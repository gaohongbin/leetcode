public class Solution {
    public boolean isPalindrome(String s) {
       	            int length=s.length();
	        if(length==0 || length==1)
	        	return true;
	        
	        s=s.toLowerCase();  //全部转换为小写
	        StringBuffer str=new StringBuffer(s);
//          int valueOfChar=0;
	        int index=0;
	        for(int i=0;i<length;i++){
	        	char charOfS=str.charAt(i);
//	        	valueOfChar=str.charAt(i)-'a';
	        	if((charOfS>='a' && charOfS<='z')||(charOfS>='0' && charOfS<='9')){
	        		str.setCharAt(index, str.charAt(i));
	        		index++;
	        	}
	        }
	        
	        int i=0;
	        while(i<index){
	        	if(str.charAt(i)!=str.charAt(index-1))
	        		return false;
	        	i++;
	        	index--;
	        }
	        return true;
	        
    }
}
