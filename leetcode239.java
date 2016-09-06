/**
* 题目：给定一个数组，一个窗口在数组中移动，将窗口移动的过程中，窗口中最大的数组成的数组返回，nums为给定的数组，k为给定的窗口的长度。
*
*
*
*/

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       if(nums == null || nums.length == 0){  //nums不和规范，直接返回
			int[] result = new int[0];
			return result;
		}
		
		int[] result = new int[nums.length-k+1];  //用来存储要返回的结果
		int length = 0;  //length表示result的指针，用来表示result下一个要填充的位置。
		
		int low = 0;  
		int high = k-1; //两个指针，分别 表示window的边界
		
		int max = nums[0];  //max用来保存一定范围内的最大数
		int index = -1;   //index是max的下标
		while(high<nums.length){
			if(index == -1){  //index为初始的-1时
				for(int i=low;i<=high;i++){
					if(nums[i]>=max){  
						max = nums[i];
						index = i;
					}
				}
				result[length] = max;
				length++;
			}
			else{  //如果index不为-1，则有三种情况:(1)high++后，nums[high]>=max,这时候无论index在不在window内，替换max。
				//(2):high++后，max在window内，并且nums[high]<max,则直接将max放入result即可，length++
				//(3):high++后，max不在window内，则要遍历现在window内的数据，查找新的max和index。
				if(nums[high]>=max){
					max = nums[high];
					index = high;
					result[length] = max;
					length++;
				}
				else if(nums[high]<max && index>=low){
					result[length] = max;
					length++;
				}
				else if(nums[high]<max && index<low){  //当当前window里面的所有的数都小于max
					max = nums[low];
					index = low;
					for(int i=low;i<=high;i++){
						if(nums[i]>=max){
							max = nums[i];
							index = i;
						}
					}
					result[length] = max;
					length++;
				}
			}
			low++;
			high++;
		}
		return result;
    }
}
