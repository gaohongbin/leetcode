public class Solution {
    public int removeElement(int[] nums, int val) {
         int length=nums.length;
	        if(length==0)
	        	return 0;
	        
	        int index=0;
	        for(int i=0;i<length;i++){
	        	if(nums[i]!=val){
	        		nums[index++]=nums[i];
	        	}
	        }
	        return index;
    }
}
