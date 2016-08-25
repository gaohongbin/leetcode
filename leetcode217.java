public class Solution {
    public boolean containsDuplicate(int[] nums) {
         int length=nums.length;
	        if(length<=1)
	        	return false;
	        
	        Map<Integer,Boolean> map=new HashMap<Integer,Boolean>();
	        for(int i=0;i<length;i++){
	        	if(map.get(nums[i])==null)
	        		map.put(nums[i], true);
	        	else
	        		return true;
	        }
	        
	       return false;
    }
}
