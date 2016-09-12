public class Solution {
    /**
	 * 题目：判断s是不是t的字串。如果是的话，s在t中的相对位置不变，但可以不连续
	 * 
	 * 思路：两个指针pointS，pointT，分别指向字符串s和t，比较pointS对应的字符和pointT对应的字符，如果
	 * 两者相同，则pointS++，pointT++。
	 * 如果不相同，pointT++，最后循环结束后比较pointS看有没有将s遍历一遍。
	 * 
	 */
    public boolean isSubsequence(String s, String t) {
        int lengthOfS = s.length();
		int lengthOfT = t.length();
		
		int pointS = 0;
		int pointT = 0;
		
		while(pointS<lengthOfS && pointT<lengthOfT){
			char temp1 = s.charAt(pointS);
			char temp2 = t.charAt(pointT);
			
			if(temp1 == temp2){
				pointS++;
				pointT++;
			}
			else if(temp1 != temp2){
				pointT++;
			}
		}
		if(pointS == lengthOfS)
			return true;
		else 
			return false;
        
    }
}
