/**
* 题目：输入的参数为整数n，返回类型为int， 从1-n中选出一个数m，猜出这个被选中的数m，每猜错一次需缴纳相同数字的金钱，并给出提示所猜的数*       字与m的关系，求猜出m时最少需要多少钱才可以。
*
* 思路：动态规划，加入第一次猜 k，则剩下的在 1--k-1 和k+1 -- n之间选择，求出较大的一个。
*
*/
public class Leetcode375 {
	public static void main(String[] args){
		int n = 7;
		int result = getMoneyAmount(n);
		System.out.println(result);
	}
	
	public static int getMoneyAmount(int n) {
        if(n==0)
        	return 0;
        
        int[][] result = new int[n+1][n+1];
        helper(result,1,n);
        return result[1][n];
    }
	
	public static int helper(int[][] result, int start, int end){
		if(end<=start)
			return 0;
		if(result[start][end] !=0)
			return result[start][end];
		
		int temp = Integer.MAX_VALUE;
		for(int i=start;i<=end;i++){
			temp = Math.min(temp,i+Math.max(helper(result,start,i-1),helper(result,i+1,end)));
		}
		result[start][end] = temp;
		return result[start][end];
	}
}

