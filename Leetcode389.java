import java.util.HashMap;
import java.util.Map;

/**
 * 题目：两个字符串s和t，t是s字符串的乱序组合，但是会比s字符串多出一个字符。请找出这个字符。
 * @author ghb
 * 思路:用HashMap来保存s中每个字符出现的个数，然后再遍历t字符串，当t中出现的某个字符，在hash表中有的时候，个数减1（当然个数本身只剩1的话，
 * 直接remove），当不包含某个字符时，直接返回。
 */


public class Leetcode389 {
	public static void main(String[] args){
		String s = "abcd";
		String t = "abcde";
		char result = findTheDifference(s,t);
		
	    System.out.println("'"+result+"' is the letter that was added.");
	}
	
	 public static char findTheDifference(String s, String t) {
		 Map<Character,Integer> mapOfS = new HashMap<Character,Integer>();
		 int lengthOfS = s.length();
		 int lengthOfT = t.length();
		 
		 for(int i=0;i<lengthOfS;i++){
			 if(mapOfS.containsKey(s.charAt(i))){
				 int number = mapOfS.get(s.charAt(i));
				 mapOfS.put(s.charAt(i), number+1);
			 }
			 else{
				 mapOfS.put(s.charAt(i), 1);
			 }
		 }
		 
		 for(int i=0;i<lengthOfT;i++){
			 if(mapOfS.containsKey(t.charAt(i))){
				 int number = mapOfS.get(t.charAt(i));
				 if(number == 1)
					 mapOfS.remove(t.charAt(i));
				 else
					 mapOfS.put(t.charAt(i), number-1);
			 }
			 else
				 return t.charAt(i);
		 }
		 return ' ';
	        
	 }
	 

}

