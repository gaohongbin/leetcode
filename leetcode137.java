public class Solution {
    public int singleNumber(int[] nums) {
        int one=0,two=0,three=0;
        for(int i=0;i<nums.length;i++){
            two=two|(nums[i]&one); //在one中出现过，&操作就是表明出现偶数次
            one=nums[i]^one;  //异或只保存了1的奇数次出现的位
            three=~(one&two);     //three将出现1三次的位保存为0，其他位保存为1
            one=one&three;       //将one和two中同时保存的1位变为0，实现模3的功能
            two=two&three;
        }
        return one;
    }
}
