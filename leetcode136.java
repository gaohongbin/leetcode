public class Solution {
    public int singleNumber(int[] nums) {
        int length=nums.length;
    	if(length==1)
    		return nums[0];
        int sum=nums[0];
        for(int i=1;i<length;i++){
        	sum=sum^nums[i];
        }
        return sum;
    }
}
