/**
 * 题目：两个参数n，k， n表示对1,2 ... n个数字进行操作。 k表示返回第k大的数字
 * 例子： n=3, k=2
 * 则排列的顺序为：123,132,213,231,312,321.
 * k =2. 则返回第二个数为132.
 * 
 * 思路：刚开始想到的思路是将所有排列按序存储，最后从里面取出需要的结果。但是觉得这种方法可能会比较慢。
 * 最后从123中寻找规律，1开头的有两种情况。2开头的有两种情况。3开头的有两种情况。 因为他们后面有两个数字进行 全排列。
 * 所以当 (k-1)/(后面的数字的个数的阶乘), 为什么要用k-1 因为我们是从1开始数的，比如123为第一种情况。132为第二种情况。如果k=2.第一个数字为1.没有变。
 * 然后后移(k-1)/(后面的数字的个数的阶乘)个字符。将该字符加入。
 * 改变k，k变为 k = k - number*sum;  其中 number = (k-1)/sum;  sum为后面的数字的个数的阶乘;
 * 
 * 当k == sum时，特殊处理。
 *
 * @author: hongbin.gao
 *
 */
public class Leetcode60 {
	public static void main(String[] args){
		int n = 3;
		int k = 6;
		String result =getPermutation(n, k);
		System.out.println(result);
	}
	
	public static String getPermutation(int n, int k) {
		char[] nums = new char[n];
		for(int i=1;i<=n;i++)
			nums[i-1] = (char)(i+'0');
		
		StringBuffer strBuf = new StringBuffer();
		int  pos  = 0;
		helper(nums,pos,k,strBuf);
		return strBuf.toString();
    }
	
	public static void helper(char[] nums, int pos, int k, StringBuffer strBuf){
		if(k==0)
			return ;
		int length = nums.length-pos-1;
		int sum = factorial(length);
		
		if(sum>k){
			strBuf.append(nums[pos]);
			helper(nums,pos+1,k,strBuf);
		}
		else if(sum<k){
			int number = (k-1)/sum;
			int temp = number;
			char c = nums[pos+temp];
			while(pos+temp>pos){
				nums[pos+temp] = nums[pos+temp-1];
				temp--;
			}
			nums[pos] = c;
			strBuf.append(nums[pos]);
			k = k - number*sum;
			helper(nums,pos+1,k,strBuf);
		}
		else if(sum == k){
			strBuf.append(nums[pos]);
			for(int i=nums.length-1;i>pos;i--){
				strBuf.append(nums[i]);
			}
			return ;
		}
	}
	
	public static int factorial(int n){    //求n的阶乘
		if(n<0)  //当n小于0时，返回-1，表示参数有问题
			return -1;
		
		if(n<=1)
			return 1;
		
		int sum = 1;
		while(n>=1){
			sum *= n;
			n--;
		}
		return sum;
	}
}
