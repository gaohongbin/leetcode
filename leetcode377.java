
/**
 * 题目:参数为一个数组nums和一个整形target，找出用nums中的元素组成target的所有可能排列(注意这里是排列。如果是组合1,2和2,1就算一种，如果是排列，1,2和2,1就要算两种)。
 * 思路： 类似于完全背包问题 。 result[i] = nums[j] + result[i-nums[j]]  但j要遍历整个nums数组并且nums[j]<=i(如果j不是遍历nums真个数组，则就变为0-1背包问题)。
 * result[i]表示target为i时，一共有多少种排列。
 * 
 * @author: hongbin.gao
 *
 */

public class Leetcode377 {
	public static void main(String[] args){
		int[] nums = {3,2,1};
	    int target = 4;
	    int result = combinationSum4(nums,target);
	    System.out.println(result);
	}
	
	public static int combinationSum4(int[] nums, int target) {
		int[] result = new int[target+1];
		result[0] =1;
		for(int i=1;i<=target;i++){
			for(int j=0;j<nums.length;j++){
				if(nums[j]<=i)
					result[i] += result[i-nums[j]];
			}
		}
		return result[target];
    }
}
