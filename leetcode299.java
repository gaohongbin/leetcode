public class Solution {
    public String getHint(String secret, String guess) {
        int len=secret.length();
	        if(len==0)
	        	return "0A0B";
	        
	        int[] numInSecret = new int[10];
	        int[] numInGuess = new int[10];
	        
	        int same=0;
	        StringBuffer strOfSecret = new StringBuffer(secret);
	        StringBuffer strOfGuess = new StringBuffer(guess);
	        
	        for(int i=0;i<len;i++){
	        	if(strOfSecret.charAt(i)==strOfGuess.charAt(i))
	        		same++;
	        	numInSecret[strOfSecret.charAt(i)-'0']++;
	        	numInGuess[strOfGuess.charAt(i)-'0']++;
	        }
	        int errorLocation=0;
	        for(int i=0;i<10;i++){
	        	errorLocation+=numInSecret[i]<numInGuess[i]?numInSecret[i]:numInGuess[i];
	        }
	        
	        return same+"A"+(errorLocation-same)+"B";
    }
}
