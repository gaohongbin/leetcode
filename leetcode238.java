public class Solution {
    public int[] productExceptSelf(int[] nums) {
          int length=nums.length;
        long sum=1;
        int numOfZero=0;
        int zeroTh=-1;
        for(int i=0;i<length;i++){
        	if(nums[i]==0){
        		numOfZero++;
        		zeroTh=i;
        	}
        	else
        	sum=sum*nums[i];
        }
        
        int[] ProductExceptSelf=new int[length];
        if(numOfZero>1){
        	return ProductExceptSelf;
        }
        
        if(numOfZero==1){
        	for(int i=0;i<length;i++){
        		if(i!=zeroTh)
        		ProductExceptSelf[i]=0;
        		else
        			ProductExceptSelf[i]=(int) sum;
        	}
        	return ProductExceptSelf;
        }
        	
        for(int i=0;i<length;i++){
        	ProductExceptSelf[i]=(int) (sum/nums[i]);
        }
        return ProductExceptSelf;
        
    }
}
