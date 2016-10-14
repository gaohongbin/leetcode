/**
 * 题目：给出一串数字，将其解码为ABC..,其中12可以表示AB，也可以表示L。求出一串数字有多少种可能的解码方式。
 * 思路：如果两位数小于26，则会分为两种情况，分为两个字母还是一个字母。
 * @author ghb
 *
 */
public class Leetcode91 {
	public static void main(String[] args){
		String s = "27";
		int result = numDecodings(s);
		System.out.println(result);
	}
	
	public static int numDecodings(String s) {
		if(s == null || s.length() ==0 || s.charAt(0) == '0')
			return 0;
		int[] result = new int[s.length()+1];
		result[0] = 1;
		result[1] = 1;
		for(int i=1;i<s.length();i++){
			if((s.charAt(i-1) =='1' && s.charAt(i)>'0') ||(s.charAt(i-1) =='2' && s.charAt(i)>'0' && s.charAt(i)<='6'))
				result[i+1] = result[i]+result[i-1];
			else if(s.charAt(i) =='0' && (s.charAt(i-1) =='1' ||s.charAt(i-1)=='2'))
				result[i+1] = result[i-1];
			else if(s.charAt(i)>'0' && (s.charAt(i-1)=='0'|| ((s.charAt(i-1)-'0')*10+s.charAt(i)-'0')>=27))
				result[i+1] = result[i];
			else
				return 0;
		}
		return result[s.length()];
    }
}

