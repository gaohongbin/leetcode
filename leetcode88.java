public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         if(n==0) //当nums2为空时
		    	return ;
		    if(m==0){  //nums1为空时
		    	for(int i=0;i<n;i++){
		    		nums1[i]=nums2[i];
		    	}
		    	return ;
		    }
		    //nums1和nums2都不为空时
	        for(int i=m-1;i>=0;i--){ //把nums1往后移动了n个位置
	        	nums1[i+n]=nums1[i];
	        }
	        
	        int len1=n,len2=0,k=0;  //将nums2插入到nums1中
	        while(len1<m+n && len2<n){
	        	if(nums1[len1]<nums2[len2])
	        		nums1[k++]=nums1[len1++];
	        	else
	        		nums1[k++]=nums2[len2++];
	        }
	        if(len1==m+n){
	        	while(len2<n)
	        		nums1[k++]=nums2[len2++];
	        	return ;
	        }
	        else
	        	while(len1<m+n)
	        		nums1[k++]=nums1[len1++];
	            return ;
    }
}
