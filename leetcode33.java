/**
*这个题没什么技巧，就是把各种情况都考虑一下，写了很多if else。
*
*/

public class Solution {
    public int search(int[] nums, int target) {
       if(nums == null || nums.length == 0)
    		return -1;
    	int length = nums.length;
    	
    	int low = 0;
    	int high = length-1;
    	int mid = (low+high)/2;
    	while(low<high){
    		mid = (low+high)/2;
    		if(nums[low]>nums[high]){  //如果low和high之间包含的数组是转换数组
    			if(nums[low]==target)
    				return low;
    			else if(nums[high] == target)
    				return high;
    			else if(nums[mid]==target)
					return mid;
    			else if(nums[mid]>target && target >nums[low])
					high = mid-1;
				else if(nums[low]<target && nums[mid]<target && nums[mid]>nums[low])
					low = mid+1;
				else if(nums[low]<target && nums[mid]<target && nums[mid]<nums[low])
					high=mid-1;
				else if(nums[low]>target && nums[mid]>nums[low])
					low = mid+1;
				else if(nums[low]>target && nums[mid] < nums[low] && nums[mid]>target)
					high=mid-1;
				else if(nums[low]>target && nums[mid] < nums[low] && nums[mid]<target)
					low = mid+1;
				else
					break;
    		}
    		else if(nums[low]<nums[high]){  //如果不是转换数组，即为正常的排序数组
    			if(nums[low]>target || nums[high]<target)
    				return -1;
    			else if(nums[low] == target)
    				return low;
    			else if(nums[high] == target)
    				return high;
    			else if(nums[mid] == target)
    				return mid;
    			else if(nums[low]<target && nums[high]>target && nums[mid]<target)
    				low = mid+1;
    			else if(nums[high]>target && nums[low]<target && nums[mid]>target)
    				high = mid-1;
    			else
    				return -1;
    		}
    	}
    	
    	if(nums[low] == target) //如果low==high
    		return low;
    	return -1;
    }
}
