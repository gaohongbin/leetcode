public class Leetcode279 {
	public static void main(String[] args){
		int n = 9375;
		int result = numSquares(n);
		System.out.println(result);
	}
	/**
	 * 方法一：类似于排列组合，不多赘述，就是一个动态规划。递归，结果超时。
	 * 
	 * 创建人:hongbin.gao
	 */
	public static int numSquares_1(int n) {
		int sqrt = (int)Math.sqrt(n);
		
		int[] square = new int[sqrt+1];  //square保存0-sqrt的平方
		for(int i=0;i<=sqrt;i++){
			square[i] = i*i;
		}
		
		int[] result = new int[1];
		result[0] = n;
		List<Integer> list = new ArrayList<Integer>();
		
		helper(square, list, n, result);
		return result[0];
    }
	
	public static void helper(int[] square, List<Integer> list, int n, int[] result){
		if(n == 0){
			if(list.size()<result[0])
				result[0] = list.size();
			return ;
		}
		
		if(n < 0)
			return ;
		
		if(list.size()>=result[0])
			return ;
		
		int sqrt = (int)Math.sqrt(n);
		for(int i=sqrt;i>=1;i--){
			list.add(square[i]);
			n = n - square[i];
			helper(square,list,n,result);
			
			n = n + square[i];
			list.remove(list.size()-1);
		}
		return ;
	}
	
	/**
	 * 方法二:用空间换时间，建表。
	 */
	
	public static int numSquares(int n) {
		int[] nums = new int[n+1];
		int sqrt = (int)Math.sqrt(n);
		
		for(int i=1;i<=sqrt;i++){  //给能开方的数直接赋值为1
			nums[i*i] = 1;
		}
		
		for(int i=2;i<=n;i++){
			if(nums[i] !=0)
				continue;
			int max = (int)Math.sqrt(i);  //i最大的开方数为多少
			int min = i;  //保存最少需要多少
			while(max >=1){
				if(1+ nums[i-max*max]<min)
					min = 1+nums[i-max*max];
				max--;
			}
			nums[i] = min;
		}
		return nums[n];
	}
}
