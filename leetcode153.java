public class Solution {
    public int findMin(int[] nums) {
                    int length=nums.length;
	        if(length==1)
	        	return nums[0];
	        if(length==2)
	        	return nums[0]<nums[1]?nums[0]:nums[1];
	        
	        int low=0,high=length-1;
	        int mid=(low+high)/2;
	        
	        while(low<high-1){
	        	mid=(low+high)/2;
	        	if(nums[low]<nums[mid] && nums[mid]>nums[high])
		        	low=mid;
		        else if(nums[low]>nums[mid] && nums[mid]<nums[high])
		        	high=mid;
		        else if(nums[low]<nums[mid] && nums[mid]<nums[high])
		        	return nums[low];
		        else if(nums[low]>nums[mid] && nums[mid]>nums[high])
		        	return nums[high];
	        }
	        return nums[low]>nums[high]?nums[high]:nums[low];
    }
}
