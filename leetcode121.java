public class Solution {
    public int maxProfit(int[] prices) {
          int length=prices.length;
	        if(prices==null || length<2)
	        	return 0;
	        
	        int price=prices[0];
	        int maxProfit=0;
	        for(int i=0;i<length;i++){
	        	if(prices[i]-price>maxProfit)
	        		maxProfit=prices[i]-price;
	        	if(prices[i]<price)
	        		price=prices[i];	
	        }
	        return maxProfit;
    }
}
