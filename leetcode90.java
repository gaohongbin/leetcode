
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 题目：求一个数组nums的所有组合，nums中可能有重复的数字。但是求得的组合不能有相同的组合。
 * 例如：nums = [1,2,2]. 返回的结果为：
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 * @author hongbin.gao
 *
 */
public class Leetcode90 {
	public static void main(String[] args){
	 	int[] nums = {1,2,2};
	 	List<List<Integer>> list = subsetsWithDup(nums);
	 	System.out.println(list);
	}
	/**
	 * 方法一：这种方法就是利用了剑指Offer里面的求字符组合的方法，先求出组合，最后再去掉重复的。
	 * @param nums
	 * @return
	 */
	
	/*public static List<List<Integer>> subsetsWithDup(int[] nums) {
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
*/
	/**
	 * 方法二：这个是在网上看到的，这个方法的思想：对于数组nums，我先求出以nums[0]开头的所有组合，在求出以nums[1]为开头的所有组合。
	 * nums[0]开头的组合可以看做nums[0]+{[2,2]数组的组合}
	 * nums[1]开头的组合可以看做nums[1]+{[2]数组的组合}
	 * 因为nums[1] == nums[2]所以nums[2]开头的组合包含在了nums[1]开头的组合里面了。
	 * @param nums
	 * @return
	 */
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<Integer> subList = new ArrayList<Integer>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
	    list.add(subList);
	    Arrays.sort(nums);
	    helper(nums,0,subList,list);
	    return list;
	    
	}
	
	public static void helper(int[] nums, int pos, List<Integer> subList, List<List<Integer>> list){
		if(pos == nums.length)
			return ;
		
		for(int i = pos;i<nums.length;i++){
			subList.add(nums[i]);  //先加入，和后面的remove对应，这样就能保证每次新的for循环，subList为空，就是依次以nums[0],nums[1],nums[2]为开头的组合
			List<Integer> subList_1 = new ArrayList<Integer>();
			for(int j=0;j<subList.size();j++)
				subList_1.add(subList.get(j));
			list.add(subList_1);
			helper(nums,i+1,subList,list); //对应的是上面注释里面{}里面的东西，因为传的是subList引用，所以可以实现+
			subList.remove(subList.size()-1);
			while(i<nums.length-1 && nums[i] == nums[i+1])  //因为nums[1] == nums[2]所以nums[2]开头的组合包含在了nums[1]开头的组合里面了。所以i++，指针直接往后
				i++;
		}
	}
}
