public class Solution {
    public boolean canJump(int[] nums) {
          int length=nums.length;  
        if(length==1)  
            return true;  
        int sum=nums[0];  
        int i=0;  
          
        while(i<=sum){  
            if(i+nums[i]>sum)  
                sum=i+nums[i];  
            if(sum>=length-1)  
                return true;  
            i++;  
        }  
          
        return false;  
    }
}
