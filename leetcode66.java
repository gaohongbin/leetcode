
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1;  //carry表示进位
        int length=digits.length;  //length表示数组长度
        int i=0;
        int k=0;
        for(i=length-1;i>=0;i--){
        	k=(digits[i]+carry)%10;
            carry=(digits[i]+carry)/10;
            digits[i]=k;
        }
        if(carry>0){
            int[] digits2=new int[length+1];
            for(i=length-1;i>=0;i--){
                digits2[i+1]=digits[i];
            }
            digits2[0]=carry;
            return digits2;
        }
        return digits;
    }
}
