/**
 * 题目：参数为整形数组A，
 * A = [4, 3, 2, 6]
 *
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 *
 * @author: hongbin.gao
 *
 */
public class Leetcode396 {
	public static void main(String[] args){
		int[] A = {4,3,2,6};
		int result = maxRotateFunction_1(A);
		System.out.println(result);
	}
	/**
	 * 方法一：设一个因子的数组，并且将长度设为2*A.length-1,数组为0，1，2，3，0，1，2。  依次往后乘就可以了。
	 * 
	 */
	public static int maxRotateFunction_1(int[] A) {
		if(A==null || A.length == 0)
			return 0;
		
		int length = A.length;
		int[] factor = new int[length*2-1];
		for(int i=0;i<factor.length;i++){
			if(i>=length)
				factor[i] = i-length;
			else
				factor[i] = i;
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<length;i++){
			int temp = helper(A,factor,i);
			if(temp > max)
				max = temp;
		}
		return max;
	}
	
	public static int helper(int[] A, int[] factor, int start){
		int result = 0;
		for(int i=start;i<start+A.length;i++)
			result += A[i-start]*factor[i];
		
		return result;
	}
	
	/**
	 * 方法二：
	 */

	public static int maxRotateFunction_2(int[] A) {
		if(A==null || A.length<=1)
			return 0;
		int lengthOfA = A.length;
		
		int sumA = 0;  //A数组之和
		int max = 0; //最大的值，即返回结果
		int temp = 0;
		for(int i=0;i<lengthOfA;i++){
			temp += i*A[i];
			sumA += A[i];
		}
		max = temp;
		
		for(int i=lengthOfA-1;i>=1;i--){
			temp = temp + sumA - lengthOfA*A[i];
			if(temp > max)
				max = temp;
		}
		return max;
	}
}
