public class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null)
			return num2;
		if(num2 == null)
			return num1;
		
		int length1 = num1.length();
		int length2 = num2.length();
		
		//默认num1的长度大于num2的长度。如果num2的长度大于num1的长度，进行交换。
		if(length2>length1){
			String tempString = num2;
			num2 = num1;
			num1 = tempString;
			
			int tempLength = length1;
			length1 = length2;
			length2 = tempLength;
		}
		
		StringBuffer strBuf = new StringBuffer(length1+1);  //开一个长度为length1+1的缓存
		strBuf.setLength(length1+1);
		strBuf.setCharAt(0, '0');
		int index = 0; //表示进位
		int add = 0; //某一位之和
		int i=0;
		while(i<length2){
			add = num1.charAt(length1-1-i)-'0'+num2.charAt(length2-1-i)-'0'+index;
			index = add/10;
			strBuf.setCharAt(length1-i, (char)(add%10+'0'));
			i++;
		}
		while(i<length1 ){
			add = num1.charAt(length1-1-i)-'0'+index;
			index = add/10;
			strBuf.setCharAt(length1-i, (char)(add%10+'0'));
			i++;
		}
	
		strBuf.setCharAt(0, (char)(index+'0'));
		if(strBuf.charAt(0)=='0')
			return strBuf.substring(1).toString();
		else
			return strBuf.toString();
    }
}
