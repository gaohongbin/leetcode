/**
 * 题目：参数为int数组nums，将nums改为比原nums大，但却最小的数。 如果原来nums已经最大，则返回最小的数
 * 例如: 原来为 1,2,3 -> 1,3,2
 * 1,1,5 -> 1,5,1
 * 3,2,1 -> 1,2,3
 * 
 * 思路：如果原数组为逆序，则直接将元素nums逆序后返回。 如果原数组不为逆序，则pos++，如果nums[pos--length-1]逆序，则pos--，从nums[(pos+1)--length-1]
 * 找出比nums[pos]大，但最小的数。 将 nums[pos]和找到的数交换，再将nums[(pos+1)--length-1]进行升序排列，即为最后的结果。
 * 
 * @author: hongbin.gao
 *
 */
public class Leetcode31 {
	public static void main(String[] args){
		int[] nums = {1,3,2};
		nextPermutation(nums);
		for(int i=0;i<nums.length;i++)
			System.out.println(nums[i]);
	}
	
	public static void nextPermutation(int[] nums) {
		if(nums == null || nums.length == 1)
			return ;
		
		int length = nums.length;
		if(isDes(nums,0)){   //如果全部nums为逆序，直接返回
			Reverse(nums);
			return ;
		}
		
		int pos = 0;
		for(pos=0;pos<length-1;pos++){
			if(isDes(nums,pos)){
				break;
			}
		}
		
		pos--;
		int index = pos;
		int number = Integer.MAX_VALUE;
		for(int i = pos;i<=length-1;i++){
			if(nums[i]>nums[pos] && nums[i]<number){
				index = i;
				number = nums[index];
			}
		}
		
		nums[index] = nums[pos];
		nums[pos] = number;
		pos++;
		Arrays.sort(nums,pos,length);
		return ;

	}
	
	public static void Reverse(int[] nums){  //将数组逆序
		if(nums == null || nums.length ==1)
			return ;
		
		int length = nums.length;
		int i=0;
		while(i<length/2){
			int temp = nums[i];
			nums[i] = nums[length-1-i];
			nums[length-1-i] = temp;
			i++;
		}
		return ;
	}
	
	public static boolean isDes(int[] nums, int pos){  //判断nums从pos位置起到末尾，是否逆序
		if(pos == nums.length-1)  //如果只有一个数字
			return true;
		
		for(int start = pos; start<=nums.length-2; start++){
			if(nums[start]<nums[start+1])
				return false;
		}
		return true;
	}

}
