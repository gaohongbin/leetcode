public class Solution {
    public int findMin(int[] nums) {
        int length=nums.length;
    	if(length==1)
    		return nums[0];
    	
    	int low=0;
    	int high=length-1;
    	int mid=(low+high)/2;
    	int min=nums[0];
    	while(nums[low]>=nums[high]){
    		if(high-low==1)
    			return nums[high];
    		
    		mid=(low+high)/2;
    		if(nums[low]==nums[mid] && nums[mid]==nums[high]){
    			for(int i=1;i<length;i++){
    				if(nums[i]<min)
    					min=nums[i];
    			}
    			return min;
    		}
    		if(nums[low]<=nums[mid])
    			low=mid;
    		if(nums[mid]<=nums[high])
    			high=mid;
    	}
    	return nums[low];
    }
}
