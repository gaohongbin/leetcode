package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode49 {
	public static void main(String[] args){
		String[] strs = {"abc","acb"};
		List<List<String>> list = groupAnagrams(strs);
		System.out.println(list);
	}
	
	
	/**
	 * 方法一：这是一个超时的方法，可能我太老实了，所有的东西都自己去实现，虽然超时了，还是说一下我的思路吧。
	 * 
	 * 思路：我按照strs数组中字符串的个数，开了一个int flagAll[strs.length()][27]的标志字段。
	 * 该二维数组每一行是对List<List<String>> 的一个子列表的标记。 最后一位存储了字符串的长度。
	 * 
	 * 当出现一个新的字符串，则同样用flagOne将其标记，再和flagAll中的标记挨个比较(先比较字符串的长度,即flagAll[k][26])，
	 * 如果标记相同，则加入，如果没有一个相同，则新建子列表。
	 * 
	 * 但提交后的结果为超时。
	 */
	public static List<List<String>> groupAnagrams_1(String[] strs) {
        int length = strs.length;
        int[][] flagAll = new int[length][27]; //标记每个字符串中各个字母的个数, 最后一列存储字符串的长度
        int[] flagOne = new int[26];  //标记某个字符串
        
        List<String> subList = null; 
        List<List<String>> list = new ArrayList<List<String>>();
      
        for(int i=0;i<length;i++){
        	Arrays.fill(flagOne, 0);
        	
        	String str = strs[i];  //取某个字符串
        	for(int j=0;j<str.length();j++){
        		flagOne[str.charAt(j)-'a']++;
        	}
        	
        	int k =0;
        	for(k=0;k<list.size();k++){
        		if(str.length() == flagAll[k][26] && compare(flagOne,flagAll[k])){
        			list.get(k).add(strs[i]);
        			break;
        		}
        	}
        	
        	if(k == list.size()){
        		copy(flagAll[k],flagOne);
        		flagAll[k][26] = str.length();
        		subList = new ArrayList<String>();
        		subList.add(strs[i]);
        		list.add(subList);
        	}
        }
        
        return list;
    }
	
	public static boolean compare(int[] nums1, int[] nums2){  //判断两个数组是否相等。
		for(int i=0;i<26;i++){
			if(nums1[i] != nums2[i])
				return false;
		}
		return true;
	}
	
	public static void  copy(int[] nums1, int[] nums2){  //将nums2复制到nums1中
		for(int i = 0;i<26;i++){
			nums1[i] = nums2[i];
		}
		return ;
	}
	
	/**
	 * 方法二：将子列表不用数组来标记，用按字典排序后的字符串来标记。存储在Map中。
	 */
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		List<List<String>> result = new ArrayList<List<String>>();
		
		for(int i=0;i<strs.length;i++){
			char[] temp = strs[i].toCharArray();
		    Arrays.sort(temp);
		    
		    String str = new String(temp);
		    if(map.containsKey(str)){
		    	map.get(str).add(strs[i]);
		    }
		    else{
		    	List<String> subList = new ArrayList<String>();
		    	subList.add(strs[i]);
		    	map.put(str, subList);
		    }
		}
		
		for(String str : map.keySet()){
			
			result.add(map.get(str));
		}
		
		return result; 
	}
	

}
