public class Solution {
    public String reverseVowels(String s) {
        int len=s.length();  //len表示s的长度
	        if(len==0)
	        	return "";
	        
	        Character[] arrayChar ={'a','e','i','o','u','A','E','I','O','U'};  //元音组合
	        StringBuffer strBuf = new StringBuffer(s); //将s转为StringBuffer进行运算
	        Set<Character> set=new HashSet<Character>();  //将元音存在set里面，利用contain()来判断一个字符是否为元音
	        
	        for(int i=0;i<arrayChar.length;i++){
	        	set.add(arrayChar[i]);
	        }
	        
	        int low=0;
	        int high=len-1;
	        char temp;
	        while(low<high){
	        	while(set.contains(strBuf.charAt(low))!=true && low<high)
	        		low++;
	        	if(low>=high)
	        		break;
	        	while(set.contains(strBuf.charAt(high))!=true && low<high)
	        		high--;
	        	if(low>=high)
	        		break;
	        	temp=strBuf.charAt(low);
	        	strBuf.setCharAt(low, strBuf.charAt(high));
	        	strBuf.setCharAt(high, temp);
	        	low++;
	        	high--;
	        }
	        return strBuf.toString();
    }
}
