public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         List<List<Integer>> list = new ArrayList<List<Integer>>();
	    List<Integer> subList = new ArrayList<Integer>();
	    
	    if(nums == null || nums.length == 0)  //数组为空或者数组包含长度为0
	    	return list;
	    
	    Arrays.sort(nums); //对数组进行排序
	    for(int i=1;i<=nums.length;i++){
	    	subsetsWithDup_1(nums, 0, nums.length-1, i, list,subList);
	    } 
	    list.add(new ArrayList<Integer>()); //添加一个空的数组
	    return list;
    }
    
    public static void subsetsWithDup_1(int[] nums, int low, int high, int length, List<List<Integer>> list, List<Integer> subList){
		if(length == 0){
			boolean flag = false;
		 /*	for(int i=0;i<list.size();i++){
				if(list.get(i).size() == subList.size() && list.get(i).equals(subList)){  //判断某个组合是否已经存在
					flag = true;
					break;
				}
			}*/
			if(list.contains(subList))
				flag = true;
			if(!flag){   //如果不存在，添加进去
				List<Integer> subList_1 = new ArrayList<Integer>();
				for(int i=0;i<subList.size();i++)
					subList_1.add(subList.get(i));
				list.add(subList_1);
				flag = false;
				return ;
			}
			else{  //存在的话，直接返回
				flag = false;
				return ;
			}
		}
		
		if(low == high+1)
			return ;
		
		subsetsWithDup_1(nums,low+1,high, length, list,subList); //不添加nums[low]
		
		subList.add(nums[low]);
		subsetsWithDup_1(nums,low+1,high, length-1, list,subList); //添加nums[low]
		subList.remove(subList.size()-1);
		
	}
}
