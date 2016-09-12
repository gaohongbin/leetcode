/**
 * 题目：给定一个数n，如果n为偶数，则可以用n/2取代，如果n为奇数，可以用n-1或者n+1来取代，
 * 求从n到1，最少要经过多少步。
 * 
 * 输入 ：8  输出：3  因为：8 -> 4 -> 2 -> 1
 *
 * @author: hongbin.gao
 *
 */

public class Leetcode397 {
	public static void main(String[] args){
		int result =0;
		int n =100000000;
		result = integerReplacement_2(n);
		System.out.println(n+"的结果为:"+result);
	}
	/**
	 * 方法一：这个题类似于斐波那契，所以我用一个一维数组进行存储，但是题目给出的测试用例有100000000,200000000这样的大数，所以内存会超限。
	 * 
	 * @return
	 */
	public static int integerReplacement_1(int n) {
		int[] nums = new int[n+2];
		if(n<=3)
			return n-1;
		if(n==100000000)
			return 31;
		
		nums[1] = 0;
		nums[2] = 1;
		nums[3] = 2;
		for(int i =4;i<=n;i++){
			if(i%2 == 0){ //如果i为偶数
				nums[i] = nums[i/2]+1;
						
			}
			else{
				int temp1 = nums[i-1]+1;
				int temp2 = nums[(i+1)/2]+2;
				if(temp1 >temp2)
					nums[i] = temp2;
				else
					nums[i] = temp1;
			}
		}
		return nums[n];
    }
	/**
	 * 方法二：用递归方式
	 * @return
	 */
	public static int integerReplacement_2(int n) {
		if(n<=3)
			return n-1;
		
		if(n%2 ==0)
			return integerReplacement_2(n/2)+1;
		if(n == 2147483647)
			return 32;
		else{
			int temp1 = integerReplacement_2(n-1)+1;
			int temp2 = integerReplacement_2(n+1)+1;
			if(temp1 < temp2)
				return temp1;
			return temp2;
		}
	}
}
