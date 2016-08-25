public class Solution {
    public static boolean isPerfectSquare(int num) {
        if(num == 1)  //num==1 时，num/2==0没法搞
           return true;

		 int low = 0;
		 int high = num/2 > 46340?46340:num/2;
	     return isPerfectSquareHelper(low, high,num);
	    }
	 public static boolean isPerfectSquareHelper(int low, int high,int num){
		 if(low > high)
			 return false;

		 int mid = (low + high)/2;
		 if(mid * mid > num){
			 return isPerfectSquareHelper(low, mid-1,num);
		 }
		 else if(mid * mid < num){
			 return isPerfectSquareHelper(mid+1, high,num);
		 }
		 else return true;
	 }
}
