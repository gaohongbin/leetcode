public class Solution {
    public String numberToWords(int num) {
       if(num==0)
			return "Zero";
		
	       int length=String.valueOf(num).length(); //num的长度
	       StringBuffer strBufOfNumber=new StringBuffer(String.valueOf(num));//num转为StringBuffer
           StringBuffer wordsOfNumber=new StringBuffer();  //num转换后的字符串
           int flag=0;
           
           for(int i=0;i<length;i++){
        	   char temp1=strBufOfNumber.charAt(i);
               int temp2=0;        	   
        	   if(length-i==10){
        		   if(temp1-'0'>0)
        		   wordsOfNumber.append(intToString(temp1-'0',0));
        		   wordsOfNumber.append(" Billion");
        	   }
        	   else if(length-i==9 && temp1!='0'){
        		   if(length>9 && temp1-'0'>0){
        			   wordsOfNumber.append(" ");
        			   wordsOfNumber.append(intToString(temp1-'0',0));
            		   wordsOfNumber.append(" Hundred");
            		   flag=1;
        		   }
        		   else if(temp1-'0'>0){
        			   wordsOfNumber.append(intToString(temp1-'0',0));
            		   wordsOfNumber.append(" Hundred");
            		   flag=1;
        		   }
        	   }
        	   else if(length-i==8){
        		   if(temp1=='1' || temp1=='0'){
        			   temp2=(temp1-'0')*10+strBufOfNumber.charAt(++i)-'0';
        			   
        			   if(temp2>0 && length>8){
        				   wordsOfNumber.append(" ");
        				   wordsOfNumber.append(intToString(temp2,0));
        				   flag=0;
        				   wordsOfNumber.append(" Million");
        			   }
        			   else if(temp2>0){
        				   wordsOfNumber.append(intToString(temp2,0));
        				   flag=0;
        				   wordsOfNumber.append(" Million");
        			   }
        			   
        			   if(flag==1)
        				   wordsOfNumber.append(" Million");
        			   flag=0;
        		   }
        		   else{
        			   if(length>8)
        				   wordsOfNumber.append(" ");
            			   wordsOfNumber.append(intToString(temp1-'0',1));
            			   flag=1;
        		   }
        	   }
        	   else if(length-i==7){
        		   if(length>7 && temp1-'0'>0){
        			   wordsOfNumber.append(" ");
        			   wordsOfNumber.append(intToString(temp1-'0',0));
        			   flag=1;
        		   }
        		   else if(temp1-'0'>0){
        			   wordsOfNumber.append(intToString(temp1-'0',0));
        			   flag=1;
        		   }
        		   if(flag==1)
    				   wordsOfNumber.append(" Million");
    			   flag=0;
        	   }
        	   else if(length-i==6 && temp1!='0'){
        		   if(length>6){
        			   wordsOfNumber.append(" ");
        		   }
        			   wordsOfNumber.append(intToString(temp1-'0',0));
        			   wordsOfNumber.append(" Hundred");
        			   flag=1;
        	   }
        	   else if(length-i==5){
        		   if(temp1=='1' || temp1=='0'){
        			   temp2=(temp1-'0')*10+strBufOfNumber.charAt(++i)-'0';
        			   
        			   if(temp2>0 && length>5){
        				   wordsOfNumber.append(" ");
        				   flag=0;
        				   wordsOfNumber.append(intToString(temp2,0));
        				   wordsOfNumber.append(" Thousand");
        			   }
        			   else if(temp2>0){
        				   flag=0;
        				   wordsOfNumber.append(intToString(temp2,0));
        				   wordsOfNumber.append(" Thousand");
        			   }
        			  // wordsOfNumber.append(" Thousand");
        			   if(flag==1)
        				   wordsOfNumber.append(" Thousand");
        		   }
        		   else{
        			   if(length>5)
        				   wordsOfNumber.append(" ");
        			   flag=1;
        			   wordsOfNumber.append(intToString(temp1-'0',1));
        		   }
        	   }
        	   else if(length-i==4){
        		   if(length>4 && temp1!='0'){
        			   wordsOfNumber.append(" ");
        			   wordsOfNumber.append(intToString(temp1-'0',0));
            		   flag=1;
        		   }
        		   else if(temp1!='0'){
        			   wordsOfNumber.append(intToString(temp1-'0',0));
            		   flag=1;
        		   }
        		   if(flag==1){
        			   wordsOfNumber.append(" Thousand");
        			   flag=0;
        		   }
        	   }
        	   else if(length-i==3 && temp1!='0'){
        		   if(length>3 && temp1!='0'){
        			   wordsOfNumber.append(" ");
            		   wordsOfNumber.append(intToString(temp1-'0',0));
            		   wordsOfNumber.append(" Hundred");
        		   }
        		   else if(temp1!='0'){
        			   wordsOfNumber.append(intToString(temp1-'0',0));
            		   wordsOfNumber.append(" Hundred");
        		   }
        	   }
        	   else if(length-i==2){
        		   if(temp1=='1' || temp1=='0'){
        			   temp2=(temp1-'0')*10+strBufOfNumber.charAt(++i)-'0';
        			   if(temp2>0 && length>2){
        				   wordsOfNumber.append(" ");
        				   wordsOfNumber.append(intToString(temp2,0));
        			   }
        			   else if(temp2>0)
        				   wordsOfNumber.append(intToString(temp2,0));
        		   }
        		   else{
        			   if(length>2)
        				   wordsOfNumber.append(" ");
        			   wordsOfNumber.append(intToString(temp1-'0',1));
        		   }
        	   }
        	   else if(length-i==1){
        		   if(temp1!='0' && length>1){
        			   wordsOfNumber.append(" ");
        			   wordsOfNumber.append(intToString(temp1-'0',0)); 
        		   }
        		   else if(temp1!='0'){
        			   wordsOfNumber.append(intToString(temp1-'0',0));
        		   }
        	   }
           }
           return wordsOfNumber.toString();
           
    }
    
    public String intToString(int number,int flag){
		if(number==0 && flag==0)
			return "Zero";
		if(number==1 && flag==0)
			return "One";
		if(number==2 && flag==0)
			return "Two";
		if(number==3 && flag==0)
			return "Three";
		if(number==4 && flag==0)
			return "Four";
		if(number==5 && flag==0)
			return "Five";
		if(number==6 && flag==0)
			return "Six";
		if(number==7 && flag==0)
			return "Seven";
		if(number==8 && flag==0)
			return "Eight";
		if(number==9 && flag==0)
			return "Nine";
		
		if(number==10 && flag==0)
			return "Ten";
		if(number==11 && flag==0)
			return "Eleven";
		if(number==12 && flag==0)
			return "Twelve";
		if(number==13 && flag==0)
			return "Thirteen";
		if(number==14 && flag==0)
			return "Fourteen";
		if(number==15 && flag==0)
			return "Fifteen";
		if(number==16 && flag==0)
			return "Sixteen";
		if(number==17 && flag==0)
			return "Seventeen";
		if(number==18 && flag==0)
			return "Eighteen";
		if(number==19 && flag==0)
			return "Nineteen";
		
		if(number==2 && flag==1)
			return "Twenty";
		if(number==3 && flag==1)
			return "Thirty";
		if(number==4 && flag==1)
			return "Forty";
		if(number==5 && flag==1)
			return "Fifty";
		if(number==6 && flag==1)
			return "Sixty";
		if(number==7 && flag==1)
			return "Seventy";
		if(number==8 && flag==1)
			return "Eighty";
		if(number==9 && flag==1)
			return "Ninety";
		return null;
	}
}
