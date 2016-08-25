public class Solution {
    public int findDuplicate(int[] nums) {
         int length=nums.length;
	       
	       int low=1,high=length-1;
	       int mid=(high+low)/2;
	       int count=0;
	       
	       while(low<high){
	    	   
	    	count = count(nums,mid);
	    	if(count<=mid){
	    		low=mid+1;
	    	}
	    	else
	    		high=mid;
	    	mid=(high+low)/2;
	       }
	       return mid;
    }
    
    public int count(int[] nums,int mid){
		int length=nums.length;
		int count=0;
		for(int i=0;i<length;i++){
			if(nums[i]<=mid)
				count++;
		}
		return count;
	}
}
