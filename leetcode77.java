/**
 *题目：两个参数n，k。 n表示1,2...n, k表示从1--n中选取k个数字。
 *结果：返回List<List<Integer>> 将所有的结果返回。
 * 
 * @author: hongbin.gao
 *
 */
public class Leetcode77 {
	public static void main(String[] args){
		List<List<Integer>> result = combine(4,2);
		System.out.println(result);
	}
	
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(n==0 || k==0)
			return result;
		
		int[] nums = new int[n];
		for(int i=0;i<n;i++)
			nums[i]=i+1;
		
		List<Integer> subList = new ArrayList<Integer>();
		int pos = 0;
		helper(nums,pos,k,result,subList);
        return result;	        
	}
	
	public static void helper(int[] nums, int pos, int k,List<List<Integer>> result,List<Integer> subList){
		if(pos+k>nums.length)
			return ;
		
		if(k==0){
			List<Integer> temp = new ArrayList<Integer>();
			for(int i=0;i<subList.size();i++){
				temp.add(subList.get(i));
			}
			result.add(temp);
			return ;
		}
		
		for(int i = pos;i<=nums.length - k; i++){
			subList.add(nums[i]);
			helper(nums,i+1,k-1,result,subList);
			subList.remove(subList.size()-1);
		}
		return ;
	}

}
