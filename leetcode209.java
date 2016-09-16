/**
 * 题目：给一个数组nums和整数s,数组中全是正数，找出数组中的最短子集，使子集中数字之和>=s,如果不存在，返回0.
 * 寻找的子集必须是连续的。
 * @author ghb
 *
 * 思路：用两个指针，一个low，一个high， low和high之间的数字就是组成s的数组中的数字。
 */
public class Leetcode209 {
	public static void main(String[] args){
		int[] nums = {2,3,1,2,4,3};
		int s = 7;
		int result = minSubArrayLen(s, nums);
		System.out.println(result);
	}
	
	public static int minSubArrayLen(int s, int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		
		int min = nums.length;
		int low = 0; //low和high两个指针之间的数之和为count。
		int high = 0;
		int count = 0;
		
		for(int i=0;i<nums.length;i++)
			count += nums[i];
		if(count<s)
			return 0;
		
		count = 0;
		for(high=0;high<nums.length;high++){
			count += nums[high];
			if(count>=s)
				break;
		}
		min = high-low+1;  //设置min的初值
			
		while(low<=high){
			while(count>=s){
				count -= nums[low];
				low++;
			}
			
			if(count<s){
				low--;
				count += nums[low];
				if(high-low+1<min)
					min = high-low+1;
				if(high==nums.length-1)
					break;
			}
			high++;
			count += nums[high];
		}
		return min;
	}
}

