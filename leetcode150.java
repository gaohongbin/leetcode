public class Solution {
    public int evalRPN(String[] tokens) {
        int length = tokens.length;
		
		if(tokens == null || tokens.length == 0)
			return 0;
		if(length == 1)
			return Integer.valueOf(tokens[0]);
		
		int params_1;
		int params_2;   //两个参数用来保存运算参数
		
		Stack<Integer> nums = new Stack<Integer>();  //用来保存数字
		
		for(int i=0;i<length;i++){
			if(tokens[i].equals("+")){
				params_2 = nums.pop();
				params_1 = nums.pop();
				nums.push(params_1+params_2);
			}
			else if(tokens[i].equals("-")){
				params_2 = nums.pop();
				params_1 = nums.pop();
				nums.push(params_1-params_2);
			}
			else if(tokens[i].equals("*")){
				params_2 = nums.pop();
				params_1 = nums.pop();
				nums.push(params_1*params_2);
			}
			else if(tokens[i].equals("/")){
				params_2 = nums.pop();
				params_1 = nums.pop();
				nums.push(params_1/params_2);
			}
			else{
				nums.push(Integer.valueOf(tokens[i]));
			}
		}
		
		return nums.pop();
    }
}
