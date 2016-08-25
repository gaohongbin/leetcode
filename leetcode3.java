/**
* 思路：
*
* 题目中给出的字符串都可以用ASCII码来表示，所以我们用一个数组exits[256]来表示字符串中哪些字符出现过。position[256]相应的用来表示字母的位置。max用来记录到上个* 字符串位置，最长的字符串的长度。start用来记录现在正在遍历的子串的起始位置。
*
* 当遍历到一个字母，这个字母在exits中出现过，那么现在查找的这个子串就停止，计算长度length，如果length>max， 则max=length；
*
* 如果length<=max，则不做处理。
*
* 如果字符串找到的字符在exits[i]中出现过，则下次开始遍历的子串位置从position[i]+1的位置开始。
*
* 当然这个题可以不用exits数组，直接用一个position数组就可以，刚开始吧position数组初始化为-1，当然不可能哪个字符的位置在-1，如果position中为-1，则代表相应的* 字符没有出现过。如果不为-1，则代表相应字符出现过。
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length=s.length();
		if(length==0)
			return 0;
		int[] exits=new int[256];
		int[] position=new int[256];
		int start=0;
		int max=0;
		for(int i=0;i<256;i++){
			exits[i]=0;
			position[i]=-1;
		}
	        for(int i=0;i<length;i++){
	        	if(exits[(int)s.charAt(i)]==0){
	        		exits[(int)s.charAt(i)]=1;
	        		position[(int)s.charAt(i)]=i;
	        	}
	        	else{
	        		max=max>(i-start)?max:i-start;
	        		for(int j=0;j<256;j++){
	        			exits[j]=0;
	        		}
	        		start=position[(int)s.charAt(i)]+1;
	        		position[(int)s.charAt(i)]=i;
	        		i=start-1;
	        	}
	        	if(i==length-1){
	        		max=max>(i-start+1)?max:i-start+1;
	        	}
	        }
	        return max;
    }
}
