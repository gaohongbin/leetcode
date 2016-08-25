public class Solution {
    public int majorityElement(int[] nums) {
         int length=nums.length;
	        
	        int cont=0;
	        int major=nums[0];
	        for(int i=0;i<length;i++){
	        	if(cont==0){
	        		major=nums[i];
	        		cont++;
	        	}
	        	else{
	        		if(major==nums[i])
	        			cont++;
	        		else 
	        			cont--;
	        	}
	        }
	        return major;
    }
}
