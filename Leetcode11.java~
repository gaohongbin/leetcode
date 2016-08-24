/**
 * 题目：给出一个非负整数数组，数组中的数代表一个栏杆，寻找两个栏杆和x轴形成一个水池，找出能装水最多的两个栏杆。
 * 假如给出的例子是height = {1，2，3，4，5，6，7，8，9}，则height[4]=5,height[8]=9,则形成的水池是(9-5)*5=20
 *
 * @author hongbin.gao
 * 
 * 思路：先用两个指针，一个low一个hight，一个指向数组开头，一个指向数组结尾，则我们要找的两个栏杆肯定在这两个指针之间，当height[low]<height[high],
 * 则low++，因为如果high--的话，装的水肯定不会比现在多。如果height[low]>height[high],则high--。如果height[low]==height[high]，则low++且high--
 * 用result来记录过程中最大的装水量返回即可。
 */

public class Leetcode11 {
	
	 public static int maxArea(int[] height) {
	       if(height == null)
	    	   return 0;
	       
	       int length = height.length;
	       if(length < 1)
	    	   return 0;
	       
	       int low = 0;
	       int high = length-1;
	       int result = 0;
	       while(low<high){
	    	   if(height[low]<height[high] && height[low]*(high-low)>result)
	    		   result = height[low]*(high-low);
	    	   else if(height[low]>=height[high] && height[high]*(high-low)>result)
	    		   result = height[high]*(high-low);
	    	   
	    	   if(height[low]<height[high])
	    		   low++;
	    	   else if(height[low]>height[high])
	    		   high--;
	    	   else{
	    		   low++;
	    		   high--;
	    	   }
	       }
	       return result;
	    }
	 
	 public static void main(String[] args){
		int[] height = {1,2,3,4,5,6,7,8,9};
		int result = maxArea(height);
		System.out.println(result);
	 }                      
}

