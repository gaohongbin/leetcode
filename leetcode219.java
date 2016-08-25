public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
         int len=nums.length;
	        if(len==0 || k==0)
	        	return false;
	        
	        Set<Integer> set=new HashSet<Integer>();
	        int i=0;
	        while(i<len && i<=k){ //取nums数组的前k个放在set里面
	        	if(set.contains(nums[i]))
	        		return true;
	        	set.add(nums[i++]);
	        }
	        int j=1;
	        while(j+k<len){
	        	set.remove(nums[j-1]);
	        	if(set.contains(nums[j+k]))
	        	   return true;
	            set.add(nums[j+k]);
	            j++;
	        }
	        return false;
    }
}
