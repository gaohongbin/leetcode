public class Solution {
    public int integerBreak(int n) {
         if(n<=3)
	        	return n-1;
	        if(n==4)
	        	return 4;
	        
	        int result=1;
	        while(n>=5){
	        	result=result*3;
	        	n-=3;
	        }
	        result=result*n;
	        
	        return result;
    }
}
