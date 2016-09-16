/**
 * 题目：解码字符串，例如给出 "3[a]2[bc]" 的字符串，结果返回 "aaabcbc".
 * @author ghb
 *
 * 思路：没什么特别的思维，就是利用栈，一个存数字的number栈，一个存字符的cha栈，当遇到'['将数字存入数字栈中，遇到']'将cha栈中'[]'之间的字符取出，
 * 再从number栈中取出一个数字n，复制n遍后存入cha栈中，当字符串遍历一遍后，栈中存储的就是我们需要的字符串。
 * 
 */

public class Leetcode394 {
	public static void main(String[] args){
		String s = "2[abc]3[cd]ef";
		String result = decodeString(s);
		System.out.println(result);
	}
	
	public static String decodeString(String s) {
		if(s == null || s.length() ==0)
			return "";
		
		Stack<Integer> number = new Stack<Integer>();
		Stack<Character> cha = new Stack<Character>();
		int length = s.length();
		char c;
		
		StringBuffer strBuf = new StringBuffer();
		StringBuffer strBufChar = new StringBuffer();  //用来存储数字后面的字符
		for(int i=0;i<length;i++){
			c=s.charAt(i);
			if(c>='0' && c<='9'){
				strBuf.append(c);
			}
			else if(c == '['){
				number.push(Integer.valueOf(strBuf.toString()));
				strBuf.setLength(0);
				cha.push(c);
			}
			else if(c ==']'){
				while(cha.peek()!='['){
					strBufChar.append(cha.pop());
				}
				cha.pop();
				
				int index = number.pop();
				for(int j=0;j<index;j++){
					for(int k=strBufChar.length()-1;k>=0;k--){
						cha.push(strBufChar.charAt(k));
					}
				}
				strBufChar.setLength(0);
			}
			else{
				cha.push(c);
			}
		}
		return reverse(cha);
	}
	
	public static String reverse(Stack<Character> stack){
		if(stack == null || stack.size() ==0)
			return "";
		
		StringBuffer strBuf = new StringBuffer();
		while(stack.size()>0){
			strBuf.append(stack.pop());
		}
		
		int length = strBuf.length();
		for(int i=0;i<length/2;i++){
			char temp = strBuf.charAt(i);
			strBuf.setCharAt(i, strBuf.charAt(length-1-i)); 
			strBuf.setCharAt(length-1-i, temp);
		}
		
		return strBuf.toString();
	}

}

