public class Solution {
    public boolean isPowerOfThree(int n) {
       double result=Math.log(n)/Math.log(3);
	        if (Math.abs(result-Math.rint(result))<0.0000000001){
	        	return true;
	        }
	        else 
	         return false;
    }
}
