/**
 * 题目：将被X包围的O全部改为X，没有被X包围的O不做改变。
 * 思路：广度优先遍历，用一个和board大小相同的boolean[][]来标记那些地方查过，哪些没查过。  如果对应的board位置为X，则flag相应位置初始为false。
 * 如果board相应位置为O，则flag相应位置初始为true。 当在遍历中遇到没有 被包围的O，则将flag相应位置改为false。如果是被包围的O，则将board修改为X。
 * 如果在board遍历中遇到O，且flag相应位置为true，则对该O的四周进行遍历，不断扩展，直到将所有相邻的O全部遍历一遍。对每个O进行判断，是否在边界位置。如果所有的O
 * 都不在边界位置，则这些O为被包围的 O。
 *
 * @ClassName:Leetcode130
 * @Description:Leetcode130
 * @author: hongbin.gao
 * @date:2016年9月20日 下午8:21:17
 *
 */
public class Leetcode130 {
	public static void main(String[] args){
		
	}
	
	public static void solve(char[][] board) {
		if(board == null || board.length == 0)
			return ;
	        int rows = board.length;  //横数
	        int columns = board[0].length; //列数
	        boolean[][] flag = new boolean[rows][columns];
	        for(int i=0;i<rows;i++)
	        	for(int j=0;j<columns;j++){
	        		if(board[i][j] =='X')  //X字符对应false
	        			flag[i][j] = false;
	        		if(board[i][j] == 'O') //O字符对应true。
	        			flag[i][j] = true;
	        	}
	        
	        for(int i=0;i<rows;i++){
	        	for(int j=0;j<columns;j++){
	        		if(board[i][j] =='O' && flag[i][j]){   //如果flag[i][j]为true表示这些'O'没有被遍历过，如果flag[i][j]为false，表示这些O是不被包围的O
	        			helper(i,j,board,flag);
	        		}
	        	}
	        }
	}
	
	public static void helper(int rows, int columns, char[][] board, boolean[][] flag){
		List<Integer> rowsList = new ArrayList<Integer>();
		List<Integer> columnsList = new ArrayList<Integer>();
		boolean isSurrounded = true;  //这些O是否是被包围的
		
		rowsList.add(rows);
		columnsList.add(columns);
		int i=0;
		while(i<rowsList.size()){
			int tempRow = rowsList.get(i);
			int tempColumn = columnsList.get(i);
			
			if(tempRow ==0 || tempRow == board.length-1 || tempColumn == 0 || tempColumn == board[0].length-1){
				isSurrounded = false;
			}
				
			if(tempRow-1>=0 && board[tempRow-1][tempColumn] =='O' && flag[tempRow-1][tempColumn]){ //上
				rowsList.add(tempRow-1);
				columnsList.add(tempColumn);
				flag[tempRow-1][tempColumn] = false;
			}
			if(tempRow+1<board.length && board[tempRow+1][tempColumn] =='O' && flag[tempRow+1][tempColumn]){ //下
				rowsList.add(tempRow+1);
				columnsList.add(tempColumn);
				flag[tempRow+1][tempColumn] = false;
			}
			if(tempColumn-1>=0 && board[tempRow][tempColumn-1] =='O' && flag[tempRow][tempColumn-1]){ //左
				rowsList.add(tempRow);
				columnsList.add(tempColumn-1);
				flag[tempRow][tempColumn-1] = false;
			}
			if(tempColumn+1<board[0].length && board[tempRow][tempColumn+1] =='O' && flag[tempRow][tempColumn+1]){ //右
				rowsList.add(tempRow);
				columnsList.add(tempColumn+1);
				flag[tempRow][tempColumn+1] = false;
			}
			i++;	
		}
		
		if(isSurrounded){
			i=0;
			while(i<rowsList.size()){
				board[rowsList.get(i)][columnsList.get(i)] = 'X';
				flag[rowsList.get(i)][columnsList.get(i)] = false;
				i++;
			}
		}
		else if(!isSurrounded){
			i=0;
			while(i<rowsList.size()){
				flag[rowsList.get(i)][columnsList.get(i)] = false;
				i++;
			}
		}
		return ;
	}

}
