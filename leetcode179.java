public class Solution {
    public static String largestNumber(int[] nums) {
	     int length = nums.length;
	     
	     String result = "";
	     if(nums == null || length == 0){
	    	 return "";
	     }
	     if(length == 1)
	    	 return nums[0]+"";
	     
	     int max = 0;   
	     for(int i=0;i<length;i++){  //如果数组里全是0,则直接返回"0".
	    	 if(nums[i]>max)
	    		 max = nums[i];
	     }
	     if(max == 0)
	    	 return "0";
	     
	     for(int i=1;i<length;i++){
	    	 int temp = nums[i];
	    	 for(int j=i-1;j>=0;j--){
	    		 if(compare(temp,nums[j])){   //nums[i]>nums[j]
	    			 nums[j+1] = nums[j];  //将小于nums[i]的数后移
	    			 if(j==0){
	    				 nums[0]=temp;
	    				 break;
	    			 }
	    		 }
	    		 else{
	    			 nums[j+1] = temp;
	    			 break;
	    		 }
	    	 }
	     }
	     
	     for(int i=0;i<length;i++){
	    	 result += nums[i];
	     }
	     return result;
	     
	}
	
	/**
	 * 比较a和b的大小，按字符串进行比较，将a+b拼接成字符串，b+a拼接成字符串，比较哪个大。
	 * a>b,返回true; a<b,返回false.
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean compare(int a, int b){  
		if(a == 0)  
			return false;
		if(b==0)
			return true;
		
		String a_b = a+""+b;
		String b_a = b+""+a;
		
		int length = a_b.length();
		for(int i=0;i<length;i++){
			if(a_b.charAt(i)<b_a.charAt(i))
				return false;
			else if(a_b.charAt(i)>b_a.charAt(i))
				return true;
		}
		return false;
	}


}
