/**
 * 题目：参数为整形数组nums，找出nums中最长的升序序列的长度。
 * 
 * 
 * @author: hongbin.gao
 *
 */

public class Leetcode300 {
	public static void main(String[] args){
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		int result = lengthOfLIS(nums);
		System.out.println(result);
	}
	/**
	 * 方法一：直接用动态规划，helper中min表示现在这个列表中最大的数。针对nums[pos]分加入和不加入列表。
	 * 如果nums[pos]加入列表，修改min，如果nums[pos]不加入列表，不修改min。
	 * 
	 */
	public static int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length ==0)
			return 0;
		
		boolean flag = true;
		for(int i=0;i<nums.length-1;i++){   //判断原数组是不是一个升序序列。
			if(nums[i]>=nums[i+1]){
				flag = false;
				break;
			}
		}
		if(flag)
			return nums.length;
		
		int[] result = new int[1];
		
        List<Integer> list = new ArrayList<Integer>();
        helper(nums,0,Integer.MIN_VALUE,list,result);
        return result[0];
    }
	
	public static void helper(int[] nums, int pos, int min, List<Integer> list,int[] result){
		if(pos>=nums.length && list.size()>result[0]){
			result[0] = list.size();
			return ;
		}
		if(pos>=nums.length)
			return ;
		
		if(nums[pos] > min){
			list.add(nums[pos]);
			helper(nums,pos+1,nums[pos],list,result);
			list.remove(list.size()-1);
		}
		
		helper(nums,pos+1,min,list,result);
		return ;
	}
	
	/**
	 * 方法二：d[i]表示包含nums[i]元素的从0--i的最长列表，所以刚开始的时候初始化的时候，d[i]= 1,即只包含nums[i]一个元素。然后再看0--i-1里面，nums[i]能加入到
	 * 哪个列表里，将最长的结果存到d[i].
	 * 
	 * 当然这种方法的时间复杂度低很多。
	 * 
	 */
	public static int lengthOfLIS_2(int[] nums) {  
        //[10, 9, 2, 5, 3, 7, 101, 18],  
        if(nums==null || nums.length<1) return 0;  
          
        int [] d = new int[nums.length];  
        d[0] = 1;  
        int max = 1;  
        for(int i=1; i<nums.length; i++) {  
            d[i] = 1;  
            for(int j=0; j<i; j++) {  
                if(nums[i] > nums[j]) {  
                    d[i] = Math.max(d[i], d[j]+1);  
                }  
            }  
            max = Math.max(max, d[i]);  
        }  
        return max;  
    }  
}
