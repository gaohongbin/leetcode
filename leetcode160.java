/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
          if(headA==null || headB==null)
	        	return null;
	        if(headA==headB)
	        	return headA;
	       ListNode p1=headA,p2=headB;
	       int lengthA=1;
	       int lengthB=1;
	       while(p1.next!=null){
	    	   lengthA++;
	    	   p1=p1.next;
	       }
	       while(p2.next!=null){
	    	   lengthB++;
	    	   p2=p2.next;
	       }
	       if(p1!=p2)      //p1,p2均指向最后一个节点，若最后一个节点不一样，则没有交叉
	    	   return null;
	       
	       int len=0;
	       if(lengthA>lengthB){
	    	   len=lengthA-lengthB;
	    	   p1=headB;          //p1指向较短链表
	    	   p2=headA;         //p2指向较长链表
	       }
	       else{
	    	   len=lengthB-lengthA;
	    	   p1=headA;
	    	   p2=headB;
	       }
	       
	       while(len>0){
	    	   p2=p2.next;
	    	   len--;
	       }
	       
	       while(p1!=null && p2!=null){
	    	   if(p1==p2)
	    		   return p1;
	    	   p1=p1.next;
	    	   p2=p2.next;
	       }
	    	
	       return null;
    }
}

