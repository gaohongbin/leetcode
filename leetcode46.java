public class Leetcode46 {
	public static void main(String[] args){
		int[] nums = {1,2,3};
		List<List<Integer>> result = permute(nums);
		System.out.println(result);
	}
	
	public static List<List<Integer>> permute(int[] nums) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    if(nums == null || nums.length == 0)
	    	return result;
	    
	    List<Integer> subList = new ArrayList<Integer>();
	    int pos = 0;
	    helper(nums,pos,result,subList);
	    return result;
	}
	
	public static void  helper(int[] nums, int pos,List<List<Integer>> result,List<Integer> subList){
		if(pos == nums.length-1){  //如果pos到了最后一个
			subList.add(nums[pos]);
			List<Integer> temp = new ArrayList<Integer>();
			for(int i=0;i<subList.size();i++){
				temp.add(subList.get(i));
			}
			result.add(temp);
			subList.remove(subList.size()-1);	
			return ;
		}
		for(int i= pos;i<nums.length;i++){
			int temp = nums[i];
			nums[i] = nums[pos];
			nums[pos] = temp;
			
			subList.add(nums[pos]);
			helper(nums,pos+1,result,subList);
			subList.remove(subList.size()-1);
			
			temp = nums[i];
			nums[i] = nums[pos];
			nums[pos] = temp;
		}
	}
}
