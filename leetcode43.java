/**
 * 参数为两个字符串num1和nums2，返回num1*num2的结果，用字符串表示。
 * @author ghb
 *
 */
public class Leetcode43 {
	public static void main(String[] args){
		String num1 = "6677";
		String num2 = "98";
		String result = multiply(num1, num2);
		System.out.println(result);
	}
	
	
	public static String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0"))
			return "0";
		int length1 = num1.length();
		int length2 = num2.length();
		
		int i;
		int lengthTemp = 0;
		char[] result = new char[length1+length2];
		for(i=0;i<length1+length2;i++)
			result[i] = '0';
		
		while(lengthTemp<length2){
			for(i=0;i<length1+length2-1;i++){
				result[i]=result[i+1];
			}
			result[length1+length2-1] = '0';
			helper(result, num1, num2.charAt(lengthTemp));
			lengthTemp++;
		}
		
		if(result[0] !='0')
			return new String(result);
		else
			return new String(result,1,length1+length2-1);
	        
	}
	
	public static void helper(char[] result, String num, char c){
		int carry = 0; //用来保存进位
		int temp1 = 0; //用来保存和num对应位相乘时所对应的数字
		int temp2 = 0; //用来保存c对应的数字
		
		int length = num.length();  //num的长度
		char[] nums = new char[length+1];   //先算出num*c,最后和result相加
		for(int i=0;i<length+1;i++){
			if(i==0)
				nums[i] = '0';
			else
				nums[i] = num.charAt(i-1);
		}
		
		temp2 = c - '0';  
		while(length>=0){  //nums保存 num*c的结果
			temp1 = nums[length] - '0';
			nums[length] = (char)((temp1*temp2 + carry)%10 + '0');
			carry = (temp1*temp2 + carry)/10;
			length--;
		}
		
		//result[] + nums[]
		int lengthOfResult = result.length;
		length = nums.length;
		int i =0;
		carry = 0;
		while(i<length){
			temp1 = nums[length-i-1]-'0';
			temp2 = result[lengthOfResult-i-1]-'0';
			result[lengthOfResult - i -1] = (char)((temp1+temp2+carry)%10+'0');
			carry = (temp1+temp2+carry)/10;
			i++;
		}
		while(i<lengthOfResult){
			temp2 =  result[lengthOfResult-i-1]-'0';
			result[lengthOfResult-i-1] = (char)((temp2+carry)%10+'0');
			carry = (temp2+carry)/10;
			i++;
		}
		
		return ;
	}

}

