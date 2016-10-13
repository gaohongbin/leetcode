/**
 * 题目：给一个二维数组matrix，如果matrix[i][j] = 0;则将第i行和第j列全部变为0.
 * 要求：空间复杂度为O(1).
 * 
 * 思路：先查看第0行和第0列，如果有0，则将标记flagRow和flagColumn改为true。
 * 然后遍历matrix，如果matrix[i][j] = 0, 则将matrix[i][0] = 0, matrix[0][j] = 0.
 * 遍历完成后，如果第0行第j列为0，则将第j列全改为0，如果第i行第0列为0，则将第i行全改为0。
 * 
 * @author: hongbin.gao
 *
 */
public class Leetcode73 {
	
	public static void main(String[] args){
		
	}
	
	public void setZeroes(int[][] matrix) {
		if(matrix == null)
			return ;
		
		int rows = matrix.length; //行
		int columns = matrix[0].length; //列
		
		boolean flagRow = false;  //标记第0行有没有0
		boolean flagColumn = false; //标记第0列有没有0
		
		for(int i=0;i<columns;i++)    //标记第0行和第0列。
			if(matrix[0][i] ==0){
				flagRow = true;
				break;
			}
		for(int i =0;i<rows;i++)
			if(matrix[i][0] ==0){
				flagColumn = true;
				break;
			}
		
		for(int i =1;i<rows;i++){  //变量从1开始，遍历二维矩阵。
			for(int j=1;j<columns;j++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i =1;i<columns;i++){  //根据修改后的二维矩阵，将某行某列全改为0
			if(matrix[0][i] ==0){
				for(int j=0;j<rows;j++)
					matrix[j][i] = 0;
			}
		}
		
		for(int i=1;i<rows;i++){  
			if(matrix[i][0] ==0)
				for(int j=0;j<columns;j++)
					matrix[i][j] = 0;
		}
		
		if(flagRow){  //根据flag修改第0行和第0列。
			for(int i=0;i<columns;i++)
				matrix[0][i] = 0;
		}
		
		if(flagColumn){
			for(int i=0;i<rows;i++)
				matrix[i][0] = 0;
		}
		return ;
	}

}
 
