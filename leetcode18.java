/**
*
* 思路：和 3 sun的思路类似，只是多加了一层循环而已。
*
*/


public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
	        List<List<Integer>> list= new ArrayList<List<Integer>>();
	        if(nums==null || nums.length<4)
	        	return list;
	        
	        quickSort(nums,0,nums.length-1);
	        int length=nums.length;
	        int first=0;
	        int two=1;
	        int three=2;
	        int four=3;
	        while(first<length-3){
	        	two=first+1;
	        	while(two<length-2){
	        		three=two+1;
	        		four=length-1;
	        		while(three<four){
	        			if(nums[three]+nums[four]>target-nums[first]-nums[two])
	        				four--;
	        			if(nums[three]+nums[four]<target-nums[first]-nums[two])
	        				three++;
	        			if(nums[three]+nums[four]==target-nums[first]-nums[two] && three<four){
	        				List<Integer> listThree=new ArrayList<Integer>();
	        				listThree.add(nums[first]);
	        				listThree.add(nums[two]);
	        				listThree.add(nums[three]);
	        				listThree.add(nums[four]);
	        				list.add(listThree);
	        				three++;
	        				while(three<four){
	        					if(nums[three]==nums[three-1])
		        					three++;
	        					if(nums[three]!=nums[three-1])
	        						break;
	        				}
	        				
	        			}
	        				
	        		}
	        		two++;
	    			while( two<length-2 && nums[two-1]==nums[two] )
	    				two++;
	        	}
	        	first++;
				while( first<length-3 && nums[first-1]==nums[first] )
					first++;
	        	
	        }
	        return list;
	    }
	 
	 public static void quickSort(int[] nums,int low,int high){
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
