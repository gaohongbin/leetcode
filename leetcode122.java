public class Solution {
    public int maxProfit(int[] prices) {
            int length=prices.length;
	        if(prices==null || length<2)
	        	return 0;
	        
	        int maxProfit=0;
	        int price=prices[0];
	        int lastSellPrice=prices[0];
	        for(int i=1;i<length;i++){
	        	if(prices[i]>price){
	        	    if(prices[i]>lastSellPrice)	
	        	    	lastSellPrice=prices[i];
	        	    if(prices[i]<lastSellPrice){
	        	    	maxProfit+=lastSellPrice-price;
        	    		price=prices[i];
	        	    	lastSellPrice=price;
	        	    }
	        	}
	        	if(prices[i]<=price){
	        		if(lastSellPrice>price){
	        			maxProfit+=lastSellPrice-price;
	        	    	price=prices[i];
	        	    	lastSellPrice=price;
	        		}
	        		if(lastSellPrice==price){
	        			price=prices[i];
	        			lastSellPrice=price;
	        		}	
	        	}	
	        }
	        maxProfit+=lastSellPrice-price;
	        return maxProfit;
    }
}
