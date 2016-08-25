public class Solution {
    public int removeDuplicates(int[] nums) {
         int length=nums.length;
	        if(length==0 || length==1)
	        	return length;
	        int i=1,index=0;
	        while(i<length){
	        	if(nums[index]!=nums[i]){
	        		nums[++index]=nums[i];
	        		i++;
	        		continue;
	        	}
	        	i++;
	        }
	        return index+1;
    }
}
