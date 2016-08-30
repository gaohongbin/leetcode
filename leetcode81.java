/**
* 什么都不管，直接遍历，结果时间还是最快的。
*/

public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
         return false;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target)
             return true;
        }
        return false;
    }
}
