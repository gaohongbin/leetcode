import java.util.ArrayList;
import java.util.List;


public class Leetcode78 {
	public static void main(String[] args){
		int[] nums = {1,2,3};
		List<List<Integer>> list = subsets(nums);
		System.out.println(list);
	}
	
    public static List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	List<Integer> list_1 = new ArrayList<Integer>();
    	
     	if(nums == null || nums.length == 0)
    		return list;
    	
    	for(int i=1;i<=nums.length;i++){
    		subsets_1(nums, 0, nums.length-1, i ,list, list_1);
    	}
    	list.add(new ArrayList<Integer>());
    	return list;
    }
    
    /**
     * 
     * @param nums 数组
     * @param low 数组的起始位置
     * @param high 数组的结束位置
     * @param length 要寻找的子集的长度
     * @param list 最后的结果
     */
    public static void subsets_1(int[] nums, int low, int high, int length,List<List<Integer>> list, List<Integer> list_1){
    	
    	if(length == 0){ //当一个子集完成后
    		List<Integer> Nlist = new ArrayList<Integer>();
     		for(int i=0;i<list_1.size();i++)
     			Nlist.add(list_1.get(i));
     		list.add(Nlist);
    		return ;
    	}
    	
    	if(high-low+1 < length)
    		return ;
    	
    	subsets_1(nums, low+1, high, length ,list, list_1); //不添加low位置上的元素
    	
    	list_1.add(nums[low]);
    	subsets_1(nums, low+1, high, length-1 ,list, list_1); //添加low位置上的元素
    	list_1.remove(list_1.size()-1);	
    }
}

