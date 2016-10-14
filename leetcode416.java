/**
 * 题目：参数为一个整形数组，判断是否可以将数组分为两半，并且两部分之和相等。
 * 
 * 思路：计算数组之和sum，开一个boolean dp[sum/2+1]， dp[i] = true,表示数组的一部分可以组成和为i的子数组。
 * 当dp[i] = true, 并且 nums[k] = m, 则dp[i+m] = true（从dp[sum/2]开始计算，保证数组每个数字只用一次。）, 将数组遍历一遍，最后返回dp[sum/2].
 * 
 * @author ghb
 *
 */
public class Leetcode416 {
	public static void main(String[] args){
		int[] nums = {1,5,11,5};
		boolean result = canPartition(nums);
		System.out.println(result);
	}
	
	public static boolean canPartition(int[] nums) {
		if(nums == null || nums.length ==0)
			return true;
		
		int sum = 0;  //先计算整个数组之和。
		for(int i=0;i<nums.length;i++) 
			sum += nums[i];
		
		if((sum&1) ==1)  //如果sum为奇数，则返回false。
			return false;
		
		boolean[] dp = new boolean[sum/2+1];
		dp[0] = true;
		for(int i=0; i<nums.length;i++){
			for(int j=sum/2;j>=nums[i];j--)
				dp[j] = (dp[j] | dp[j-nums[i]]);
		}
		return dp[sum/2];
	}
}

