public class Solution {
    public int jump(int[] nums) {
            int length=nums.length;
	     if(length==1)
	    	 return 0;
	     
	     int first=nums[0];  //first代表第一轮能到达的最远处
	     int sum=nums[0];  //sum代表下一轮能到达的最远处
	     int numOfJum=1;
	     int i=1;
	     while(i<=first){
            	if(i+nums[i]>sum)
            		sum=i+nums[i];
            	if(sum>=length-1){
            		if(i<=first && first<length-1)
            			return ++numOfJum;
            		else
            			return numOfJum;
            	}
            	else if(i==first && first<length-1 ){
            		first=sum;
            		numOfJum++;
            	}
            	
            	i++;
	     }
	     return numOfJum;
	    }
}
