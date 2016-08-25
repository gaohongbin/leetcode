public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
         int[] weight=new int[32] ;
	     weight[0]=1;
	     
	     for(int i=1;i<32;i++){   //直接用长度为32的int数组来保存权重
	    	 weight[i]=2*weight[i-1];
	     }
	     
         char[] bitsOfInt=new char[32]; //保存n的各位
         for(int i=0;i<32;i++ ){
        	 if(((n>>i)&1)==1){
        		 bitsOfInt[i]='1';
        	 }
         }
         
         char temp;
         for(int i=0;i<16;i++){  //对bitsOfInt进行调换
        	 temp=bitsOfInt[i];
        	 bitsOfInt[i]=bitsOfInt[31-i];
        	 bitsOfInt[31-i]=temp;
         }
         
         int result=0;
         for(int i=0;i<32;i++){
        	 if(bitsOfInt[i]=='1')
        		 result+=weight[i];
         }
         return result;
    }
}
