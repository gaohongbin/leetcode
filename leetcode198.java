public class Solution {
    	 public static int rob(int[] nums) {
	       int len=nums.length;
	        int result=0;
	        for(int i=0;i<len;i++){
	        	result+=nums[i];
	        }
	        if(result==0)
	        	return 0;
	        int[][] mid=new int[len+1][len+1];  //因为是递归，用mid二维数组来保存中间结果。
	        result = robber(nums, 0, len-1,mid);
	        return result;
	    }
	 
	 public static int robber(int[] nums, int low, int high,int[][] mid){
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
	    		 noLow=robber(nums,low+1,high,mid);
	    		 mid[low+1][high]=noLow;
	    	 }
	    	 if(mid[low+1][high]!=0){
	    		 includeLow=nums[low]+robber(nums,low+2,high,mid);
	    		 mid[low+2][high]=includeLow-nums[low];
	    	 }
	     }
	     else{
	    	 includeLow=nums[low]+robber(nums,low+2,high,mid);
	    	 mid[low+2][high]=includeLow-nums[low];
	    	 noLow = robber(nums,low+1,high,mid);
	    	 mid[low+1][high] = noLow;
	     }
	         return includeLow>noLow?includeLow:noLow;
	 }
}
