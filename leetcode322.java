/**
*题目：给一个数组coins，里面的数字代表各种硬币，amount代表总钱数，要用硬币组成总钱数。问最少需要多少硬币。
*
*思路：这道题不能用贪心，例如：{5,4,1} 13，如果用贪心，我们的结果是5,5,1,1,1一共五个硬币。但实际上应该是5,4,4三个硬币。
*所以这道题需要用动态规划。但是直接写成递归，会超时。所以用一个二位数组来表示，只需要遍历一次就可以了。
*
*/

public class Solution {
   public static int coinChange(int[] coins, int amount) {
	    if(coins == null || coins.length == 0)
	    	return -1;
	    if(coins.length ==1 && amount%coins[0] ==0)
	    	return amount/coins[0];
	    if(coins.length ==1 && amount%coins[0] !=0)
	    	return -1;
	    
	    Arrays.sort(coins); 
	    int length = coins.length;
	    for(int i=0;i<length/2;i++){  //coins变为降序
	    	int temp = coins[i];
	    	coins[i] = coins[length-i-1];
	    	coins[length-i-1] = temp;
	    }
	    
	    List<Integer> list = new ArrayList<Integer>();
	    int[] result = new int[1];
	    result[0] = amount/coins[length-1];
	    helper(coins,amount,0,result,list);
	    return result[0];
	}
	
	public static void helper(int[] coins, int amount, int pos, int[] result,List<Integer> list){
		if(amount<0 || pos>=coins.length){
			return ;
		}
		
		if(amount == 0){
			if(list.size()<result[0])
				result[0] = list.size();
			return ;
		}
		
		amount -= coins[pos];
		list.add(coins[pos]);
		helper(coins,amount,pos,result,list);
		
		amount += coins[pos];
		list.remove(list.size()-1);
		helper(coins,amount,pos+1,result,list);
		return ;
	}
	
}
