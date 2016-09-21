/**
 * 题目：类似于8皇后问题，只不过几个皇后是有给出的参数n决定的。
 * 返回：所有可能排列的种类
 * 
 * 思路：回溯
 * @author: hongbin.gao
 *
 */
public class Leetcode52 {
	public static void main(String[] args){
		int n = 8;
		int result = totalNQueens(n);
		System.out.println(result);
	}
	
	public static int totalNQueens(int n) {
		if(n==0)
			return 0;
		int[] queen = new int[n];
		for(int i=0;i<n;i++)
			queen[i] = i+1;
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		helper(queen,0,list);
		return list.size();
    }
	
	public static void helper(int[] nums, int pos,List<List<Integer>> list){
		if(pos == nums.length-1){
			if(check(nums)){
				List<Integer> subList = new ArrayList<Integer>();
				for(int i=0;i<nums.length;i++)
					subList.add(nums[i]);
				list.add(subList);
			}
			return ;
		}
		
		for(int i=pos;i<nums.length;i++){
			swap(nums, pos, i);
			helper(nums,pos+1,list);
			swap(nums, pos, i);
		}
		return ;
	}
	
	public static boolean check(int[] nums){
		int length = nums.length;
		for(int i=0;i<length-1;i++)
			for(int j= i+1;j<length;j++){
				if(j-i == Math.abs(nums[j]-nums[i]))
					return false;
			}
		
		return true;
	}
	
	public static void swap(int[] nums, int point1, int point2){
		int temp = nums[point1];
		nums[point1] = nums[point2];
		nums[point2] = temp;
	}

}
