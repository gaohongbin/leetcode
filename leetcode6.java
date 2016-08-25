public class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
		    	return s;
		    int len=s.length();
		    
		    //因为String取某个字符是用的char[],所以我在这里直接用了
		    char[] s1=s.toCharArray();//将String s转为字符数组
	        char[] s2=new char[len];
	        
	        int lenOfCycle=numRows*2-2;  //一个循环的长度
	        int lenOfS2=0;
	        int temp=0; //每一跳多远
	        
	        for(int i=0;i<numRows;i++){ //每次确定一行，一共numRows行
	        	temp=lenOfCycle-2*i;
	        	for(int j=i;j<len;){  //针对每一行进行循环推进
	        		s2[lenOfS2++]=s1[j];
	        		
	        		if(i==0 || i==numRows-1){
	        			temp=lenOfCycle;
	        			j=j+temp;
	        		}
	        		else{
	        			j=j+temp;
	        		    temp=lenOfCycle-temp;
	        		}
	        	}
	        }
	        return new String(s2);
    }
}
