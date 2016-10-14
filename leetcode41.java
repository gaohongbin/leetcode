/**
 * 题目:参数为一个整形数组，找出数组中缺失的第一个正数(>=1)数字。
 * 例如nums = {0，1，2} 则缺失的第一个正数为3.
 * 
 * 思路：如果nums[i] = j, 则将nums[i]放在 j-1 的位置。最后遍历一遍nums，如果nums[i] != i+1,则返回 i+1.
 * 如果最后遍历完了，则返回nums.length+1.
 * 
 *
 * @author: hongbin.gao
 *
 */
public class Leetcode41 {
	public static void main(String[] args){
		int[] nums = {1,1};
		int result= firstMissingPositive(nums);
		System.out.println(result);
	}
	
	public static int firstMissingPositive(int[] nums) {
		int length =  nums.length;
		
		int i=0;
		while(i<length){
			if(nums[i]<=length && nums[i]!=i+1 && nums[i]>=1 && nums[i]<=length && nums[nums[i]-1]!=nums[i]){
				change(nums,i,nums[i]-1);
			}
			else{
				i++;
			}
		}
      for(i=0;i<length;i++){
    	  if(nums[i]!=i+1)
    		  return i+1;
      }
      return length+1;
    }
	
	public static void change(int[] nums, int pos1, int pos2){
		int temp = nums[pos1];
		nums[pos1] = nums[pos2];
		nums[pos2] = temp;
	}

}
