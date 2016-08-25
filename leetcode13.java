public class Solution {
    public int romanToInt(String s) {
        	     String[][] c2={
	        		{"","I","II","III","IV","V","VI","VII","VIII","IX"},
	                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
	                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
	                {"","M","MM","MMM"}
	        };
	        
		int len=s.length();
		StringBuffer[] c=new StringBuffer[4];  
		 for(int i=0;i<c.length ;i++){
		        c[i] = new StringBuffer();
		    } 
		
		for(int i=0;i<len;i++){
			if(i<len && s.charAt(i)=='M'){
				while(i<len && s.charAt(i)=='M'){  //千位
					c[3].append(s.charAt(i));
					i++;
				}
			}
			if(i<len && (s.charAt(i)=='C' || s.charAt(i)=='D')){ //百位
				while(i<len && (s.charAt(i)=='C' || s.charAt(i)=='D' || s.charAt(i)=='M')){
					c[2].append(s.charAt(i));
					i++;
				}
					
			}
			if(i<len && (s.charAt(i)=='X' || s.charAt(i)=='L')){ //十位
				while(i<len && (s.charAt(i)=='X' || s.charAt(i)=='L' || s.charAt(i)=='C')){
					c[1].append(s.charAt(i));
				    i++;
				}
			}
			if(i<len && (s.charAt(i)=='I' || s.charAt(i)=='V')){
				while(i<len && (s.charAt(i)=='I' || s.charAt(i)=='V' || s.charAt(i)=='X')){
					c[0].append(s.charAt(i));
					i++;
				}
			}
		}
		int result=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<10;j++){
				if(c2[i][j].equals(c[i].toString()))
					result=(int)Math.pow(10, i)*j+result;
			}
		}
		for(int i=0;i<4;i++){
			if(c2[3][i].equals(c[3].toString()))
				result=result+i*1000;
		}
		return result;
    }
}
