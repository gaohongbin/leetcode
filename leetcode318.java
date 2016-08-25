public class Solution {
    public int maxProduct(String[] words) {
         int lengthOfArray = words.length;  //字符串数组中字符串的个数
		int flag[] = new int[lengthOfArray]; //用flag来表示每个字符串
		
		int result=0;
		for(int i=0;i<lengthOfArray;i++){  //处理得到flag[]
			int lengthOfString = words[i].length(); //字符串的长度
			
			for(int j=0;j<lengthOfString;j++){
				int temp = words[i].charAt(j)-'a';
				flag[i]=flag[i] | (1<<temp);
			}
		}
		
		for(int i=0;i<lengthOfArray-1;i++){
			for(int j=i+1;j<lengthOfArray;j++){
				if((flag[i]&flag[j])==0 && words[i].length()*words[j].length()>result)
					result = words[i].length() * words[j].length();
			}
		}
		
		return result;
    }
}
