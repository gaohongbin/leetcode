public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1=nums1.length;
		int len2=nums2.length;
		if(len1==0 || len2==0)
			return new int[0];
		
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        List<Integer> list = new ArrayList<Integer>();
	        int i=0,j=0;
	        
	        while(i<len1 && j<len2){
	        	if(nums1[i]==nums2[j]){
	        		list.add(nums1[i]);
	        		i++;
	        		j++;
	        	}
	        	else if(nums1[i]>nums2[j])
	        		j++;
	        	else
	        		i++;
	        }
	        int result[]=new int[list.size()];
	        if(list.size()==0)
	        	return new int[0];
	        else
	        	for(int k=0;k<list.size();k++){
	        		result[k]=list.get(k);
	        	}
	        return result;
	    }
    
}
