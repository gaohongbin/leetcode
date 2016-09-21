/**
 * 题目：Longest Valid Parentheses
 * 
 * 题目：参数为字符串s，s中只包含'('、')'两种字符，找出最长的可匹配字符串。
 * 例如：())最长可匹配字符串为2.等等。    ())()()最长为4
 *
 * 思路：我的思路：两个 栈和一个boolean[].
 * 一个栈stack用来存字符，另一个栈number用来存储stack中对应的下标。
 * boolean数组用来表示哪些字符可以匹配。
 * 
 * 通过boolean进行 统计，找出最长的可匹配字符串。按说我的时间复杂度为O(n),但是只击败了 0.5%的人。让我很郁闷。
 * 
 * @author: hongbin.gao
 *
 */
public class Leetcode32 {
	public static void main(String[] args){
		String s = "())";
		int result = longestValidParentheses(s);
		System.out.println(result);
	}
	
	public static int longestValidParentheses(String s) {
		if(s == null || s.length()<=1)
			return 0;

		int result = 0;  //最终的结果
		int length = s.length();  //字符串s的长度
		boolean[] flag = new boolean[length];  //用来标记那些括号是可以用的
		/*for(int i=0;i<length;i++)
			flag[i] = false;*/
		
		int low = 0;
		
		Stack<Character> stack = new Stack<Character>();
		Stack<Integer> number = new Stack<Integer>();
		stack.push(s.charAt(0));
		number.push(0);
		int i=1;
		while(i<length){
			if(stack.isEmpty() || s.charAt(i) == '('){
				stack.push(s.charAt(i));
				number.push(i);
			}
			else{
				char c = stack.peek();
				if(c == '('){
					stack.pop();
					low = number.pop();
					flag[low] = true;
					flag[i] = true;
				}
				else{
					stack.push(s.charAt(i));
					number.push(i);
				}
			}
			i++;
		}
		
		int temp = 0;
		for(i=0;i<length;i++){
			if(flag[i])
				temp++;
			if(!flag[i]){
				if(result<temp)
					result = temp;
				temp = 0;
			}
		}
		if(result<temp)
			result = temp;
		return result;
	}
}
