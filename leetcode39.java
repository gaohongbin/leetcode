public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> list = new ArrayList<List<Integer>>();
	   List<Integer> subList = new ArrayList<Integer>();
	   if(candidates == null)
		   return list;
	   
	   combinationSum(candidates, target, 0, candidates.length-1, list, subList);
	   
	   return list;
    }
    
    public static void combinationSum(int[] nums, int target, int low, int high, List<List<Integer>> list,List<Integer> subList){
	   if(nums == null)
		   return ;
	   if(target == 0){
		   if(subList.size() == 0)
			   return ;
		   List<Integer> subList_1 = new ArrayList<Integer>();
		   for(int i=0;i<subList.size();i++)
			   subList_1.add(subList.get(i));
		   list.add(subList_1);
		   return ;
	   }
	   
	   if(low > high)
		   return ;
	   if(target<0)
		   return ;
	   
	   subList.add(nums[low]);
	   combinationSum(nums, target-nums[low], low, high, list, subList); //先使劲加第一个元素
	   subList.remove(subList.size()-1);
	   
	   combinationSum(nums, target, low+1, high, list, subList); //不加第一个元素
   }
}
