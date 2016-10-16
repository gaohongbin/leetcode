/**
 * 题目：给的参数为一个二位矩阵，矩阵中有两种元素，一种‘0’，一种‘1’，求出‘1’组成的最大方阵。
 * 
 * 思路： 当matrix[i][j]==‘1’ 则以matrix[i][j]为方阵的右下角的方阵的最大面积为result[i][j].
 * result[i][j] 边长为 sqrt(min(result[i-1][j],result[i][j-1],result[i-1][j-1]))+1;
 * @author ghb
 *
 */
public class Leetcode221 {
	public static void main(String[] args){
		char[][] matrix = {{'1','0','1','0','0'},
				           {'1','0','1','1','1'},
				           {'1','1','1','1','1'},
				           {'1','0','0','1','0'}};
		int result = maximalSquare(matrix);
		System.out.println(result);
	}
	
	
	public static int maximalSquare(char[][] matrix) {
	        if(null == matrix || matrix.length ==0 || matrix[0].length ==0)
	        	return 0;
	        
	        int rows = matrix.length;  //行数
	        int columns = matrix[0].length;  //列数
	        int[][] result = new int[rows][columns];
	        int max = 0;
	        
	        for(int i=0;i<rows;i++){
	        	for(int j=0;j<columns;j++){
	        	    if(matrix[i][j] == '1' && i-1>=0 && j-1 >=0 && result[i-1][j]!=0 && result[i][j-1]!=0 && result[i-1][j-1]!=0){
	        	    	result[i][j] = (int) (Math.sqrt(Math.min(Math.min(result[i-1][j],result[i-1][j-1]),result[i][j-1]))+1);
	        	    	result[i][j] = result[i][j]*result[i][j];
	        	    }
	        	    else if(matrix[i][j] == '1'){
	        	    	result[i][j] = 1;
	        	    }
	        	    else{
	        	    	result[i][j] = 0;
	        	    }
	        	    
	        	    if(result[i][j]>max)
	        	    	max = result[i][j];
	        	}
	        }
	        return max;
	}

}

