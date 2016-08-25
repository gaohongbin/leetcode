public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
             int lengthOfNums1=nums1.length;
	        int lengthOfNums2=nums2.length;
	        if(lengthOfNums1==0){  //nums1的长度为0
	        	if(lengthOfNums2%2==0){
	        		return (double)(nums2[lengthOfNums2/2]+nums2[lengthOfNums2/2-1])/2;
	        	}
	        	else
	        		return (double)nums2[lengthOfNums2/2];
	        }
	        else if(lengthOfNums2==0){ //nums2的长度为0
	        	if(lengthOfNums1%2==0){
	        		return (double)(nums1[lengthOfNums1/2]+nums1[lengthOfNums1/2-1])/2;
	        	}
	        	else
	        		return (double)nums1[lengthOfNums1/2];
	        }
	        int[] nums=new int[lengthOfNums1+lengthOfNums2];  //新建一个存储区域
	        
	        int i=0,j=0,lengthOfNums=0;
	        while(i<lengthOfNums1 && j<lengthOfNums2){  //将两个数组组合成新的排序数组
	        	if(nums1[i]<nums2[j]){
	        		nums[lengthOfNums]=nums1[i];
	        		i++;
	        		lengthOfNums++;
	        	}
	        	else{
	        		nums[lengthOfNums]=nums2[j];
	        		j++;
	        		lengthOfNums++;
	        	}
	        }
	        if(i==lengthOfNums1){
	        	while(j<lengthOfNums2){
	        		nums[lengthOfNums]=nums2[j];
	        		lengthOfNums++;
	        		j++;
	        	}
	        }
	        else{
	        	while(i<lengthOfNums1){
	        		nums[lengthOfNums]=nums1[i];
	        		lengthOfNums++;
	        		i++;
	        	}
	        }
	        
	        if(lengthOfNums%2==0){
	        	return (double)(nums[lengthOfNums/2]+nums[lengthOfNums/2-1])/2;
	        }
	        else
	        	return (double)nums[lengthOfNums/2];
    }
}
