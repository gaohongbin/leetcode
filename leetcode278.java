/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
         if(n==1)
	        	return 1;
	        
	        int low=1;
	        int high=n;
	        int test;
	        while(high>low){
	        	test=low+(high-low)/2;
	        	if(isBadVersion(test)==true)
	        		high=test-1;
	        	else if(isBadVersion(test)==false)
	        		low=test+1;
	        }
	        if(isBadVersion(high)==true)
	        	return high;
	        return high+1;
        
    }
}
