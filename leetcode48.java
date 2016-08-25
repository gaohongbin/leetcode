public class Solution {
    public void rotate(int[][] matrix) {
        	        int n = matrix.length; //n*n的矩阵，先得到n
	        
	        int temp = 0,temp1=0;
	        int x =0, x1=0;
	        int y=0, y1=0;
	        for(int i =0;i<n/2;i++){
	        	for(int j =i; j<n-1-i;j++){
	        	   x=i;
	        	   y=j;
	        	   x1 = j;
	        	   y1 = n-1-x;
	        	   temp = matrix[x][y];
	        	   while(x1!=i || y1!=j){
	        		   temp1 = matrix[x1][y1];
	        		   matrix[x1][y1] =temp;
	        		   temp = temp1;
	        		   x=x1;
	        		   y=y1;
	        		   x1=y;
	        		   y1=n-1-x;
	        	   }
	        	   matrix[i][j] = temp;
	        	}
	        }
    }
}
