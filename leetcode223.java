public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
       int area1=(C-A)*(D-B);
	        int area2=(G-E)*(H-F);
	        int area3=0;
	        if(E>=C || F>=D || G<=A || H<=B)
	        	area3=0;
	        else
	           area3=((C>G?G:C)-(A>E?A:E))*((D>H?H:D)-(B>F?B:F));
	        return area1+area2-area3;
    }
}
