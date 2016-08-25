public class Solution {
    public static int findKthLargest(int[] nums, int k) {
		return findKth(nums,k,0,nums.length-1);
	}
	
	public static int findKth(int[] nums, int k, int start, int end){
		if(start>=end)
			return nums[start];
		
	    int flag=nums[start];
	    int low=start;
	    int high=end;
	    while(low<high){
	    	while(low<high && nums[high]>flag)
	    		high--;
	    	if(low<high){
	    		nums[low]=nums[high];
	    		low++;
	    	}
	    	
	    	while(low<high && nums[low]<=flag)
	    		low++;
	    	if(low<high){
	    		nums[high]=nums[low];
	    		high--;
	    	}
	    }
	    nums[low]=flag;
	    if(end-low==k-1)
	    	return flag;
	    if(end-low>=k)
	    	return findKth(nums, k, low+1, end);
	    else
	    	return findKth(nums, k-(end-low)-1, start,low-1);
	}
}
