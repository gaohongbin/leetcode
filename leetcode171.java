public class Solution {
    public int titleToNumber(String s) {
         int length=s.length();
	        int sum=0;
	        int height=1;
	        while(length>0){
	        	sum=sum+(int)(s.charAt(length-1)-'A'+1)*height;
	            height=height*26;
	            length--;
	        }
	        return sum;
    }
}
