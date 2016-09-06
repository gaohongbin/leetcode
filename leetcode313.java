/**
 * 寻找第n个丑数，这个在剑指Offer里面有，我不多做解读，直接写代码
 * @author ghb
 *
 */
public class Leetcode313 {
    public static void main(String[] args){
    	int n = 12;
    	int[] primes = {1,2, 7, 13, 19};
    	int result = nthSuperUglyNumber(n,primes);
    	System.out.println(result);
    }
	
    public static int nthSuperUglyNumber(int n, int[] primes) {
    	int length = primes.length;
    	int uglyNumberLength = 0;
    	
    	int[] uglyNumber = new int[n];  //用来存储丑数
    	int[] point = new int[length];  //每一个因子对应的指针
    	for(int i=0;i<length;i++)
    		point[i]=0;   //为指针赋初值，均赋为0
    	
    	uglyNumber[0]=1;
		uglyNumberLength++;
    	
    	int temp =0;
    	boolean flag = false;  //false表示temp还没被换过
    	while(uglyNumberLength<n){
	    	for(int i=0;i<point.length;i++){
	    		while(point[i]<uglyNumberLength && uglyNumber[point[i]]*primes[i]<=uglyNumber[uglyNumberLength-1]){
	    			point[i]++;
	    		}
	    		if(!flag && point[i]<uglyNumberLength && uglyNumber[point[i]]*primes[i]>uglyNumber[uglyNumberLength-1]){
	    			temp = uglyNumber[point[i]]*primes[i];
	    			flag = true;
	    		}
	    		else if(flag && point[i]<uglyNumberLength && uglyNumber[point[i]]*primes[i]<temp){
	    			temp = uglyNumber[point[i]]*primes[i];
	    		}
	    		
	    		if(i==point.length-1){   //循环的最后一个变换标志
    				flag = false;
    				uglyNumber[uglyNumberLength] = temp;
    				uglyNumberLength++;
    			}
	    	}
    	}
    	return uglyNumber[n-1];
    }

}

