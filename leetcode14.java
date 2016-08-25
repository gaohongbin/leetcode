/**
* 题目：寻找字符串数组的最长公共字串。
* 
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
         int length=strs.length;
	        if(length==0)  //如果字符串数组中字符串的个数为0
	        	return "";
	        int minLength=strs[0].length(); //找出第一个字符串的长度
	        StringBuffer CommonPrefix=new StringBuffer(strs[0]);
	        for(int i=1;i<length;i++){     //该循环是找到字符串数组中长度最短的字符串进行初始化。
	        	if(minLength>strs[i].length()){
	        		minLength=strs[i].length();
	        		CommonPrefix.insert(0,strs[i]);
	        	}
	        }
	        if(minLength==0)  //如果最短的字符串长度为0，直接返回。
	        	return "";
	        for(int i=0;i<length;i++){ //对每个字符串的前minLength个字符进行比较，找出最长的公共前缀。
	        	StringBuffer str=new StringBuffer(strs[i]);
	        	for(int j=0;j<minLength;j++){
	        		if(CommonPrefix.charAt(j)!=str.charAt(j)){
	        			minLength=j;
	        			break;
	        		}
	        			
	        	}
	        }
	        return CommonPrefix.substring(0, minLength);
    }
}
