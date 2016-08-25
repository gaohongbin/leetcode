public class Solution {
    public int removeDuplicates(int[] nums) {
        int length=nums.length;
		if(length<=2)
			return length;
		int i=2;
		int index=2;
		while(i<length){
			if(nums[i]!=nums[index-2]){
				nums[index++]=nums[i++];
			}
			else{
				i++;
			}
		}
		return index;
	        
    }
}
