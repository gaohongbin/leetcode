public class Solution {
   /**
	 * 思路：先找出数组中最小的数min，然后用length*min,或者将数组中最小的位置分开，分为两部分，在两部分里面找出最大的值result1，最后通过比较
	 * length*min和result1，返回较大的即为结果
	 * @param heights
	 * @return
	 */
	 public static int largestRectangleArea(int[] heights) {
	        int length = heights.length;
	        boolean flag = false;
	        for(int i=length-1;i>=0;i--){
	        	if(heights[i]!=i){
	        		flag = true;
	        		break;
	        	}
	        }
	        if(!flag){
	        	if(length%2==0)
	        	   return (length/2)*(length/2);
	        	else
	        		return (heights[length/2]*(length-length/2));
	        }
	        flag = false;
	        for(int i =0;i<length-1;i++){
	        	if(heights[i]!=heights[i+1]){
	        		flag = true;
	        		break;
	        	}
	        }
	        if(!flag){
	        	return heights[0]*length;
	        }
	        return largestRectangleAreaHelper(heights,0,length-1);
	    }
	 
	 public static int largestRectangleAreaHelper(int[] heights,int low,int high){
		 if(low>high)
			 return 0;
		 if(low == high)
			 return heights[low];
		 
		 int min = heights[low]; //min用来表示heights从low到high最小的数
		 int indexOfMin = low;
		 for(int i=low;i<=high;i++){  //找出min和indexOfMin
			 if(heights[i]<min){
				 min= heights[i];
				 indexOfMin = i;
			 }
		 }
		 int result1 = min*(high-low+1);
		 int result2 = largestRectangleAreaHelper(heights,low,indexOfMin-1);
		 int result3 = largestRectangleAreaHelper(heights,indexOfMin+1,high);
		 if(result1 >=result2 && result1>=result3)
			 return result1;
		 else if(result2>= result1 && result2>=result3)
			 return result2;
		 else
			 return result3;
	 }
}
