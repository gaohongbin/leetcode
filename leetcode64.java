public class Solution {
    public int minPathSum(int[][] grid) {
                   int rows=grid.length;
	        int columns=grid[0].length;
	        int[][] path=new int[rows][columns];
	        path[0][0]=grid[0][0];
	      if(rows>1 && columns>1){
	        for(int i=0;i<rows;i++){
	        	for(int j=0;j<columns;j++){
	        		if(i==0 && j!=0)
	        			path[i][j]=path[i][j-1]+grid[i][j];
	        		else if(i!=0 && j==0)
	        			path[i][j]=path[i-1][0]+grid[i][0];
	        		else if(i!=0 && j!=0)
	        			path[i][j]=(path[i-1][j]<path[i][j-1]?path[i-1][j]:path[i][j-1])+grid[i][j];
	        	}
	        }
	        return path[rows-1][columns-1];
	      }
	      else if(rows==1){
	    	  int sum=0;
	    	  for(int i=0;i<columns;i++)
	    		  sum=sum+grid[0][i];
	    	  return sum;
	      }
	      else{
	    	  int sum=0;
	    	  for(int i=0;i<columns;i++)
	    		  sum=sum+grid[i][0];
	    	  return sum;
	      }
    }
}
