public class Solution {
    public int getSum(int a, int b) {
        int xor = 0;
	      int and = 0;
	      int sum = 0;
	    
	      xor = a^b;
	      and = a&b;
	      and = and<<1;
        	
	      if(and==0)
	    	  return xor;
	      else
	    	  return getSum(xor,and);
    }
}
