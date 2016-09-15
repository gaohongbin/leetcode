public class Leetcode227 {
	public static void main(String[] args){
		String s = "100000000/1/2/3/4/5/6/7/8/9/10";
		int result  = calculate(s);
		System.out.println(result);
	}
	public static int calculate(String s) {
        char[][]  operator = {{'>','>','<','<'},{'>','>','<','<'},{'>','>','>','>'},{'>','>','>','>'}}; //操作符之间的优先关系
        char[] operatorToNumber = {'+','-','*','/'};  //操作符与数字对应
        		
        if(s == null || s.length() ==0)
        	return 0;
        
        
        
        int length = s.length();
        Stack<Character> oper = new Stack<Character>(); //用来存储操作符
        Stack<Integer> number = new Stack<Integer>(); //用来存储数字
        
        int pos =0;  //pos为一个指针，用来遍历s
        StringBuffer strBuf = new StringBuffer(); //当数字有多位的时候，用来存储数字
        char c;  //c为pos指向的字符
        while(pos<length){
        	c = s.charAt(pos);
        	char c1;  //取出两个操作符
			char c2;
			int number1;
			int number2;
			int numberOfC1 = 0;
			int numberOfC2 = 0;
        	if(c>='0' && c<='9'){  //如果c为数字
        		strBuf.append(c);
        	}
        	else{  //如果c为数字以外的字符
        		if(c==' '){
        			/*pos++;
        			continue;*/
        		}
        		else{  //c为 '+','-','*','/';
        			if(oper.size()<2){
        				if(strBuf.length()>0){
        					number.push(Integer.valueOf(strBuf.toString()));
        					strBuf.setLength(0);
        					oper.push(c);
        				}
        			}
        			else if(oper.size()>=2){
        				c1 = oper.pop();  //取出两个操作符
        				c2 = oper.pop();
        				
        				for(int j=0;j<4;j++){
        					if(operatorToNumber[j] == c1)
        						numberOfC1 = j;
        					if(operatorToNumber[j] == c2)
        						numberOfC2 = j; 
        				}
        				
        				if(operator[numberOfC2][numberOfC1]=='<'){
        					number1 = number.pop();
        					number2 = Integer.valueOf(strBuf.toString());
        					strBuf.setLength(0);  //清空strBuf
        					
        					oper.push(c2);  //c2没有用到，放入栈中
        					number.push(fun(number1,number2,c1));
        					oper.push(c);
        				}
        				
        				else if(operator[numberOfC2][numberOfC1]=='>'){
        					number1 = number.pop();
        					number2 = number.pop();
        					
        					number.push(fun(number2,number1,c2));
        					
        					oper.push(c1);
        					number.push(Integer.valueOf(strBuf.toString()));
        					strBuf.setLength(0);
        					oper.push(c);
        				}
        			}
        		}
        	}
        	
        	pos++;
        	if(pos == length){
        		if(oper.size()==0)
        			return Integer.valueOf(strBuf.toString());
        		else if(oper.size() ==1){
        			c1 = oper.pop();
        			number1 = number.pop();
    				number2 = Integer.valueOf(strBuf.toString());
    				
    				return fun(number1, number2, c1);
        		}
        		else{
        			c1 = oper.pop();
        			c2 = oper.pop();
        			
        			for(int j=0;j<4;j++){
    					if(operatorToNumber[j] == c1)
    						numberOfC1 = j;
    					if(operatorToNumber[j] == c2)
    						numberOfC2 = j; 
    				}
        			
        			if(operator[numberOfC2][numberOfC1]=='<'){
    					number1 = number.pop();
    					number2 = Integer.valueOf(strBuf.toString());
    					strBuf.setLength(0);  //清空strBuf
    					
    					oper.push(c2);  //c2没有用到，放入栈中
    					number.push(fun(number1,number2,c1));
    					
    				}
    				
    				else if(operator[numberOfC2][numberOfC1]=='>'){
    					number1 = number.pop();
    					number2 = number.pop();
    					
    					number.push(fun(number2,number1,c2));
    					
    					oper.push(c1);
    					number.push(Integer.valueOf(strBuf.toString()));
    					strBuf.setLength(0);
    					
    				}
        			
        			c1 = oper.pop();
        			number1 = number.pop();
    				number2 = number.pop();
    				
    				return fun(number2, number1, c1);
        		}
        	}
        	
        }
		return 0;
    }
	
	public static int fun(int number1, int number2, char c){
		if(c=='+')
			return number1 + number2;
		else if(c == '-')
			return number1 - number2;
		else if(c == '*')
			return number1*number2;
		else if(c =='/')
			return number1/number2;
		return 0;
	}

}
