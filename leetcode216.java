/**
*整体思路：在设定好i位置的值后，将i位置的值+1设为i+1位置的值，但remainder不变，
* 这样，在设置i+1位置的值时，i+1位置已经预设一个值，从这个值开始进行循环。
* 但当到达k-1位置的时候（也就是最后一个位置），直接将remainder（如果remainder合适）设置该位置的值。
*
*
*/

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
		 if(k==0 || n<2)
			 return list;
		 
		 if((1+k)*k/2 > n)
			 return list;
		 
		 List<Integer> subList = new ArrayList<Integer>();
		 int remainder = n;
		 subList.add(1);
		 helper(list,subList,0,k,remainder);
		
		 return list;
    }
    
    public void helper(List<List<Integer>> list,List<Integer> subList,int index, int k, int remainder){
         if(index == k-1 && remainder > subList.get(k-2) && remainder <=9){  //如果可以组成一个结果。
        	 subList.set(index,remainder);  //修改指定位置数字
        	 List<Integer> subList_1 = new ArrayList<Integer>();
        	 for(int i=0;i<k;i++){
        		 subList_1.add(subList.get(i));
        	 }
        	 list.add(subList_1);
        	 return ;
         }
         else if(index<=k-2){
        	 for(int i=subList.get(index);i<=9;i++){
        		 subList.set(index, i);
	        	 remainder = remainder - i;
	        	 if(remainder <= i)
	        		 break;
	        	 else{
	        		 subList.add(index+1,i+1);
	        		 helper(list,subList,index+1,k,remainder);
	        		 subList.remove(index+1);
	        	 }
	        	 remainder = remainder + i;
        	 }
         }
	}

}
