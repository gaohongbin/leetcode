public class Solution {
    public int strStr(String haystack, String needle) {
       	        int len1=haystack.length();
	        int len2=needle.length();
	        if(len2>len1)
	        	return -1;
	        if(len2==len1 && haystack.equals(needle))
	        	return 0;
	        if(len2==len1 && !haystack.equals(needle))
	        	return -1;
	        if(len2==0)
	        	return 0;
	        
	        int[] table=new int[len2];  //KMP算法
	        for(int k=1;k<len2;k++){  //计算KMP算法的table，k表示正在计算needle的第几个字母的table值
		        for(int i=k;i>0;i--){  //检查最优前缀和最优后缀的长度，先检查长度为k的前缀和后缀，后检查长度为k-1的前缀和后缀
		        	for(int j=0;j<i;j++){  //j表示针对长度为i的前缀和后缀，现在比较了几个字母
		        		if(needle.charAt(k-j)!=needle.charAt(i-j-1)){ //发现在某个字母不一样了，表示长度为i的前缀和后缀不能匹配
		        			break;
		        		}
		        		if(j==i-1){
		        			table[k]=i;
		        			i=0;
		        		}
		        	}
	        }
	      }
	        
	    int i=0;
	    int j=0;
	    	while(j<len2){
	    		if(j==len2-1 && haystack.charAt(j+i)==needle.charAt(j))
	    			return i;
	    		if(haystack.charAt(j+i)!=needle.charAt(j)){
	    			if(j==0){
	    				i=i+1;
	    				j=-1; //因为后面会进行j++，所以设为-1
	    			}
	    			else{
	    				i=i+j-table[j-1];
	    				j=table[j-1]-1;
	    			}
	    			if(i>len1-len2)
	    				return -1;
	    		}
	    		j++;
	    	}
	    return -1;
    }
}
