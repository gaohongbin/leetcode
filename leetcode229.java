/**
 * 题目：如果数组数组中有一个数超过三分之一，则称为主数，现在寻找数组中的所有主数。
 * @author hongbin.gao
 * 思路：原来有一道题目，主数的定义为超过二分之一的数，我们的思路是，将数组中的数两两一组（两个数不等），则最后余下的那个数可能是主数，如果题目说一定存在主数，那就不用检查了，如果不一定存在，则还需要检查一下。
 * 现在我们采用相同的思路，将三个不相等的数分为一组，则最后剩下的一个或两个可能为主数。我们再对其进行检查，找出真正的主数。进行返回。
 * 这个思路太棒了，当然以后遇到四分之一，五分之一都不是什么问题了。下面是代码。
 *
 */

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
       int num1 = 0, num2 = 0;  //num1和num2用来保存nums中的元素。
        int count1 = 0, count2 = 0;  //count1和count2分别保存num1和num2的个数。
        
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0)
        	return list;
        
        for(int i=0;i<nums.length;i++){
        	if(nums[i] == num1)
        		count1++;
        	else if(nums[i] == num2)
        		count2++;
        	else if(count1 == 0){
        		num1 = nums[i];
        		count1++;
        	}
        	else if(count2 == 0){
        		num2 = nums[i];
        		count2++;
        	}
        	else{
        		count1--;
        		count2--;
        	}
        }
        
        int check1 = 0, check2 = 0;
        for(int i=0;i<nums.length;i++){
        	if(count1 !=0 && nums[i] == num1)
        		check1++;
        	if(count2!=0 && nums[i] == num2)
        		check2++;
        }
        
        if(check1 > nums.length/3)
        	list.add(num1);
        if(check2 > nums.length/3)
        	list.add(num2);
        
        return list;
    }
}
