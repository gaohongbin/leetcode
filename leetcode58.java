public class Solution {
    public int lengthOfLastWord(String s) {
     int length=s.length();
		int lengthOfLastWord=0; //空格的位置
		char charOfs;  //s字符串的每个字符
		if(length==0)
			return 0;
		for(int i=0;i<length;i++){
			charOfs=s.charAt(i);
			/*if(charOfs!=' '){
				lengthOfLastWord++;
			}
			if(charOfs==' ' && i!=length-1)
				lengthOfLastWord=0;
		}*/
		/*if(spaceOfIndex==-1 && s.charAt(length-1)==' ')
			return length-1;
		if(spaceOfIndex==-1)
			return 0;
		return length-spaceOfIndex-1; */
			if(charOfs!=' '){
			   if(i==0)
				lengthOfLastWord++;
			   else if(s.charAt(i-1)==' ')
				   lengthOfLastWord=1;
			   else
				   lengthOfLastWord++;
			}
		}
		return lengthOfLastWord;
}
}

