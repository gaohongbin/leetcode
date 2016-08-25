public class Solution {
    public boolean isHappy(int n) {
        if(n==0)
        return false;
        
        int result=0;
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        while(n>0){
            result=result+(n%10)*(n%10);
            n=n/10;
            if(n==0){
                if(result==1)
                return true;
               else if(set.contains(result) )
                 return false;
               else if(!set.contains(result)){
                set.add(result);
                n=result;
                result=0;
               }
            }
                
        }
        return true;
    }
}
