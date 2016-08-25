public class Solution {
    public int trailingZeroes(int n) {
        //	        int numOfTwo=0;
	        int numOfFive=0;
//	        numOfTwo=n/2;
//	        while(numOfTwo>0)
//	        	numOfTwo+=numOfTwo/2;
	        numOfFive=n/5;
	        int mid=numOfFive;
	        while(mid>0){
	        	numOfFive+=mid/5;
	        	mid=mid/5;
	        }
	        return numOfFive;
    }
}
