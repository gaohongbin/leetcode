public class Solution {
    public int reverse(int x) {
        int flag=0;
	    int reverseOfX=0;
		if(x<0){
			flag=1;
			x=-x;
		}
		
		StringBuffer StrBufOfX=new StringBuffer(String.valueOf(x));
		int length=StrBufOfX.length();
		if(length==10){
			char temp;
			for(int i=0;i<length/2;i++){
				temp=StrBufOfX.charAt(i);
				StrBufOfX.setCharAt(i, StrBufOfX.charAt(length-1-i));
				StrBufOfX.setCharAt(length-1-i, temp);
			}
			if(flag==0 && StrBufOfX.toString().compareTo("2147483647")>0){
				return 0;
			}
			else if(flag==1 && StrBufOfX.toString().compareTo("2147483648")>0){
				return 0;
			}
		}
		
		while(x>0){
			reverseOfX=reverseOfX*10+x%10;
			x=x/10;
		}
		if(flag==1)
			return -reverseOfX;
		return reverseOfX;
    }
}
