public class Solution {
   /**
 * 思路：和leetcode90很类似，只需要小小的变换一下就可以了。
 * 这个是递归的思路，也可以像leetcode15题那样，先进行排序，再做处理。
 * 
 * @author hongbin.gao
 *
 */
   public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length<3)
        	return 0;
        
        
        List<Integer> subList = new ArrayList<Integer>();
        int[] result = new int[1];
        result[0] = nums[0]+nums[1]+nums[2];
        helper(subList,nums,0,target,result);
        return result[0];
    }
    /**
     * 
     * @param subList 用来保存长度为3的整数列表
     * @param nums 数组
     * @param pos 从某个位置开始进行循环
     * @param target
     * @param result 到目前为止最小的值
     */
   public static void helper(List<Integer> subList, int[] nums,int pos, int target,int[] result){
	   if(subList.size() == 3 ){  //subList满足要求
		  int temp =0;
		  for(int i=0;i<subList.size();i++)
			  temp += subList.get(i);
		   if(Math.abs(target-temp) < Math.abs(target-result[0]))
			   result[0]=temp;
		   return ;
	   }
	   if(pos >= nums.length)
		   return ;
	   if(subList.size() ==3)
		   return ;
	   
	   for(int i=pos;i<nums.length;i++){
		   subList.add(nums[i]);
		   helper(subList,nums,i+1,target,result);
		   if(result[0] == target)  //如果result[0] == target 及时结束循环
			   return ;
		   subList.remove(subList.size()-1);
	   }
   }
}
