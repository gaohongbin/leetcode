public class Solution {
    public static int[] searchRange(int[] nums, int target) {
		 int[] result = new int[2];
		 int length = nums.length;
		 
		 if(length == 0 || nums[0]>target || nums[length-1] < target){  //数组长度为0 或者nums最小的数大于target或者nums最大的数小于target，直接返回结果
			 result[0]=-1;
			 result[1]=-1;
			 return result;
		 }
		 
		 int low = searchRangeLow(nums,target,0, length-1);
		 int high = searchRangeHigh(nums,target, 0, length-1);
		 if(low<=high){
			 result[0]=low;
			 result[1]=high;
		 }
		 else{
			 result[0]=-1;
			 result[1]=-1;
		 }
		 return result;
	    }
	 public static int searchRangeLow(int[] nums, int target, int low, int high){
		 if(low > high)
			 return low;
		 
		 int mid = (low+high)/2;
		 if(nums[mid]<target)
			 return searchRangeLow(nums, target, mid+1, high);
		 else 
			 return searchRangeLow(nums,target, low,mid-1); 
	 }
	 
	 public static int searchRangeHigh(int[] nums, int target, int low, int high){
		 if(low > high)
			 return high;
		 
		 int mid = (low+high)/2;
		 if(nums[mid]>target)
			 return searchRangeHigh(nums, target, low, mid-1);
		 else 
			 return searchRangeHigh(nums,target, mid+1,high); 
	 }
}
