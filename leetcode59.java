public class Solution {
    public int[][] generateMatrix(int n) {
        
		 int[][] result = new int[n][n];
		 
		 int r=0,c=0; //r表示行，c表示列
		 int index = 1;
		 while(r<n && c<n){
				if((r&1) == 0){
					   for(int i = r/2;i<n-r/2;i++){
						    result[r/2][i] = index;
						    index ++;
					   }
					}
					else if((r&1)==1){
						for(int i = n-r/2-2;i>=0+r/2;i--){
							result[n-1-r/2][i] = index;
							index ++;
						}
					}
					r++;
					
					//c为偶数时，右边的列从上往下打印；c为奇数时，左边的列从下往上打印
					if((c&1)==0){
						for(int i= (r+1)/2; i<=n-1-r/2;i++){
							result[i][n-1-c/2] = index;
							index ++;
						}
					}
					else if((c&1)==1){
						for(int i= n -(r+1)/2-1;i>=(r+1)/2;i--){
							result[i][c/2] = index;
							index ++;
						}
					}
					c++;
		 }
		 return result;
    }
}
