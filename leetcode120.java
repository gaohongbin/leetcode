/**
 * 题目：找和最小的从上到下的一条路径
 * 
 * 思路： 两个int数组，mid1和mid2， mid1用来0-i行加完后的结果，mid2用来存储mid1加上list<Integer>后的结果，再把mid2复制到mid1里面去。
 * 一直如此循环。到最后mid1里面存储的是所有列表相加完成后的结果。然后从里面找出最小的一个数。就是结果。
 *
 * @author hongbin.gao
 *
 */

public class Leetcode120 {
	public static void main(String[] args){
		List<Integer> list_1 = new ArrayList<Integer>();
		list_1.add(2);
		
		List<Integer> list_2 = new ArrayList<Integer>();
		list_2.add(3);
		list_2.add(4);
		
		List<Integer> list_3 = new ArrayList<Integer>();
		list_3.add(6);
		list_3.add(5);
		list_3.add(7);
		
		List<Integer> list_4 = new ArrayList<Integer>();
		list_4.add(4);
		list_4.add(1);
		list_4.add(8);
		list_4.add(3);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(list_1);
		list.add(list_2);
		list.add(list_3);
		list.add(list_4);
		
		int result = minimumTotal(list);
		System.out.println(result);
		
	}
	
	 public static int minimumTotal(List<List<Integer>> triangle) {
		 if(triangle == null)
			 return 0;
		 if(triangle.size() ==1)
			 return triangle.get(0).get(0);
		 
		 int[] mid1 = new int[triangle.size()];
		 int[] mid2 = new int[triangle.size()];
		 for(int i=0;i<mid2.length;i++){
			 mid2[i] = Integer.MAX_VALUE;
		 }
		 
		 mid1[0] = triangle.get(0).get(0);
		 List<Integer> subList;
		 for(int i = 1;i<triangle.size();i++){
			 subList = triangle.get(i);
			 for(int j=0;j<i;j++){
				 if(mid1[j]+subList.get(j) < mid2[j])
					 mid2[j] = mid1[j]+subList.get(j);
				 if(mid1[j] + subList.get(j+1) < mid2[j+1])
					 mid2[j+1] = mid1[j] + subList.get(j+1);
			 }
			 
			 for(int j=0;j<mid2.length;j++){
				 mid1[j] = mid2[j];
				 mid2[j] = Integer.MAX_VALUE;
			 }
		 }
		 
		 int min = mid1[0];
		 for(int i=1;i<mid1.length;i++)
			 if(mid1[i]<min)
				 min = mid1[i];
		 return min;
	 }
} 
