public class Solution {
    public List<Integer> getRow(int rowIndex) {
           List<Integer> list=new ArrayList<Integer>();  
		if(rowIndex==0){
			list.add(1);
			return list;
		}
		
		int[][] array = new int[rowIndex+1][rowIndex+1];
		for(int i=0;i<=rowIndex;i++){
			for(int j=0;j<=i;j++){
				if(j==0){
					array[i][j]=1;
				}
				else if(j==i){
					array[i][j]=1;
				}
				else{
					array[i][j]=array[i-1][j-1]+array[i-1][j];
				}
			}
			
		}
		
		for(int i=0;i<=rowIndex;i++){
			list.add(array[rowIndex][i]);
		}
		return list;
    }
}
