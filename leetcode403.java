/**
 * 题目：有一只青蛙想要过河，如果上次跳了k的长度，则下次跳的步长只能为k-1,k,k+1三种情况。给出的参数为一个int数组，里面的数字为小河中石头的位置，每次
 * 必须落在石头上面，而且第一次只能跳长度为1. 请问青蛙能否最终到达数组最右边的石头上。
 * 
 * 思路：动态规划
 *
 * @author: hongbin.gao
 *
 */

public class Leetcode403 {
	public static void main(String[] args){
		int[] stones =new int[1000];
		boolean result = canCross(stones);
		System.out.println(result);
	}
	
	public static boolean canCross(int[] stones) {
		if(stones == null)  
        	return false;
        if(stones.length <= 1)
        	return true;
        if(stones[1] != 1)
            return false;
        
        int length = stones.length;
        if(stones[length-1] >(length/2)*(length-1))  //每一次都跳最长，也不可能到达的情况。
        	return false;
        
        return helper(stones,1,1);
    }
	/**
	 * 
	 * @Package:leetcode
	 * @method:@param stones:题目的参数
	 * @method:@param pos:现在处于stones[pos]
	 * @method:@param stepLength:前一步跳了多长
	 * @method:@return
	 * 创建人:hongbin.gao
	 */
	public static boolean helper(int[] stones, int pos, int stepLength){
		if(pos == stones.length-1)
			return true;
		
		int step1 = stepLength-1;
		int step2 = stepLength;
		int step3 = stepLength+1;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		
		for(int i=pos+1;i<stones.length;i++){
			if(step1>0 && stones[i] - stones[pos] == step1){
				flag1 = helper(stones,i,step1);
				if(flag1)
					return true;
			}
			if(step2>0 && stones[i] - stones[pos] == step2){
				flag2 = helper(stones,i,step2);
				if(flag2)
					return true;
			}
			if(step3>0 && stones[i] - stones[pos] == step3){
				flag3 = helper(stones,i,step3);
				if(flag3)
					return true;
				break;
			}
		}
		
		if(flag1 || flag2 || flag3)
			return true;
		return false;
	}

}
 
