public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length=nums.length;
	    Map<Integer,Integer> map= new HashMap<Integer,Integer>();
	    //twoSum用来存储两个数的位置
	    int[] twoSum=new int[2];
	    //把数组放入hash表
	    for(int i=0;i<length;i++){
	    	map.put(nums[i], i);
	    }
	    
	    for(int i=0;i<length;i++){
	    	if(map.get(target-nums[i])!=null && map.get(target-nums[i])!=i){
	    		twoSum[0]=i;
	    		twoSum[1]=map.get(target-nums[i]);
	    		return twoSum;
	    	}
	    }
		return twoSum;
    }
}
