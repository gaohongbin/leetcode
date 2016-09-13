/**
 * 题目：两个参数，一个参数为字符串S，另一个参数为字符串T，找出一个最小的窗口，在S中包含了所有在T中的字符。
 *
 * @author: hongbin.gao
 * 
 * 思路：用两个哈希表，hashTable1和hashTable2，其中hashTable1保存了字符串T中的每个字符的个数。hashTable2保存了字符串S
 * 中low和high之间的每个字符的个数。
 * 
 * resultLow和resultHigh保存了到目前为止，最短的字串，初始值为 resultLow = 0; resultHigh = S.length()-1;即整个字符串S
 * 
 * low初始值为0,high初始值为0. high一直往前走，直到low和high之间的字符串 包含了所有T的字符停止。不断调整low和high，但是low和high之间
 * 永远保持包含T的所有字符。
 * 
 * 最后返回resultLow和resultHigh。
 *
 */
public class Leetcode76 {
	public static void main(String[] args){
		String s = "cabefgecdaecf";
		String t = "cae";
		String result = minWindow(s, t);
		System.out.println(result);
	}
	
	public static String minWindow(String s, String t) {
		if(s == null || t==null || s.length() ==0 || t.length() ==0)
			return "";
		
        int lengthOfS = s.length();  //s的长度
        int lengthOfT = t.length();  //t的长度
        
        if(lengthOfT == 1){
        	for(int i=0;i<lengthOfS;i++)
        		if(s.charAt(i)==t.charAt(0))
        			return t;
        }
        
        int resultLow = 0;
		int resultHigh = lengthOfS-1;  //resultLow和resultHigh保存的是最小的字串前后坐标，初始值为s字符串。 
				
        int[] hashTable1 = new int[128];  //用来保存t中每个字符的个数
        int[] hashTable2 = new int[128];  //用来保存low和high之间每个字符的个数，包含low和high的位置的字符
        
        char c;
        for(int i=0;i<lengthOfT;i++){  //建立hashTable。
            c = t.charAt(i);
        	hashTable1[c] ++;
        }
        
        int low = 0,high = 0;
        int count =0;  //用来识别low和high之间的字符是否已经包含了t中的所有字符
        while(high<lengthOfS && count<lengthOfT){  //循环结束时,如果存在这样的字串，则low和high之间恰好包含了所有的S。
        	c = s.charAt(high);
            if(hashTable1[c]>0){  //hashTable1相应位置大于0，表示t中包含该字符。t中不包含的字符，不做记录
            	if(hashTable2[c]<hashTable1[c])
            		count++;
            	hashTable2[c]++;
            }
            high++;
        }
        high--; 
        if(count <lengthOfT){  //如果不存在，直接返回"".
        	return "";
        }
        
        while(low<high){  //
        	c = s.charAt(low);
        	while(hashTable1[c]==0 || (hashTable2[c]>hashTable1[c] && hashTable1[c]>0)){
        		if(hashTable2[c]>0)
        			hashTable2[c]--;
        		low++;
        		c = s.charAt(low);
        	}
        	
        	if(high-low < resultHigh-resultLow){
        		resultHigh = high;
        		resultLow = low;
        	}
        	
        	if(high>=lengthOfS-1)
        	     break;
        	
        	while(high<lengthOfS-1 ){
        	   high++;
     		   c = s.charAt(high);
    		   if(hashTable1[c]>0)
    			   hashTable2[c]++;
    		   if(c == s.charAt(low))
    			   break;
        	}
        	
        	
        }
        if(resultHigh == lengthOfS)
    		resultHigh--;
        return s.substring(resultLow, resultHigh+1);
    }
}
 
