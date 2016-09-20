/**
 * 题目：表的时间用灯表示。  时针表示：[8,4,2,1].  分针表示：[32,16,8,4,2,1];  参数为int num.
 * 求所有用num个灯可能表示出的时间。  h:[0-11]  m:[00-59]
 * 
 * 思路：最终还是组合。  当时针有m个灯时，在[8,4,2,1]求出随机选择m个数的所有组合情况。 分针也一样。
 * 当时针和分针的灯的个数加起来为num时，将其拼接输出。
 * 
 *
 * @author: hongbin.gao
 *
 */
public class Leetcode401 {
	public static void main(String[] args) {
		int num = 1;
		List<String> result = readBinaryWatch(num);
		System.out.println(result);
	}
	
	public static List<String> readBinaryWatch(int num) {
		int[] hour = {8,4,2,1};
		int[] minute = {32,16,8,4,2,1};
		List<String> result = new ArrayList<String>();
		
		List<String> hourList = new ArrayList<String>();
		List<String> minuteList = new ArrayList<String>();
		
		List<Integer> mid1 = new ArrayList<Integer>(); //hourList的辅助数列
		List<Integer> mid2 = new ArrayList<Integer>(); //minuteList的辅助数列
		
		StringBuffer strBuf  = new  StringBuffer();
		if(num <=4){
			for(int i=num;i>=0;i--){
				mid1.clear();
				hourList.clear();
				helper(hour,0,i,hourList,mid1,false);
				
				mid2.clear();
				minuteList.clear();
				helper(minute,0,num - i, minuteList,mid2,true);
				
				for(int j=0;j<hourList.size();j++){
					strBuf.append(hourList.get(j)+":00");
					for(int k=0;k<minuteList.size();k++){
						strBuf.replace(strBuf.length()-2, strBuf.length(), minuteList.get(k)+"");
						result.add(strBuf.toString());
					}
					strBuf.setLength(0);
				}
			}
		}
		
		if(num >=5 && num <=6){
			for(int i=4;i>=0;i--){
				mid1.clear();
				hourList.clear();
				helper(hour,0,i,hourList,mid1,false);
				
				mid2.clear();
				minuteList.clear();
				helper(minute,0,num - i, minuteList,mid2,true);
				
				for(int j=0;j<hourList.size();j++){
					strBuf.append(hourList.get(j)+":00");
					for(int k=0;k<minuteList.size();k++){
						strBuf.replace(strBuf.length()-2, strBuf.length(), minuteList.get(k)+"");
						result.add(strBuf.toString());
					}
					strBuf.setLength(0);
				}
			}
		}
		
		if(num >=7){
			for(int i=4;i>=num-6;i--){
				mid1.clear();
				hourList.clear();
				helper(hour,0,i,hourList,mid1,false);
				
				mid2.clear();
				minuteList.clear();
				helper(minute,0,num - i, minuteList,mid2,true);
				
				for(int j=0;j<hourList.size();j++){
					strBuf.append(hourList.get(j)+":00");
					for(int k=0;k<minuteList.size();k++){
						strBuf.replace(strBuf.length()-2, strBuf.length(), minuteList.get(k)+"");
						result.add(strBuf.toString());
					}
					strBuf.setLength(0);
				}
			}
		}
		
        return result;
    }
	/**
	 * 
	 * 
	 * @Package:leetcode
	 * @method:@param nums
	 * @method:@param pos
	 * @method:@param k
	 * @method:@param list
	 * @method:@param subList
	 * @method:@param flag  flag为true，则字符串为 00,01; 如果flag为false,字符串为0,1.
	 * @return
	 */
	public static void helper(int[] nums, int pos, int k,List<String> list, List<Integer> subList, boolean flag){
		if(k==0 && flag){
			int sum = 0;
			for(int i=0;i<subList.size();i++){
				sum += subList.get(i);
			}
			if(sum == 60)
				return ;
			StringBuffer strBuf = new StringBuffer();
			if((sum+"").length()<2)
				strBuf.append("0"+sum);
			else
				strBuf.append(sum+"");
			list.add(strBuf.toString());
			strBuf.setLength(0);
			return ;
		}
		if(k == 0 && !flag){
			int sum = 0;
			for(int i=0;i<subList.size();i++){
				sum += subList.get(i);
			}
			if(sum == 12)
				return ;
			list.add(sum+"");
			return ;
		}
		
		if(pos>=nums.length)
			return ;
		
		subList.add(nums[pos]);   //加pos位置的值
		helper(nums, pos+1, k-1,list, subList,flag);
		subList.remove(subList.size()-1);
		
		helper(nums,pos+1,k,list,subList,flag);  //不加pos位置的值
		return ;
	}

}
