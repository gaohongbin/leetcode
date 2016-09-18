/**
 * 题目：参数s为字符串，words为字符串数组，words中的字符串长度都相等，在s中找出所有的起点，从该起点开始，包含所有的words中的单词，
 * 这里的包含words中的所有单词为从起点开始，连续的words.length*words[0].length()个字符内包含。
 *
 * @author: hongbin.gao
 *
 *思路：设置一个长度为words.length*words[0].length()的窗口，每次检查窗口内的字符是否包含words中的所有单词，如果包含，则将窗口坐起点
 *的值加入列表，如果不包含，往后移动一个字符继续进行判断。
 */
public class Leetcode30 {
	public static void main(String[] args){
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar"};
		List<Integer> list = findSubstring(s, words);
		System.out.println(list);
	}
	
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<Integer>();
		if(s == null || s.length() ==0 || words == null || words.length ==0)
			return list;
		
		int lengthOfS = s.length();  //s的长度
		int wordCount = words.length; //words中单词的个数
		int wordLength = words[0].length();  //每个单词的长度
		
		Map<String,Integer> mapOfWords = new HashMap<String,Integer>();
		for(int i=0;i<wordCount;i++){   //新建一个map，保存words中的单词
			String temp = words[i];
			if(mapOfWords.containsKey(temp)){
				mapOfWords.put(temp, mapOfWords.get(temp)+1);
			}
			else
				mapOfWords.put(temp, 1);
		}
		
		boolean flag = true;
		Map<String,Integer> mapOfS = new HashMap<String,Integer>();
		for(int i=0;i<=lengthOfS-wordCount*wordLength;i++){
			mapOfS.clear();
			flag = true;
			for(int j=i;j<=i+(wordCount-1)*wordLength;j+=wordLength){  //从i开始，在i--i+wordCount*wordLength内查找单词
				String temp = s.substring(j, j+wordLength);
				if(mapOfWords.containsKey(temp)){
					if(!mapOfS.containsKey(temp)){
						mapOfS.put(temp, 1);
					}
					else{
						if(mapOfS.get(temp)<mapOfWords.get(temp)){
							mapOfS.put(temp, mapOfS.get(temp)+1);
						}
						else{
							flag = false;
							break;
						}
					}
				}
				else{
					flag = false;
					break;
				}
			}
			if(flag)
				list.add(i);
		}
        return list;
    }

}
 
