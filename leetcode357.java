public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] array= {1,9,81,648,4536,27216,136080,544320,1632960,3265920,3265920};
	        
	        int result = 0;
	        
	        if(n<=10){
	        	for(int i=0;i<=n;i++){
	        	    result+=array[i]; 
	        	}
	        	return result;
	        }
	        else
	        	return 8877691;
    }
}
