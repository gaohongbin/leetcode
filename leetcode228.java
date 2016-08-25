public class Solution {
    public List<String> summaryRanges(int[] nums) {
       List<String> list = new ArrayList<String>();
		if(nums == null)
			return null;
		if(nums.length ==0)
			return list;
		
		if(nums.length == 1){
			list.add(nums[0]+"");
			return list;
		}
		
		int length = nums.length;
		int index = 0;
		StringBuilder strBuil = new StringBuilder();
		for(int i =0;i<length;i++){
			if(i==0){
				strBuil.append(nums[i]+"");
				index = 0;
			}
			else if(nums[i]-nums[i-1] != 1){
				if(i-1 != index){
					strBuil.append('-');
					strBuil.append('>');
					strBuil.append(nums[i-1]+"");
				}
				
				list.add(strBuil.toString());
				strBuil.delete(0, strBuil.length());
				strBuil.append(nums[i]+"");
				index = i;
			}
			if(i==length-1 && strBuil.length()>0){
				if(nums[i]-nums[i-1]==1){
					strBuil.append('-');
					strBuil.append('>');
					strBuil.append(nums[i]+"");
				}
				list.add(strBuil.toString());
			}
		}
		return list;
    }
}
