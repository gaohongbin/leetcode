public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (numRows == 0) {
			List<Integer> listOfList = new ArrayList<Integer>();
			//listOfList.add(null);
			//list.add(listOfList);
			return list;
		}

		int[][] array = new int[numRows ][numRows ];
		for (int i = 0; i < numRows; i++) {
			List<Integer> listOfList = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					array[i][j] = 1;
					listOfList.add(array[i][j]);
				} else if (j == i) {
					array[i][j] = 1;
					listOfList.add(array[i][j]);
				} else {
					array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
					listOfList.add(array[i][j]);
				}
			}
			list.add(listOfList);
		}

		return list;
    }
}
