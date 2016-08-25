public class Solution {
    public int searchInsert(int[] nums, int target) {
         int length=nums.length;
	        if(length==0)
	        	return 0;
	        for(int i=0;i<length;i++){
	        	if(nums[i]==target)
	        		return i;
	        	else if(target<nums[i])
	        		return i;
	        }
	        return length;
    }
}
