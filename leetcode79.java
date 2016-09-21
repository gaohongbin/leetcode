/**
 * 题目：在二维字符数组中找出所给的单词word，在board中寻找word时，字符必须连续，即前一个字符的前后左后，但是字符不能重复。
 * 思路：回溯
 * @author ghb
 *
 */
public class Leetcode79 {
	public static void main(String[] args){
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
		        {'A','D','E','E'}};
		String word = "ABCB";
		System.out.println(exist(board,word));
		
	}
	
	public static boolean exist(char[][] board, String word) {
		int rows = board.length;  //横数
		int columns = board[0].length;
		boolean[][] flag = new boolean[rows][columns];   //哪些字符遍历过，初始化为false。
		boolean[] result = new boolean[1];   //是否包含这样的word，初始化为false。
		result[0] = false;
		helper(board,word,0,flag,result,0,0);
		return result[0];
    }
	
	/**
	 * 
	 * @param board：
	 * @param word：
	 * @param pos：
	 * @param flag： boolean二位数组
	 * @param result： 最终的结果数组，数组长度为1
	 * @param row：  上一个字符所在的行
	 * @param column： 上一个字符所在的列
	 */
	public static void helper(char[][] board, String word, int pos, boolean[][] flag, boolean[] result, int row, int column){
		if(result[0])
			return ;
		
		int rows = board.length;  //行数
		int columns = board[0].length; //列数
		if(pos == 0){
			for(int i=0;i<rows;i++){
				for(int j =0;j<columns;j++){
					if(word.charAt(pos) == board[i][j]){  //如果board[i][j]和word的第一个字符相同，则进行遍历，完成后flag变回false
						flag[i][j] = true;
						helper(board,word,pos+1,flag,result,i,j);
						if(result[0])
							return ;
						flag[i][j] = false;
					}
				}
			}
			return ;
		}
		if(pos == word.length()){  //如果word已经遍历完成
			result[0] = true;
			return ;
		}
		else{
			if(row-1>=0 && board[row-1][column] == word.charAt(pos) && !flag[row-1][column]){  //上
				flag[row-1][column] = true;
				helper(board,word,pos+1,flag,result,row-1,column);
				if(result[0])
					return ;
				flag[row-1][column] = false;
			}
			if(row+1<rows && board[row+1][column] == word.charAt(pos) && !flag[row+1][column]){  //下
				flag[row+1][column] = true;
				helper(board,word,pos+1,flag,result,row+1,column);
				if(result[0])
					return ;
				flag[row+1][column] = false;
			}
			if(column-1>=0 && board[row][column-1] == word.charAt(pos) && !flag[row][column-1]){  //左
				flag[row][column-1] = true;
				helper(board,word,pos+1,flag,result,row,column-1);
				if(result[0])
					return ;
				flag[row][column-1] = false;
			}
			if(column+1<columns && board[row][column+1] == word.charAt(pos) && !flag[row][column+1]){  //右
				flag[row][column+1] = true;
				helper(board,word,pos+1,flag,result,row,column+1);
				if(result[0])
					return ;
				flag[row][column+1] = false;
			}
			return ;
		}
		
		
	}

}

