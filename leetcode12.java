/**
* 这个我当时看了半天，我也不会，直接百度，百度百科里面就有。我就直接抄了。因为弄清楚罗马字符好麻烦，真的...
*/

public class Solution {
    public String intToRoman(int num) {
       String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
