/**
 * 题目：给一个参数n，我心目中的数字在1-n之间，你每猜一个数字，我会和我心目中的数字进行比较，当你给出的数字大于我心目中的数字时，我返回-1，
 * 如果小于，返回结果1，如果相等 ，返回0.
 * 
 * 思路：这个题其实就是很简单的二分查找问题，只是我们经常写的二分公式为(low+high)/2，但这个式子有一个缺点就是，当(low+high)>Integer.MAX_VALUE时，会报错。
 * 所以改动式子为 low+(high-low)/2; 
 *
 * @author: hongbin.gao
 *
 */
public class Leetcode374 {
	public static void main(String[] args){
		int n=10;
		int result = guessNumber(n);
		System.out.print(result);
	}
	
	public static int guessNumber(int n) {
		int low = 1, high = n;
		while(low<high){
			//求mid，以前经常用(low+high)/2,但是当high为Integer.MAX_VALUE的时候，这样low+high就会超出限制。
			int mid = low + (high-low)/2;
			int temp = guess(mid);
			if(temp == 0)
				return mid;
			if(temp == 1)
				low = mid+1;
			else
				high = mid-1;
		}
		return low;
    }
	
	public static int guess(int n){ 
		int result = 9;
		if(n == result)
			return 0;
		if(n>result)
			return -1;
		else
			return 1;
	}
}
