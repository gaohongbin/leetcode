public class Solution {
   public static void quickSort(int[] key,int[] value,int low,int high){ //写个快排根据value，对key排序
		if(low>=high)
			return ;
		
		int l=low;
		int h=high;
		int flagValue=value[low];
		int flagKey=key[low];
		
		while(l<h){
			while(l<h){
				if(value[h]>flagValue){
					value[l]=value[h];
					key[l]=key[h];
					break;
				}
				h--;
			}
			while(l<h){
				if(value[l]<flagValue){
					value[h]=value[l];
					key[h]=key[l];
					break;
				}
				l++;
			}
		}
		value[l]=flagValue;
		key[l]=flagKey;
		quickSort(key,value,low,l-1);
        quickSort(key,value,l+1,high);		
	}
	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> list=new ArrayList<Integer>();
		int len = nums.length;
		if(len==0 || k==0)
			return list;
	        
		int i=0;
		Map<Integer,Integer> map=new HashMap<Integer, Integer>(); //将原数组
		
			for(i=0;i<len;i++){
				if(map.containsKey(nums[i]))
					map.put(nums[i], map.get(nums[i])+1);
				else
					map.put(nums[i], 1);
			}
			
			int[] key = new int[map.size()]; //保存数组里的数
			int[] value=new int[map.size()]; //相应的key出现的次数
			
			Iterator iter = map.entrySet().iterator();//对hashmap进行遍历
			i=0;
			while(iter.hasNext()){
				Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)iter.next();
				key[i]=entry.getKey();
				value[i]=entry.getValue();
				i++;
			}
			quickSort(key,value,0,map.size()-1);
			for(i=0;i<k;i++){
				list.add(key[i]);
			}
			return list;
			
	    }
}
