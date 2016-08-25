public class Solution {
    public int calculate(String s) {
       Stack<Integer> number = new Stack<Integer>(); //用来存数字
	    Stack<Character> cha = new Stack<Character>(); //用来存符号
	       
	        s = s.replaceAll(" ", "");
	        
	        int length = s.length();
	        int temp=-1;  //当出现多位数的时候，用temp进行合并
	        int parameter = 0;  //对字符串进行操作的时候，parameter作为参数
	        char c; //表示s中的一位字符
	        
	        for(int  i=0;i<length;i++){
	        	c = s.charAt(i);
	           	if(c >='0' && c<='9' && temp!=-1)
	           		temp = temp*10 + c - '0';
	           	else if(c >='0' && c<='9' && temp == -1)
	           		temp = c - '0';
	           	else if(c=='-' || c=='+'){
	           		if(temp != -1){
	           			number.add(temp);
	           		    temp = -1;
	           		}
	           		if(!cha.isEmpty()){
	           			char c2 = cha.pop();
	           			if(c2 == '+'){
		           			temp = number.pop();
		           			parameter = number.pop();
		           			
		           			temp = temp + parameter;
		           			number.push(temp);
		           			temp = -1;
	           			}
	           			else if(c2 == '-'){
	           				temp = number.pop();
		           			parameter = number.pop();
		           			
		           			temp = parameter - temp;
		           			number.push(temp);
		           			temp = -1;
	           			}
	           			else if(c2 == '('){
	           				cha.push(c2);
	           			}
	           		}
	           		
	           		cha.push(c);
	           	}
	           	else if(c == '('){
	           		cha.push(c);
	           	}
	           	else{
	           		if(temp != -1)
	           			number.push(temp);
	           		
	           		boolean bool = true;
	           		
	           		while(!cha.isEmpty()){
	           			c = cha.pop();
		           		if(c == '+'){
		           			temp = number.pop();
		           			parameter = number.pop();
		           			
		           			temp = temp + parameter;
		           			number.push(temp);
		           			temp = -1;
		           		}
		           		else if(c == '-'){
		           			temp = number.pop();
		           			parameter = number.pop();
		           			
		           			temp = parameter - temp;
		           			number.push(temp);
		           			temp = -1;
		           		}
		           		else if(c == '(' && bool == true)
		           			bool = false;
		           		else if(c == '(' && bool == false){
		           			cha.push(c);
		           			break;
		           		}
		           		
	            	}
	          }
	        }
	        if(temp != -1){
	        	number.push(temp);
	        	temp = -1;
	        }
	        
	        if(!cha.isEmpty()){
	        	c = cha.pop();
	        	if(c == '-'){
	        		temp = number.pop();
	        		parameter = number.pop();
	        		
	        		temp = parameter - temp;
	        		number.push(temp);
	        	}
	        	else if(c == '+'){
	        		temp = number.pop();
	        		parameter = number.pop();
	        		
	        		temp = parameter + temp;
	        		number.push(temp);
	        	}
	        }
	        return number.pop();
    }
}
