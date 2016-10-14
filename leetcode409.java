/**
 * 题目：给一个字符串，找出可以组成的最大的回文的长度。
 * 思路：uppercase数组用来保存每个大写字母的个数。lowercase数组用来保存每个小写字母的个数。
 * flag用来表示是否存在奇数个字母。
 * @author ghb
 *
 */
public class Leetcode409 {
	public static void main(String[] args){
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		int result = longestPalindrome(s);
		System.out.println(result);
	}
	public static int longestPalindrome(String s) {
        if(s == null || s.length() ==0)
        	return 0;
        
        int length = s.length();
        int[] uppercase = new int[26];  //a：97 z:122
        int[] lowercase = new int[26];  //A：65 Z:90
        for(int i=0;i<length;i++){
        	if(s.charAt(i)>=97)
        		lowercase[s.charAt(i)-97]++;
        	if(s.charAt(i)<=90)
        		uppercase[s.charAt(i)-65]++;
        }
        
        int result =0;  //将所有偶数的相加
        int flag = 0;  //找出奇数最大的
        for(int i=0;i<26;i++){
        	if(uppercase[i]%2 ==0)
        		result += uppercase[i];
        	if(lowercase[i]%2 ==0)
        		result += lowercase[i];
        	if(uppercase[i]%2 ==1){
        		result += uppercase[i]-1;
        		flag = 1;
        	}
        	if(lowercase[i]%2 ==1){
        		result += lowercase[i]-1;
        		flag = 1;
        	}
        }
        return result+flag;
	}
}

