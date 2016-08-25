public class Solution {
    public boolean isValidSerialization(String preorder) {
        int length = preorder.length(); //得到字符串的长度
	        if(length==1)
		    	return preorder.equals("#");
		    	
	        int low=0;
	        int high=0;
	        
	        while(high<length){    //找到第一个逗号
	        	if(preorder.charAt(high)!=',')
	        		high++;
	        	else{
	        		high++;
	        		break;
	        	}
	        }
	        int flag=0; //用来标记high走过了多少个逗号
	        	while(low<high && high<length){
	        		low++;
	        		if(preorder.charAt(low)==',' && preorder.charAt(low-1)!='#'){
	        			while(high<length){
	        				if(high<length-1 && flag!=2){
	        					high++;
	        					if(preorder.charAt(high)==',')
	        						flag++;
	        				}
	        				else if(flag==2 && high<length-1){
	        					flag=0;
	        					high++;
	        					break;
	        				}
	        				else if(high==length-1){ //当high走到字符串的尽头，判断low和high之间有没有非空节点
	        					if(flag==0)
	        						return false;
	        					
	        					while(low<=high){
	        						if(preorder.charAt(low)!=',' && preorder.charAt(low)!='#')
	        							return false;
	        						low++;
	        					}
	        					return true;
	        				}
	        			}
	        		}
	        }
        	if(low==high && high<=length-1)
    			return false;
    		else 
    			return true;
    }
}
