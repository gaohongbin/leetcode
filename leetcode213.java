public class Solution {
   /**
	 * 题目：给一个数组，但这个数组表示一个收尾连接的环，如果取i位置的数字，则相邻的两个位置不能取，
	 * 求能取得最大的结果。
	 * 
	 * 思路：针对nums[0]分两种情况，剩下的就转换成一个纯数组的问题了。
	 * 
	 */
	public static int rob(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
			
		int result = 0;  //如果全为0
		for(int i=0;i<nums.length;i++){
		    result+=nums[i];
		}
		if(result == 0)
		  return 0;
		
		int length = nums.length;  //length表示数组的长度
		int result1 = 0; //result1表示打劫第一家
		int result2 = 0; //result2表示不打劫第一家
		int[][] mid = new int[length+1][length+1];
		result1 = nums[0] + helper(nums,2,length-2,mid);
		result2 = helper(nums,1,length-1,mid);
		if(result1>result2)
			return result1;
		return result2;
    }
	
	public static int helper(int[] nums, int low, int high,int[][] mid){
		 if(high<low)
			 return 0;
	     if(high==low)
	    	 return nums[low];
	     int includeLow=0,noLow=0;
	     if(mid[low+1][high]!=0 && mid[low+2][high]!=0){ //如果两个都计算过了
	    	 noLow=mid[low+1][high];
	    	 includeLow=nums[low]+mid[low+2][high];
	     }
	     else if((mid[low+1][high]!=0 || mid[low+2][high]!=0)&&(low+2<=high)){
	    	 if(mid[low+2][high]!=0){
	    		 noLow=helper(nums,low+1,high,mid);
	    		 mid[low+1][high]=noLow;
	    	 }
	    	 if(mid[low+1][high]!=0){
	    		 includeLow=nums[low]+helper(nums,low+2,high,mid);
	    		 mid[low+2][high]=includeLow-nums[low];
	    	 }
	     }
	     else{
	    	 includeLow=nums[low]+helper(nums,low+2,high,mid);
	    	 mid[low+2][high]=includeLow-nums[low];
	    	 noLow = helper(nums,low+1,high,mid);
	    	 mid[low+1][high] = noLow;
	     }
	         return includeLow>noLow?includeLow:noLow;
	 }
}
