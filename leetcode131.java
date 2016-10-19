import java.util.ArrayList;
import java.util.List;
/**
 * 题目：输入参数为一个字符串s，输出为所有可能的回文字符串的列表。
 * 例如：输入字符串s = "aab",  返回 [["aa","b"],["a","a","b"]]
 * 
 * 思路：回溯
 *
 * @author: hongbin.gao
 *
 */
public class Leetcode131 {
	public static void main(String[] args){
		String s = "aab";
		List<List<String>> list = partition(s);
		System.out.println(list);
	}
	
	public static List<List<String>> partition(String s) {
        int pos = 0;
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> subList = new ArrayList<String>();
        if(null == s || s.length() ==0)
        	return result;
        
        helper(s,pos,subList,result);
        return result;
    }
	
	public static void helper(String s, int pos, List<String> subList, List<List<String>> list){
		if(pos >= s.length()){
			List<String> subList_1 = new ArrayList<String>(subList);
			list.add(subList_1);
			return ;
		}
		
		int length = s.length();
		for(int i=pos;i<length;i++){
			String subString = s.substring(pos,i+1);
			if(isPalindrome(subString)){
				subList.add(subString);
				helper(s,i+1,subList,list);
				subList.remove(subList.size()-1);
			}
		}
	}
	
	public static boolean isPalindrome(String str){
		if(null == str || str.length() ==0)
			return true;
		
		int length = str.length();
		int i=0;
		while(i<length/2){
			if(str.charAt(i) != str.charAt(length-i-1))
				return false;
			i++;
		}
		return true;
	}

}
