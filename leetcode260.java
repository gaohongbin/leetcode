public class Solution {
    public int[] singleNumber(int[] nums) {
          int length=nums.length;
	        int AxorB=0;
	        
	        for(int i=0;i<length;i++){
	        	AxorB=AxorB^nums[i];
	        }
	        
	        int mask=AxorB & (-AxorB);
	        int A=0,B=0;
	        for(int i=0;i<length;i++){
	        	if((mask & nums[i])==0)
	        		A^=nums[i];
	        	else
	        		B^=nums[i];
	        }
	        
	        int[] singleNumber=new int[]{A,B};
	        return singleNumber;
    }
}
