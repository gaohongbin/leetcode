/**
 * 题目： 参数为一个二维字符数组，数组中只包含'0'和'1',其中0表示水，1表示陆地，当陆地上下左右四个方向全为水时，成为一个岛
 * 求给定的二维字符数组中岛的个数。
 * 
 * 思路：这其实就是一个搜索问题，这个题不存在深搜还是广搜，两种搜索方法的结果应该是一样的，但是为了方便，我这里写的是深度搜索。
 *
 * @author: hongbin.gao
 *
 */
public class Leetcode200 {
	public static void main(String[] args){
		char[][] grid ={{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		int result = numIslands(grid);
		System.out.println(result);
	}
	
	public static int numIslands(char[][] grid) {
		if(grid == null || grid.length<=0)
			return 0;
		int result = 0; //岛的个数，初始值设为0
		int rows = grid.length;  //二维数组的行数
		int columns = grid[0].length;  //二维数组的列数
		
		boolean[][] flag = new boolean[rows][columns];
		for(int i=0;i<rows;i++)
			for(int j=0;j<columns;j++)
				flag[i][j] = false;   //没有被遍历的地方用flase保存
		
		for(int i=0;i<rows;i++)
			for(int j=0;j<columns;j++){
				if(grid[i][j] == '1' && flag[i][j] == false){
					result++;
					helper(i,j,flag,grid);
				}
			}
		
		return result;
    }
	
	public static void helper(int rows, int columns, boolean[][] flag,char[][] grid){  //传过来一个坐标，rows和columns，将该小岛遍历一遍
		int rowOfGrid = grid.length;
		int columnOfGrid = grid[0].length;
		
		if(rows<0 || rows>=rowOfGrid)
			return ;
		if(columns<0 || columns>=columnOfGrid)
			return ;
		
		if(grid[rows][columns] =='1' && flag[rows][columns] == false){
			flag[rows][columns] = true;
			
			helper(rows-1, columns,flag, grid); //上
			helper(rows+1, columns,flag, grid); //下
			helper(rows, columns-1,flag, grid); //左
			helper(rows, columns+1,flag, grid); //右
		}
		
		return ;
	}

}
