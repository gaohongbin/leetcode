public class Solution {
    public int maxSubArray(int[] nums) {
        int length=nums.length;
	        if(length==1)
	        	return nums[0];
	        
	        int[] sum=new int[length];
	        sum[0]=nums[0];
	        for(int i=0;i<length-1;i++){
	        	if(sum[i]<0){
	        		sum[i+1]=nums[i+1];
	        	}
	        	else
	        		sum[i+1]=sum[i]+nums[i+1];
	        }
	        
	        int max=sum[0];
	        for(int i=1;i<length;i++){
	        	if(max<sum[i])
	        		max=sum[i];
	        }
	        return max;
	        
    }
}
