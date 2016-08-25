public class Solution {
    private static char[][] phoneNumber={{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
		   List<String> list = new ArrayList<String>();
		   if(length == 0)
			   return list;
		   
	       int[] flag = new int[length];
	       boolean judgeFlag = false;
	       
	       while(true){
	    	   /*for(int i=0;i<length;i++){  //用来判断judgeFlag的值
	    		   if(digits.charAt(i)=='7' || digits.charAt(i)=='9'){
	    			   if(flag[i]!=3)
	    				   judgeFlag = false;
	    		   }
	    		   else
	    			   if(flag[i]!=2)
	    				   judgeFlag = false;
	    	   }*/
	    	   if(judgeFlag == true) //judgeFlag用来判断循环是否结束
	    		   break;
	    	   
	    	   StringBuffer strBuff = new StringBuffer(digits); //List<String> 中的结果先存在str中
               
	    	   for(int  i = 0; i < length; i++){
	    		   char c = phoneNumber[digits.charAt(i) - '2'][flag[i]];
	    		   strBuff.setCharAt(i, c);
	    	   }
	    	   list.add(strBuff.toString());
	    	   
	    	   for(int i = length-1;i>=0;i--){
	    		   if(i==0 && (digits.charAt(i)=='7'||digits.charAt(i)=='9') && flag[i]==3){
	    			   judgeFlag = true;
	    			   break;
	    		   }
	    		   else if(i==0 && digits.charAt(i)!='7' && digits.charAt(i)!='9' && flag[i]==2){
	    			   judgeFlag = true;
	    			   break;
	    		   }
	    		   else if(digits.charAt(i) =='7' || digits.charAt(i) =='9'){
	    			   if(flag[i]<3){
	    				   flag[i]++;
	    				   break;
	    			   }
	    			   else{
	    				   flag[i]=0;
	    			   }
	    	      }
	    		   else{
	    			   if(flag[i]<2){
	    				   flag[i]++;
	    				   break;
	    			   }
	    			   else
	    				   flag[i]=0;
	    		   }
	       }
	       
	    }
	       return list;
    }
}
