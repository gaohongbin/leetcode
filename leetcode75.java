public class Solution {
    public void sortColors(int[] nums) {
       int length=nums.length;
	        if(length<=1)
	        	return ;
	        int left=0,right=length-1;
	        for(int i=0;i<=right;i++){
	        	if(nums[i]==0){
	        		int temp=0;
	        		temp=nums[i];
	        		nums[i]=nums[left];
	        		nums[left]=temp;
	        		left++;
	        	}
	        	else if(nums[i]==2){
	        		int temp=0;
	        		temp=nums[i];
	        		nums[i]=nums[right];
	        		nums[right]=temp;
	        		right--;
	        		i--;
	        	}
	        }
}
}
