public class Solution {
    public double myPow(double x, int n) {
            if(n==0)
	        	return 1;
	        if(n==1)
	        	return x;
	        int flag=0;
	        if(n<0){
	            flag=1;
	            n=-n;
	        }
	        
	        double result=myPow(x, n>>1);
	        result=result*result;
	        
    	    if((n & 0x1)==1)
    	        result= result*x;
    	    if(flag==0){ 
    	        return result;
	        }
	        else{
	            return 1.0/result;
	        }
    }
}
