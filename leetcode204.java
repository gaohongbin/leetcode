public class Solution {
    public int countPrimes(int n) {
      boolean[] b =new boolean[n];
		for(int i=2;i<=n/2;i++){
			if(!b[i]){
				for(int j=2;j*i<n;j++){
					b[j*i]=true;
				}
			}
	}
		int sum=0;
		for(int i=2;i<n;i++){
			if(b[i]==false)
				sum++;
		}
		return sum;
  
    }
}
