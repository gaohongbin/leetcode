public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        		if(numbers == null || numbers.length<2)
			return null;
		
		int[] result = new int[2];
		
		int length = numbers.length;
		int low = 0;
		int high = length-1;
		while(low<high){
			if(numbers[low]+numbers[high] == target){
				result[0] = low+1;
				result[1] = high+1;
				return result;
			}
			else if(numbers[low] + numbers[high] > target){
				high--;
			}
			else
				low++;
		}
		return null;
    }
}
