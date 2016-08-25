public class Solution {
    public boolean wordPattern(String pattern, String str) {
       int len = pattern.length();
	        
	        
	        String[] arrayOfstr = str.split(" ");
	        int lenOfStr=arrayOfstr.length;
	        if(len!=lenOfStr)
	        	return false;
	        Map<Character,String> map =new HashMap<Character,String>();
	        
	        char temp;
	        for(int i=0;i<len;i++){
	        	temp=pattern.charAt(i);
	          if(map.containsKey(temp)==false && map.containsValue(arrayOfstr[i])==false)
	        	  map.put(temp, arrayOfstr[i]);
	          if(map.containsKey(temp)==false && map.containsValue(arrayOfstr[i])==true)
	        	  return false;
	          if(map.containsKey(temp)==true && !map.get(temp).equals(arrayOfstr[i]))
	        	  return false;
	        }
	        return true;
    }
}
