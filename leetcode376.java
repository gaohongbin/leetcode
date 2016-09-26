/**
 * 题目：参数为整数数组nums，找出最长的wiggle数列长度。  
 * wiggle： 例如：1,7,4,9,2,5 相邻数相减为：6,-3,5,-7,3正负数相隔出现。则原数列为wiggle。
 * 
 * 思路：根据leetcode300，我们用相似的方法，d[i]为nums数组0--i子数组包含nums[i]的最长wiggle数列长度。
 * 所以d[i]初值为1(只包含nums[i]).
 * boolean[] flag表示到现在为止，概数与wiggle前一个数的关系。
 *
 * @author: hongbin.gao
 *
 */
public class Leetcode376 {
	public static void main(String[] args){
		int[] nums = {0,0};
		int result = wiggleMaxLength(nums);
		System.out.println(result);
	}
	
	
	public static int wiggleMaxLength(int[] nums) {
        if(nums == null)
        	return 0;
        if(nums.length <=1)
        	return nums.length;
        
        int[] d = new int[nums.length];
        boolean[] flag = new boolean[nums.length];   //true表示加入wiggle的列表中，该数大于前面的那个数。false表示该数小于前面那个数
        
        d[0] = 1;
        flag[0] = false;
        int max = 1;
        for(int i=1;i<nums.length;i++){
        	d[i] = 1;
        	for(int j = 0;j<i;j++){
        		if(nums[i]>nums[j] && d[j] > 1 && !flag[j]){
        			if(d[i]< d[j]+1){
        				d[i] = d[j]+1;
        				flag[i] = !flag[j];
        				if(d[i]>max)
        					max = d[i];
        			}
        		}
        		else if(nums[i]<nums[j] && d[j] > 1 && flag[j]){
        			if(d[i]<d[j]+1){
        				d[i] = d[j]+1;
        				flag[i] = !flag[j];
        				if(d[i]>max)
        					max = d[i];
        			}
        		}
        		else if(d[j] == 1){
        			if(nums[i]<nums[j] && d[i] == 1){
        				d[i] = 2;
        				flag[i] = false;
        				if(d[i]>max)
        					max = d[i];
        			}
        			else if(nums[i]>nums[j] && d[i] == 1){
        				d[i] = 2;
        				flag[i] = true;
        				if(d[i]>max)
        					max = d[i];
        			}
        		}
        	}
        }
        return max;
    }
}
