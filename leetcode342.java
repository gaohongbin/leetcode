public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num<0)
	        	return false;
	        else{
	        	double result=Math.log(num)/Math.log(4);
	            if(Math.abs(result-Math.rint(result))<0.00000001)
	            	return true;
	            else
	            	return false;
	        }
    }
}
