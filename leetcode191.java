public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sumOfOne=0;
		int i=1;
		/* while(n!=0){
	        	if((n&1)!=0)
	        		sumOfOne++;
	        	n=n>>1;
	        }*/
	        for(int j=0;j<32;j++){
	        	if((n&i)!=0)
	        		sumOfOne++;
	        	i=i<<1;
	        }
	        return sumOfOne;
    }
}
