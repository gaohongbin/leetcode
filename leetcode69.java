public class Solution {
    public int mySqrt(int x) {
        if(x==0)
          return 0;
        if(x==1)
          return 1;
          
        int low = 0;
		int high = x/2 > 46340?46340:x/2;
	      return mySqrtHelper(low, high,x);
    }
    public int mySqrtHelper(int low, int high,int x){
		  if(low == high || low>high){
			 if(high * high == x || (high * high <x && (high+1)*(high+1)>x))
				 return high;
			 else if(high * high >x)
				 return high-1;
			 else
				 return high;
				 
		 }
			 
		 int mid = (low + high)/2;
		 if(mid * mid > x){
			 return mySqrtHelper(low, mid-1,x);
		 }
		 else if(mid * mid < x){
			 return mySqrtHelper(mid+1, high,x);
		 }
		 else return mid;
	 }
    
}
