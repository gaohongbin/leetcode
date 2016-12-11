package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode127 {
	
	public static void main(String[] args){
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		int result = ladderLength(beginWord,endWord,set);
		System.out.println(result);
		
	}
	
	
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
	    int length = wordList.size();
	    String[] strs = new String[length];
	    int i=0;
	    for(String str: wordList){
	    	strs[i] = str;
	    	i++;
	    }
	    
	    List<String> list = new ArrayList<String>();
	    list.add(beginWord);
	    
	    int result = helper(endWord,strs,0,list);
	    return result;
	}
	
	public static int helper(String endWord,String[] wordList, int pos,List<String> list){
		int min = Integer.MAX_VALUE;
		
		if(pos>=wordList.length)  //如果不能组成这样的序列，返回-1
			return -1;  
		
		if(isValid(list.get(list.size()-1),endWord)){  //如果能，返回长度
			list.add(endWord);
			return list.size();
		}
		
		for(int i=pos;i<wordList.length;i++){
			change(wordList,i,pos);
			if(isValid(wordList[pos], list.get(list.size()-1))){
				list.add(wordList[pos]);
				helper(endWord,wordList,pos+1,list);
			}
		}
		
	}
	
	public static boolean isValid(String str1, String str2){  //比较str1和str2是否只差一个字符
		int length = str1.length();
		
		int diff = 0;
		for(int i=0;i<length;i++){
			if(str1.charAt(i) != str2.charAt(i))
				diff++;
		}
		
		if(diff == 1)
			return true;
		else
			return false;
	}
	
	public static void change(String[] strs, int pos1, int pos2){
		String temp = strs[pos1];
		strs[pos1] = strs[pos2];
		strs[pos2] = temp;
	}

}
