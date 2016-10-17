/**
 * 题目：输入参数为一个int数组nums，返回结果：数组中连续的一个子列的最大乘积。
 * 
 * 思路：用两个数组maxResult，minResult，其中maxResult[i]表示以nums[i]为结尾的子列的最大的乘积。 
 *  其中minResult[i]表示以nums[i]为结尾的子列的最小的乘积。
 *  
 * @author: hongbin.gao
 *
 */
public class Leetcode152 {
	public static void main(String[] args){
		int[] nums = {2,-3,2,-4,-5};
		int result = maxProduct(nums);
		System.out.println(result);
		
	}
	public static int maxProduct(int[] nums) {
        if(null == nums || nums.length == 0)
        	return 0;
        
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        int[] maxResult = new int[length];  //maxResult[i]表示以nums[i]为结尾的子列的最大积
        int[] minResult = new int[length];  //minResult[i]表示以nums[i]为结尾的子列的最小积
        maxResult[0] = nums[0];
        minResult[0] = nums[0];
        helper(nums,maxResult,minResult,1);
        
        for(int i=0;i<length;i++){
        	if(maxResult[i]>max)
        		max = maxResult[i];
        }
       
        return max;
    }
	
	public static void helper(int[] nums, int[] maxResult,int[] minResult, int pos){
		if(pos>=nums.length)
			return ;
		
		for(int i=pos;i<nums.length;i++){
			maxResult[i] = Math.max(Math.max(maxResult[i-1]*nums[i], minResult[i-1]*nums[i]),nums[i]);
			minResult[i] = Math.min(Math.min(maxResult[i-1]*nums[i], minResult[i-1]*nums[i]),nums[i]);
		}
		
		return ;
	}
}
