public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> list=new ArrayList<List<Integer>>();
	
	if(nums==null || nums.length<3)
		return list;
	
	quickSort(nums,0,nums.length-1);  //先将数组进行排序
		int length=nums.length;
		int first=0;  //设置三个指针，first，two，three，并进行初始化。
		int two=first+1;
		int three=length-1;
		
		while(first<length-2){  //两层for循环中的第一层。
			two=first+1;
			three=length-1;
			while(two<three){ //两层for循环中的第二层。
				if(nums[two]+nums[three]>0-(nums[first]) && two<three){
					three--;
				}
				if(nums[two]+nums[three]<0-nums[first] && two<three){
					two++;
				}
				if(nums[two]+nums[three]==0-nums[first] && two<three){
					List<Integer> listSum=new ArrayList<Integer>();
					listSum.add(nums[first]);
					listSum.add(nums[two]);
					listSum.add(nums[three]);
					list.add(listSum);
				
				two++;
				while(two<three){
					if(nums[two-1]==nums[two]) //如果两个数相同，指针向前
						two++;
				    if(nums[two-1]!=nums[two]) //两个数不同
						break;
				}
			  }
			}
			first++;
			while( first<length-2 && nums[first-1]==nums[first] )
				first++;
			
		}
		return list;
	
    }

	public void quickSort(int[] nums,int low,int high){  //自己写的排序算法。
		if(low>=high || nums==null)
			return ;
		
		int length=nums.length;
		int mid=nums[low];
		int i=low,j=high;
		while(i<j){
			while(nums[j]>mid && j>i)
				j--;
			nums[i]=nums[j];
			while(nums[i]<=mid && i<j)
				i++;
			nums[j]=nums[i];
		}
		nums[j]=mid;
		quickSort(nums,low,j-1);
		quickSort(nums,j+1,high);
	}
}
