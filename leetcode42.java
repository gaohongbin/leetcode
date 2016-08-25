public class Solution {
    public int trap(int[] height) {
             /**
	         * 思路：在数组中，先找出最大的数，然后从数组的两端往最大的数靠拢，例如1204吧，从左往右，1<2,就把标记从1转到2，2>0,说明可储水为2，将2加入到结果中，
	         * 再往前走，2<3,达到最大值，结束，则结果为2
	         */
		if(height.length<=2)
			return 0;
		
		int result = height[0]; //result先用来找最大数，后用来返回结果
		int num = 0; //num用来表示，数组第几个数是最大的
		int length = height.length;
		
		
		
		for(int i = 0; i<length; i++){
			if(height[i]>result){
				result = height[i];
				num = i;
			}
		}
		
		result = 0;
		int index = height[0];
		for(int i=1;i<=num;i++){
			if(index < height[i])
				index = height[i];
			else
				result += (index - height[i]);
		}
		
		index = height[length-1];
		for(int i = length-2; i>=num;i--){
			if(index < height[i])
				index = height[i];
			else
				result += (index-height[i]);
		}
		
		return result;
    }
}
