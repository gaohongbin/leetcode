/**
 * 题目:参数为int二维数组，一个机器人只能向右和向下移动，数组中1表示障碍物，0表示可以到达，求从左上角到达右下角的所有路线个数。
 * 思路：和62题一样，只是当obstacleGrid[i][j] == 1, 标记result[i][j] ==0,不可到达。其他无异。
 * 还是动态规划的思想。
 * 
 * @author ghb
 *
 */
public class Leetcode63 {
	public static void main(String[] args){
		int[][] obstacleGrid = {{0}};
		int result = uniquePathsWithObstacles(obstacleGrid);
		System.out.println(result);
		
	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null)
        	return 0;
        
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] result = new int[rows][columns];
        
        boolean flag = true;
        for(int i=0;i<rows;i++){
        	if(obstacleGrid[i][0] ==0 && flag)
        		result[i][0] = 1;
        	if(obstacleGrid[i][0] ==1 || !flag){
        	    flag = false;
        		result[i][0] = 0;
        	}
        }
        
        flag = true;
        for(int i =0;i<columns;i++){
        	if(obstacleGrid[0][i] ==0 && flag)
        		result[0][i] = 1;
        	if(obstacleGrid[0][i] ==1 || !flag){
        	    flag = false;
        		result[0][i] = 0;
        	}
        }
        
        flag = true;
        for(int i=1;i<rows;i++)
        	for(int j=1;j<columns;j++){
        		if(obstacleGrid[i][j] ==1){
        			result[i][j] = 0;
        		}
        		else{
        			result[i][j] = result[i-1][j]+result[i][j-1];
        		}
        	}
        return result[rows-1][columns-1];
    }

}

