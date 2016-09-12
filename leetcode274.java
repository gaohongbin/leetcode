public class Leetcode274 {
	public static void main(String[] args){
		int[] citations = {0,1,3,5,6};
		int result =  hIndex_2(citations);
		System.out.println(result);
		}
	/**
	 * 方法一：题目中提示的答案，先排序，在从末尾往前，例如3,0,6,1,5排完后为0,1,3,5,6.
	 * 只要满足length-i<=citations[i] 则result++，最后返回result。
     * 
     */	 
	public static int hIndex_1(int[] citations) {
		if(citations == null ||  citations.length == 0)
			return 0;
   		Arrays.sort(citations);
		int length = citations.length;
		int result = 0;
		for(int i=length-1;i>=0;i--){
			if(length-i<=citations[i])
				result++;
			else
				break;
		}
		return result;
	}
	/**
	 * 方法二：哈希算法,将数组中的数映射到hash表中。
	 * 用一个result[citations.length+1]来表示，当某片文章的访问次数超过length-1，result[length]++,
	 * result[length]表示访问次数超过总文章数(length)的文章的个数。这些文章是肯定要算在结果里面的。
	 * result[i] = j; 表示访问次数为i的文章个数为j。
     * 
     */
	public static int hIndex_2(int[] citations) {
		if(citations == null ||  citations.length == 0)
			return 0;
		int length = citations.length;
		int[] result = new int[length+1];
		for(int i = 0;i<length;i++){
			if(citations[i]>=length)
				result[length]++;
		else
				result[citations[i]]++;
		}
		int num = 0;
	for(int i = length;i>=0;i--){
			num += result[i];  //num为文章的个数，i访问的次数
			if(num > i){
				return num-result[i]>i?num-result[i]:i;
			}
		}
	return 0;
	}
}
