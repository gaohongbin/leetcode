/**
* 题目：因子只包含2,3,5的数，被定义为丑数，1是第一个丑数，给定一个参数n，求第n个丑数。
*
*
*
*
*/


public class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumber = new int[n];
		 int length = 0;  //length表示uglyNumber的长度
		 
		 int point2 = 0;
		 int point3 = 0;
		 int point5 = 0;
		 uglyNumber[0] = 1;  //设置第一个丑数
		 length++;
		 
		 int temp =1;
		 while(length<n){
			 while(uglyNumber[point2]*2<=uglyNumber[length-1]){
				 point2++;
			 }
			 temp = uglyNumber[point2]*2;
			 
			 while(uglyNumber[point3]*3<=uglyNumber[length-1]){
				 point3++;
			 }
			 if(uglyNumber[point3]*3<temp)
				 temp = uglyNumber[point3]*3;
			 
			 while(uglyNumber[point5]*5<=uglyNumber[length-1])
				 point5++;
			 
			 if(uglyNumber[point5]*5<temp)
				 temp = uglyNumber[point5]*5;
			 
			 uglyNumber[length] = temp;
			 length++;
		 }
		 return uglyNumber[n-1];
    }
}
