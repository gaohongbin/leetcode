public class Solution {
    public int findPeakElement(int[] nums) {
       int result =0;
		 
		 if(nums.length == 1) //nums的长度为1
			 return result;
	     
		 if(nums[0]>nums[1])
			 return result;
		 for(int i=1;i<nums.length-1;i++){
			 if(nums[i]>nums[i-1] && nums[i]>nums[i+1])
				 return i;
		 }
		 if(nums[nums.length-1]>nums[nums.length-2])
			 return nums.length-1;
		 return 0;
    }
}
