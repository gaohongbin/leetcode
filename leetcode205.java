public class Solution {
    public boolean isIsomorphic(String s, String t) {
          int len=s.length();
	        if(len==0)
	        	return true;
	        
	       Map<Character,Character> map = new HashMap<Character,Character>();
	       char temp;
	       for(int i=0;i<len;i++){
	    	   temp=s.charAt(i);
	    	   if(map.containsKey(temp) && map.get(temp)!=t.charAt(i))
	    			 return false;
	    	   if(!map.containsKey(temp) && map.containsValue(t.charAt(i)))
	    	        return false;
	    	   else
	    		   map.put(s.charAt(i), t.charAt(i));
	       }
	       return true;
    }
}
