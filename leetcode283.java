public class Solution {
    public void moveZeroes(int[] nums) {
          int length=nums.length;
	        if(length==0 || length==1)
	        	return ;
	        int i=0,number=0;
	        for(i=0;i<length;i++){
	        	if(nums[i]!=0){
	        		nums[number++]=nums[i];
	        	}
	        }
	        while(number<length){
	        	nums[number++]=0;
	        }
    }
}
