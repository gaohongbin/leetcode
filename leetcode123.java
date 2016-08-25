public class Solution {
    public int maxProfit(int[] prices) {
          if(prices==null || prices.length<2)
	        	return 0;
	        
//	        int length=prices.length;
//	        int max=0;
//	        int second=0;
//	        int maxProfit=0;
//	        for(int i=1;i<length;i++){
//	        	if(prices[i]-prices[i-1]>=0)
//	        		maxProfit+=prices[i]-prices[i-1];
//	        	if(prices[i]-prices[i-1]<0){
//	        		 if(max<maxProfit){
//	     	        	second=max;
//	     	        	max=maxProfit;
//	     	        }
//	        		 else if(second<maxProfit)
//	        			 second=maxProfit;
//	        		maxProfit=0;
//	        	}
//	        }
//	        if(max<maxProfit){
//	        	second=max;
//	        	max=maxProfit;
//	        }
//	        else if(second<maxProfit){
//	        	second=maxProfit;
//	        }
//	        return max+second;
	        int length=prices.length;
	        int[] firstProfit=new int[length];
	        int[] secondProfit=new int[length];
	        
	        int min=prices[0];
	        for(int i=1;i<length;i++){
	        	min=Math.min(min, prices[i]);
	        	firstProfit[i]=Math.max(firstProfit[i-1], prices[i]-min);
	        }
	        
	        int max=prices[length-1];
	        for(int i=length-2;i>=0;i--){
	        	max=Math.max(max, prices[i]);
	        	secondProfit[i]=Math.max(secondProfit[i+1],max-prices[i]);
	        }
	        
	        int maxProfit=0;
	        for(int i=0;i<length;i++){
	        	maxProfit=Math.max(maxProfit, firstProfit[i]+secondProfit[i]);
	        }
	        return maxProfit;
	        
    }
}
