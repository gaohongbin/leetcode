import java.util.HashMap;
import java.util.Map;
/**
 * 题目：找出第一个只出现一次的字符串。
 * 思路：用HashMap来表示某个字符出现的次数，第一遍遍历完字符串后，hash表组件完成。
 * 第二次遍历字符串，当某个字符的个数为1，直接返回。
 * @author ghb
 *
 */

public class Leetcode387 {
	public static void main(String[] args){
		String s = "leetcode";
		int result = firstUniqChar(s);
		System.out.println(result);
	}
	 public static int firstUniqChar(String s) {
	    Map<Character,Integer> map = new HashMap<Character,Integer>();
	    if(s == null || s.length() == 0)
	    	return -1;
	    int lengthOfS = s.length();
	    for(int i=0;i<lengthOfS;i++){
	    	if(map.containsKey(s.charAt(i))){
	    		int number = map.get(s.charAt(i));
	    		map.put(s.charAt(i), number+1);
	    	}
	    	else{
	    		map.put(s.charAt(i), 1);
	    	}
	    }
	    
	    for(int i=0;i<lengthOfS;i++){
	    	if(map.get(s.charAt(i))==1)
	    		return i;
	    }
	    return -1;
	 }
}

