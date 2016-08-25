public class Solution {
  public static int compareString(String version1, String version2){  //比较长度相同的两个字符串
		int length=version1.length();
		if(length==0)
			return 0;
		for(int i=0;i<length;i++){
			if(version1.charAt(i)>version2.charAt(i))
				return 1;
			if(version1.charAt(i)<version2.charAt(i))
				return -1;
		}
		return 0;
	}
	
	public static int compareVersion(String version1, String version2) {
	       
		    String[] ver1;
		    String[] ver2;
		      
		    ver1 = version1.split("\\.");
		    ver2 = version2.split("\\.");
		    
		    
		    for(int i=0;i<ver1.length;i++){  //ver1消去前面多余的0
		    	ver1[i]=ver1[i].replaceFirst("^0*", "")+"";
		    }
		    for(int i=0;i<ver2.length;i++){ //ver2消去前面多余的0
		    	ver2[i]=ver2[i].replaceFirst("^0*", "")+"";
		    }
		    
		    int len=ver1.length>ver2.length?ver2.length:ver1.length;
             
		    for(int i=0;i<len;i++){
		        if(ver1[i].length()>ver2[i].length())
			    	return 1;
			    if(ver1[i].length()<ver2[i].length())
			    	return -1;
			    if(ver1[i].length()==ver1[i].length()){
			    	if(compareString(ver1[i], ver2[i])==1)
			    		return 1;
			    	if(compareString(ver1[i], ver2[i])==-1)
			    		return -1;
			    }
		    }
		    
			if(ver1.length==ver2.length)
				return 0;
			if(ver1.length>ver2.length){
				for(int i=len;i<ver1.length;i++)
					if(!ver1[i].equals(""))
						return 1;
			   
			}
				
			if(ver1.length<ver2.length){
				for(int i=len;i<ver2.length;i++)
					if(!ver2[i].equals(""))
						return -1;
					
			}
			return 0;
	    }
}
