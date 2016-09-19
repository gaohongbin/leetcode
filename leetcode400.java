/**
 * 题目：参数为n，寻找1，2，3，4...中第n个数。
 * 例如：n ==11 ，则返回0， 因为1，2，3，4，5，6，7，8，9，10 第11个数为10中的0.
 *
 * @author: hongbin.gao
 *
 */
public class Leetcode400 {
	public static void main(String[] args){
		int n = 9;
		System.out.println(findNthDigit(n));
	}
	
	public static int findNthDigit(int n) {
        int[] nums = {9,90,900,9000,90000,900000,9000000,90000000,900000000};
        int index = 0;  //如果所要找的数为2位，则index = 9，如果为3为，则index = 99
        int temp1 = 0; //计算n对应的数字应该在那个数字中
        int temp2 = 0; //计算n对应的数字应该在temp1的哪一位
        int j=0;
        
        int i=1;
        while(n>0){
        	if(n/nums[i-1]>=i){
        		n -= nums[i-1]*i;
        		index += nums[i-1];
        	}
        	else{
        		temp1 = index+n/i;
        		temp2 = i-n%i;
        		
        		if(temp2 == i)
        			return temp1%10;
        		
        		j=0;
        		temp1 ++;
        		while(j<temp2){
        			temp1 = temp1/10;
        			j++;
        		}
        		return temp1%10;
        	}
        	i++;
        }
        return 9;
    }

}
