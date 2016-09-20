/**
 * 题目：对给定数组nums进行排列，返回所有的排列，但nums中可能有重复的数字。
 * 
 * 思路：排列的时候和普通的 求排列类似，只是每次排列以后，将移动过的 数字进行标记，以免重复。
 *
 * @author: hongbin.gao
 *
 */
public class Leetcode47 {
	public static void main(String[] args){
		int[] nums = {0,0,9,1};
		List<List<Integer>> result = permuteUnique(nums);
		System.out.println(result);
	}
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return result;
		
		Arrays.sort(nums);
		List<Integer> subList = new ArrayList<Integer>();
		int pos = 0;
		helper(nums,pos,result,subList);
		return result;
	}
	
	public static void helper(int[] nums, int pos, List<List<Integer>> result,List<Integer> subList){
		int[] flag = new int[nums.length-pos];  //flag标记哪些数字已经放到前面过
		int length = 0;  //length为flag中存入标记的个数
		boolean flag2 = true;
		
		if(pos == nums.length-1){
			subList.add(nums[pos]);
			List<Integer> temp = new ArrayList<Integer>();
			for(int i = 0;i<subList.size();i++){
				temp.add(subList.get(i));
			}
			result.add(temp);
			subList.remove(subList.size()-1);
			return ;
		}
		
		for(int i = pos;i<nums.length;i++){
			
			for(int j = 0;j<length;j++){
				if(flag[j] == nums[i]){
					flag2 = false;
				}
			}
			if(flag2){
				int tempNumber = nums[pos];
				nums[pos] = nums[i];
				nums[i] = tempNumber;
				
				subList.add(nums[pos]);
				helper(nums,pos+1,result,subList);
				subList.remove(subList.size()-1);
				
				tempNumber = nums[pos];
				nums[pos] = nums[i];
				nums[i] = tempNumber;
				
				flag[length] = nums[i];  //修改flag和length
				length++;
			}
			flag2 = true;
		}
		return ;
	}

}
