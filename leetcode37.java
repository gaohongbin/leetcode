/**
 * 题目：参数为一个char[][],即题目给出的是一个数独的题目，当方格中没有数字的时候，则用'.'代替。
 * 
 * 思路：每个'.'的可能值 为 1-9，分别进行判断，当一个值不行，进行回溯。
 * 
 */

public class Leetcode37 {
	public static void main(String[] args){
		char[][] board = {};
		solveSudoku(board);
		return ;
	}
	
	public static void solveSudoku(char[][] board) {
		solve(board);
    }
	
	/**
	 * solve(board) 当得到一个数独的解，返回true，没有得到返回false。
	 */
	public static boolean solve(char[][] board){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(board[i][j] == '.'){
					for(char a ='1';a<='9';a++){
						board[i][j] = a;
						if(isValid(board,i,j) && solve(board))
							return true;
						board[i][j] = '.';
					}
					
					return false;
				}
			}
		}
		return true;
				
	}
	/**
	 * isValid用来判断board[row][column]位置的数字是否可用
	 */
	
	public static boolean isValid(char[][] board, int row, int column){
		char temp = board[row][column];
		
		for(int i=0;i<9;i++){  //判断相同列
			if(i!=row && board[i][column] == temp)
				return false;
		}
		
		for(int i=0;i<9;i++){  //判断相同行
			if(i != column && board[row][i] == temp)
				return false;
		}
		
		for(int i=row/3*3;i<(row/3+1)*3;i++){
			for(int j= column/3*3; j<(column/3+1)*3;j++){
				if((i != row || j != column) && (board[i][j] == temp))
					return false;
			}
		}
		
		return true;
	}

}
