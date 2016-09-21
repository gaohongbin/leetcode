/**
 * 题目：类似于八皇后问题。 皇后的个数又参数n确定
 * 返回所有的情况， 皇后的位置 用Q标记，其他位置用'.'标记。
 * 
 * 思路：回溯
 * 
 * @author: hongbin.gao
 *
 */
public class Leetcode51 {
	public static void main(String[] args){
		int n = 4;
		List<List<String>> result = solveNQueens(n);
		System.out.println(result);
	}

	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> list = new ArrayList<List<String>>();
		if(n==0)
			return list;
		int[] queen = new int[n];
		for(int i=0;i<n;i++)
			queen[i] = i+1;
		
		helper(queen,0,list);
		return list;
    }
	
	
	public static void helper(int[] nums, int pos,List<List<String>> list){
		if(pos == nums.length-1){
			if(check(nums,0,nums.length-1)){
				List<String> subList = new ArrayList<String>();
				StringBuffer strBuf = new StringBuffer();
				for(int i=0;i<nums.length;i++){
					for(int j=0;j<nums.length;j++){
						if(j == nums[i]-1)
							strBuf.append('Q');
						else
							strBuf.append('.');
					}
					subList.add(strBuf.toString());
					strBuf.setLength(0);
				}
				list.add(subList);
			}
			return ;
		}
		
		for(int i=pos;i<nums.length;i++){
			swap(nums, pos, i);
			if(pos>=1 && !check(nums,0,pos)){
				swap(nums, pos, i);
				continue;
			}
			helper(nums,pos+1,list);
			swap(nums, pos, i);
		}
		return ;
	}
	
	public static boolean check(int[] nums, int point1, int point2){
		int length = nums.length;
		for(int i=point1;i<point2;i++)
			for(int j= i+1;j<=point2;j++){
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
