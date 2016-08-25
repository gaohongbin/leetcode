public class Solution {
    public boolean isAnagram(String s, String t) {
         int lengthOfS=s.length();
	        int lengthOfT=t.length();
	        
	        if(lengthOfS!=lengthOfT)
	        	return false;
	        
	        if(lengthOfS==0 && lengthOfT==0)
	        	return true;
	        
	        Map<Character,Integer> mapOfS=new HashMap<Character,Integer>();
	        Map<Character,Integer> mapOfT=new HashMap<Character,Integer>();
	        
	        for(int i=0;i<lengthOfS;i++){
	        	if(mapOfS.get(s.charAt(i))==null)
	        		mapOfS.put(s.charAt(i), 1);
	        	else
	        		mapOfS.put(s.charAt(i), mapOfS.get(s.charAt(i))+1);
	        	
	        	if(mapOfT.get(t.charAt(i))==null)
	        		mapOfT.put(t.charAt(i), 1);
	        	else
	        		mapOfT.put(t.charAt(i), mapOfT.get(t.charAt(i))+1);
	        }
	        if(mapOfT.equals(mapOfS)==true)
	        	return true;
	        else 
	        	return  false;
    }
}
