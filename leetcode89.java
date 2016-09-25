/**
* 题目：参数为int n，输出所有0--n-1的数，并且相邻的两位的二进制只差别1位。
* 思路：这个题原来是有规律的，但是我用的是动态规划进行编程的。
* 
*
**/

public class Solution {
    public List<Integer> grayCode(int n) {
      	List<Integer> result = new ArrayList<Integer>();
		result.add(0);
		if(n == 0)
			return result;
		int[] nums = new int[n];
		for(int i=0;i<n;i++)
			nums[i] = 0;
		helper(nums,result);
		return result;
    }
    
    public void helper(int[] nums, List<Integer> result){
		int length = nums.length;  //nums的长度
		for(int i = length-1;i>=0;i--){
			int temp = 0;
			int j = 0;
			if(nums[i] == 1){
				nums[i] = 0;
				temp = arrayToInt(nums);
				for(j=0;j<result.size();j++){
					if(result.get(j) == temp)
						break;
				}
				if(j == result.size()){
					result.add(temp);
					if(result.size() == Math.pow(2, nums.length))
						return ;
					break;
				}
				else{
					nums[i] =1;
				}
			}
			else{
				nums[i] = 1;
				temp = arrayToInt(nums);
				for(j=0;j<result.size();j++){
					if(result.get(j) == temp)
						break;
				}
				if(j == result.size()){
					result.add(temp);
					if(result.size() == Math.pow(2, nums.length))
						return ;
					break;
				}
				else{
					nums[i] =0;
				}
			}
		}
		
		helper(nums,result);
		return ;
	}
	
	public int arrayToInt(int[] nums){
		int length = nums.length;
		int i = 0;
		int result = 0;
		while(i<length){
			result =result<<1;
			result += nums[i];
			i++;
		}
		return result;
	}

}
