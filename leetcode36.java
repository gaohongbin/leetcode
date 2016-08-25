public class Solution {
    public boolean isValidSudoku(char[][] board) {
         if(board==null)
	        	return false;
	        List<Set<Character>> rows=new ArrayList<Set<Character>>();
	        List<Set<Character>> columns=new ArrayList<Set<Character>>();
	        List<Set<Character>> boards= new ArrayList<Set<Character>>();
	        
	        for(int i=0;i<9;i++){
	        	rows.add(new HashSet<Character>());
	        	columns.add(new HashSet<Character>());
	        	boards.add(new HashSet<Character>());
	        }
	        
	        for(int i=0;i<9;i++){
	        	for(int j=0;j<9;j++){
	        		char number=board[i][j];
	        		if(number=='.')
	        			continue;
	        		else if(rows.get(i).contains(number) || columns.get(j).contains(number) || boards.get(i/3*3+j/3).contains(number))
	        			return false;
	        		else{
	        			rows.get(i).add(number);
	        			columns.get(j).add(number);
	        			boards.get(i/3*3+j/3).add(number);
	        		}
	        		
	        	}
	        }
	        return true;
    }
}
