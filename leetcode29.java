/**
 * 题目：不用除法、乘法、取余实现除法。
 * 思路：将除数左移实现乘以2.  
 *
 * @author: hongbin.gao
 *
 */
public class Leetcode29 {
	public static void main(String[] args){
		int dividend = -82;  //被除数
		int divisor = 9; //除数
		
		int result = divide(dividend,  divisor);
		System.out.println(result);
	}
	
	public static int divide(int dividend, int divisor) {
		if(dividend==Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		if(divisor ==1)
			return dividend;
		if(divisor == Integer.MIN_VALUE && divisor == dividend)  //如果除数为最小整数
			return 1;
		if(divisor == Integer.MIN_VALUE)  
			return 0;
		
		boolean flagOfDividend = true;  //被除数的正负，true表示 正(+)， false表示负(-).
		boolean flagOfDivisor = true;  //除数的正负，true表示 正(+)， false表示负(-).
		boolean flowOfDividend = false;  //被除数是否为Integer.MIN_VALUE。 默认false表示不是Integer.MIN_VALUE
		
		if(dividend == Integer.MIN_VALUE){
			flagOfDividend = false;
			flowOfDividend = true;
			dividend = Integer.MAX_VALUE;
		}
		if(dividend<0){
			flagOfDividend = false;
			dividend = -dividend;
		}
		if(divisor<0){
			flagOfDivisor = false;
			divisor = -divisor;
		}
		
		int result = 0; //最后的结果
		int temp = 1;
		int divisorCopy = divisor;
		while(dividend>=divisor){
			while(divisorCopy <= dividend/2){
				temp = temp<<1;
				divisorCopy = divisorCopy<<1;
			}
			if(temp>1){
				result += temp;
				temp = 1;
				dividend -= divisorCopy;
				divisorCopy = divisor;
			}
			else {
				if(dividend>=divisor){
					result++;
					dividend -= divisor;
				}
				break;
			}
		}
		
		if(flowOfDividend == true)
			dividend ++;
		if(dividend>=divisor){
			result++;
			dividend -= divisor;
		}
		
		if(flagOfDividend ^flagOfDivisor)
			return -result;
		return result;
		
	}
}
