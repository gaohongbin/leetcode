public class Solution {
    public int[] countBits(int num) {
        int[] countBits=new int[num+1];
	        
	        countBits[0]=0;
	        
	        int i=0;
	        
	        while(Math.pow(2, i)<=num){
	        	countBits[(int) Math.pow(2, i)]=1;
	        	i++;
	        }
	        
	        int count=0;
	        for(i=3;i<=num;i++){
	        	if(countBits[i]==0){
	        	count=(int)(Math.log(i)/Math.log(2));
	        	countBits[i]=countBits[(int)Math.pow(2, count)]+countBits[i-(int)Math.pow(2, count)];
	        	}
	        }
	        return countBits;
    }
}
