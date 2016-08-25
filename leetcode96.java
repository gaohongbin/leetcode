public class Solution {
    public int numTrees(int n) {
      int[] sum=new int[n+1];
		    
            sum[0]=1;
            sum[1]=1;
            for(int i=2;i<=n;i++){
            	sum[i]=0;
            }
            
            for(int i=2;i<=n;i++){
            	for(int j=1;j<=i;j++)
            	   sum[i]=sum[i]+sum[j-1]*sum[i-j];
            }
            
            return sum[n];
  }
}
