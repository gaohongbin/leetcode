public class NumArray {

     public int[] sum;
	 public NumArray(int[] nums) {
	       int length=nums.length;
	       if(length==0)
	       return ;
	       
	       sum=new int[length];
	       sum[0]=nums[0];
	       for(int i=1;i<length;i++)
	    	   sum[i]=sum[i-1]+nums[i];
	    }

	    public int sumRange(int i, int j) {
	        if(i==0)
	           return sum[j];
	    	else
	    		return sum[j]-sum[i-1];
	    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
