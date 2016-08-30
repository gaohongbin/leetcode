/**
* 说到底，这还是一个组合问题，组合问题其实把一个问题搞透了，搞明白了，其实都一样，
* 我觉得最好的还是leetcode90，可以看其中的第二种方法，弄明白了，所有的组合问题就透了。
*/


public class Solution {
   public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        if(candidates == null || candidates.length ==0)
	        	return null;
	        Arrays.sort(candidates);
	        List<List<Integer>> list = new ArrayList<List<Integer>>();
	        List<Integer> subList = new ArrayList<Integer>();
	        int remainder = target;
	        helper(list,subList,remainder,0,candidates);
	        return list;
	        
	 }
	 /**
	  * 
	  * @param list
	  * @param subList
	  * @param remainder 到现在位置距离target还有多远
	  */
	 public static void helper(List<List<Integer>> list, List<Integer> subList,int remainder,int pos,int[] nums){
		 if(remainder == 0 && subList.size()!=0){
			 List<Integer> subList_1 = new ArrayList<Integer>();
			 for(int i=0;i<subList.size();i++){
				 subList_1.add(subList.get(i));
			 }
			 list.add(subList_1);
			 return ;
		 }
		 
		 if(pos>nums.length || remainder<0)
			 return ;
		 
		 for(int i=pos;i<nums.length;i++){
			 subList.add(nums[i]);
			 remainder -= nums[i];
			 helper(list,subList,remainder,i+1,nums);
			 subList.remove(subList.size()-1);
			 remainder += nums[i];
			 while(i+1<nums.length && nums[i] == nums[i+1])
				 i++;
		 }
	 }

}
