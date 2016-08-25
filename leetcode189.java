public class Solution {
    public void rotate(int[] nums, int k) {
         int length=nums.length;
        if(length==0)
        	return ;
        k=k%length;
        int first=0,last=0;  //反转数组的两个指针
        int temp=0;
        
        	first=0;
        	last=length-k-1;
        	while(first<last){
        		temp=nums[first];
        		nums[first]=nums[last];
        		nums[last]=temp;
        		first++;
        		last--;
        	}
        	
        	first=length-k;
        	last=length-1;
        	while(first<last){
        		temp=nums[first];
        		nums[first]=nums[last];
        		nums[last]=temp;
        		first++;
        		last--;
        	}
        	
        	first=0;
        	last=length-1;
        	while(first<last){
        		temp=nums[first];
        		nums[first]=nums[last];
        		nums[last]=temp;
        		first++;
        		last--;
        	}
    }
}
